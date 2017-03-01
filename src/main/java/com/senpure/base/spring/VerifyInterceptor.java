package com.senpure.base.spring;

import com.senpure.AppConstant;
import com.senpure.base.annotation.PermissionVerify;
import com.senpure.base.entity.Permission;
import com.senpure.base.entity.URIPermission;
import com.senpure.base.result.Result;
import com.senpure.base.result.ResultHelper;
import com.senpure.base.result.ResultMap;
import com.senpure.base.service.AuthorizeService;
import com.senpure.base.service.PermissionService;
import com.senpure.base.service.ResourcesVerifyService;
import com.senpure.base.service.URIPermissionService;
import com.senpure.base.struct.LoginedAccount;
import com.senpure.base.util.Http;
import com.senpure.base.util.StringUtil;
import com.senpure.base.vo.AccountVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/7.
 */
@Component
public class VerifyInterceptor extends InterceptorSupport {
    private String loginURI = "/authorize/login";
    @Autowired
    private URIPermissionService uriPermissionService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private AuthorizeService authorizeService;
    @Autowired
    private ResourcesVerifyService resourcesVerifyService;
    @Autowired
    @Qualifier("localeResolver")
    protected LocaleResolver localeResolver;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.trace("handler is {}", handler);
        LoginedAccount account = Http.getSubject(request);
        if (account != null) {
            AccountVo accountVo = authorizeService.loadAccount(account.getId());
            boolean login = account.getLoginTime() < accountVo.getLoginTime() && !account.getLoginIP().equals(accountVo.getIp());
            if (login) {
                RequestDispatcher dispatcher = request.getRequestDispatcher(loginURI);
                ResultMap result = ResultMap.getResult(Result.ACCOUNT_OTHER_LOGIN);
               ResultHelper.wrapMessage(result,localeResolver.resolveLocale(request));
                log.info("由于在其他地方登陆，该次请求中断,跳转登陆界面");
                afterLogin(request, result, false);
                dispatcher.forward(request, response);
                return false;
            }
        }
        HandlerMethod method = null;
        if (handler instanceof HandlerMethod) {
            method = (HandlerMethod) handler;
        }
        if (method != null) {
            PermissionVerify verify = method.getMethodAnnotation(PermissionVerify.class);
            log.debug("method.getMethodAnnotation(PermissionVerify.class) is {}", verify);
            if (verify == null) {
                log.debug("{} > {}", request.getRequestURI(), "不需要任何权限检查");
                return true;
            } else if (!verify.verify()) {
                log.debug("{} > {}", request.getRequestURI(), "检测关闭");
                return true;
            }

            else if(verify.login()&&account==null)
            {
                log.debug("{} > {}", request.getRequestURI(), "没有登陆或者登陆超时");
                ResultMap result = ResultMap.getResult(Result.ACCOUNT_NOT_LOGIN_OR_SESSION_TIMEOUT);
                RequestDispatcher dispatcher = request.getRequestDispatcher(loginURI);
                ResultHelper.wrapMessage(result,localeResolver.resolveLocale(request));
                //ajax请求不检查cookiez
                afterLogin(request, result, !Http.isAjaxRequest(request));
                dispatcher.forward(request, response);
                return false;
            }
            boolean pass = false;
            boolean all = verify.allVerify();
            String[] permissions = verify.permissions();
            List<Permission> needPermissions = new ArrayList<>();
            if (permissions.length == 0) {//代码里面没有配置，采用默认约定
                List<URIPermission> uriPermissions = uriPermissionService.loadURIPermissions(request.getRequestURI() + "->" + method.getMethod().getName());
                //  uriPermissionService.l
                for (URIPermission uriPermission : uriPermissions) {
                    needPermissions.add(uriPermission.getPermission());
                }
            } else {
                for (String permissionName : permissions) {
                    Permission permission = permissionService.loadPermission(permissionName);
                    needPermissions.add(permission);
                }
            }
            for (Permission permission : needPermissions) {
                if (permission.getType().equals(AppConstant.PERMISSION_TYPE_IGNORE)) {
                    pass = true;
                    if (!all) {
                        break;
                    }
                } else if (permission.getType().equals(AppConstant.PERMISSION_TYPE_NORMAL)) {
                    pass = hasPermission(account, permission);
                    if (pass && !all) {
                        break;
                    } else if (!pass && all) {
                        break;
                    }
                } else if (permission.getType().equals(AppConstant.PERMISSION_TYPE_OWNER)) {

                  String uri=request.getRequestURI();
                  int index=StringUtil.indexOf(uri,"/",1,true);
                  Serializable resourceId=uri.substring(index+1);
                  log.debug("resourceId = {0}",resourceId);
                     pass=  resourcesVerifyService.verify(permission.getResourceVerifyName(),account.getId(),resourceId);
                    if(pass)
                    {
                        hasPermission(account,permission);
                    }
                    if (pass && !all) {

                        break;
                    } else if (!pass && all) {
                        break;
                    }
                }
            }
            if (!pass) {
                log.warn("{} 没有权限 {} > {}", account.getAccount(), request.getMethod(), request.getRequestURI());
                RequestDispatcher dispatcher = request.getRequestDispatcher("/authorize/notallow");
                dispatcher.forward(request, response);

                return false;
            }
        }

        return true;
    }

    private boolean hasPermission(LoginedAccount account, Permission permission) {
        int size = account.getPermissions().size();

        for (int i = 0; i < size; i++) {

            if (account.getPermissions().get(i).getId() == permission.getId()) {
                return true;
            }
        }
        if(account.getAccount().equalsIgnoreCase(AppConstant.PROJECT_NAME))
        {
            return true;
        }
        return false;
    }
    private void afterLogin(HttpServletRequest request, ResultMap result, boolean checkLogin) {
        request.setAttribute("checkLogin", checkLogin);
        request.setAttribute("args", result);
        if (request.getMethod().equalsIgnoreCase("get")) {
            String uri = request.getRequestURI();
            //uri = uri.substring(uri.indexOf("/"), 2);
            log.debug("get 请求，登陆后直接重定向....,uri=" + uri);
            Http.setToSession(request, "loginToURI", uri);
        } else {
            String referer = request.getHeader("referer");
            if (referer != null) {
                log.debug("从" + referer + "进入，登陆后，调用浏览器，返回该页面");
                //Http.set(request, "loginReferer", true);
                request.setAttribute("loginReferer", true);
            }
//		String uri = request.getRequestURI();
//		uri = uri.substring(uri.indexOf("/", 2));
//		log.debug("post请求，登陆后同样直接访问.,会出现参数缺失情况...,uri=" + uri);
//		Http.set(request, "loginToURI", uri);
        }
    }
}
