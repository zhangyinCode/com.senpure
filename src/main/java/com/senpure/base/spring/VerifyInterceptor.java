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
import com.senpure.base.service.URIPermissionService;
import com.senpure.base.struct.LoginedAccount;
import com.senpure.base.util.Http;
import com.senpure.base.vo.AccountVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
               // ResultHelper.wrapMessage(result,)
                log.info("由于在其他地方登陆，该次请求中断,跳转登陆界面");
             //   afterLogin(request, result, false);
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
            } else if (!verify.verify()) {
                log.debug("{} > {}", request.getRequestURI(), "检测关闭");

            }
            boolean pass = false;
            boolean all = verify.allVerify();
            String[] permissions = verify.permissions();
            List<Permission> needPermissions = new ArrayList<>();
            if (permissions.length == 0) {
                List<URIPermission> uriPermissions = uriPermissionService.loadURIPermissions(request.getRequestURI() + "_" + method.getMethod().getName());
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

                    // TODO:  权限检查
                    pass = true;
                    if (pass && !all) {

                        break;
                    } else if (!pass && all) {
                        break;
                    }
                } else if (permission.getType().equals(AppConstant.PERMISSION_TYPE_OWNER)) {
                    // TODO: 资源所属认证，权限检查
                    pass = true;
                    if (pass && !all) {

                        break;
                    } else if (!pass && all) {
                        break;
                    }
                }
            }
            if (pass) {
                //  log.warn("{} 没有权限 {} > {}",account.getName(),request.getMethod(),request.getRequestURI());
                return false;
            }
        }

        return true;
    }
}
