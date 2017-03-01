package com.senpure.base.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.senpure.base.criterion.LoginCriteria;
import com.senpure.base.result.ResultMap;
import com.senpure.base.service.AuthorizeService;
import com.senpure.base.spring.BaseController;
import com.senpure.base.struct.LoginedAccount;
import com.senpure.base.util.Http;
import com.senpure.base.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Map;

/**
 * Created by Administrator on 2017/1/20.
 */
@Controller
@RequestMapping("/")
public class LoginController extends BaseController {
    private static String cookieAesKey = "senpure123456789";
    private static  String cookieKey="senpure";
    @Autowired
    private AuthorizeService authorizeService;
    //String view="helloWorld";
    String view="authorize/login";
    @RequestMapping(value = { "authorize/login","" })
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response, @Valid @ModelAttribute("criteria") LoginCriteria criteria, BindingResult result) {
       log.debug("login method");
        if (result.hasErrors()) {
            log.warn("验证不通过");
          //  Exception exception=new Exception();
           // log.error("",exception);
            return addFormatIncorrectResult(request, result, new ModelAndView(view));
        }
        boolean readCookie = false;
        boolean checkLogin = false;
        Boolean b = (Boolean) request.getAttribute("checkLogin");
        if (b != null) {
            checkLogin = b;
        }
        // 贮备进入登陆页面,检查cookie，如果有就自行登陆
        log.trace("checkLogin=" + checkLogin);
        if (criteria.getAccount() == null) {
            String account = null;
            String password = null;
            if (checkLogin) {
                Cookie[] cookie = request.getCookies();
                if (cookie != null) {
                    for (Cookie c : cookie) {
                        if (c.getName().equals(cookieKey)) {
                            try {
                                JSONObject json = JSON.parseObject(StringUtil.aesDecrypt(c.getValue(), cookieAesKey));
                                account = json.getString("account");
                                password = json.getString("password");
                                readCookie = true;
                            } catch (Exception e) {
                                log.error("解析cookie 失败:" + c.getValue(), e);
                            }
                            break;

                        }
                    }
                }
            }
            if (account != null && password != null) {
                log.debug("检测到cookie值:account=" + account + ",passwrod:" + password);
                criteria.setAccount(account);
                criteria.setPassword(password);
                criteria.setLoginType("COOKIE");
            }
            //
            else {
                log.trace("不用检查cookie或没有检查到cookie，直接返回登陆页面");
                criteria.setRemember(true);
                ResultMap r = (ResultMap) request.getAttribute("args");
                if (r != null)
                    return addActionResult(request, new ModelAndView("authorize/login"), r);
                return new ModelAndView("authorize/login");
            }

        }


          ResultMap resultMap= authorizeService.login(criteria);
        if(resultMap.isSuccess())
        {
            LoginedAccount loginedAccount= (LoginedAccount) resultMap.get("account");
            Http.setSubject(request,loginedAccount);
            if (criteria.isRemember()) {
                JSONObject json = new JSONObject();
                json.put("account", criteria.getAccount());
                json.put("password", criteria.getPassword());
                json.put("time", System.currentTimeMillis());

                String jsonStr = json.toJSONString();
                log.debug("json:" + jsonStr);
                jsonStr = StringUtil.aesEncrypt(jsonStr, cookieAesKey);
                Cookie cookie = new Cookie(cookieKey, jsonStr);
                cookie.setPath("/");
                // 一周
                cookie.setMaxAge(60 * 60 * 24 * 7);

                response.addCookie(cookie);
            } else {
                //
                if (!readCookie) {
                    Cookie cookie = new Cookie(cookieKey, "");
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
            String toURI = null;
            Object o = Http.getFromSession(request, "loginToURI");
            if (o != null) {
                Http.removeFromSession(request, "loginToURI");
                String uri = (String) o;
                toURI = "redirect:" + uri;
            }
            toURI = toURI == null ? "redirect:/home" : toURI;
            if (!Http.isAjaxRequest(request)) {
                Boolean c = (Boolean) request.getAttribute("loginReferer");
                if (c != null && c) {
                    Http.setToSession(request, "loginReferer", true);

                } else {
                    Http.setToSession(request, "loginReferer", false);
                }
                return new ModelAndView(toURI);
            }
            return addActionResult(request, new ModelAndView(toURI), resultMap);
        }
        // 如果cookie方式登陆失败，当做没用登陆一样,并移除cookie
        if (readCookie) {
            // 移除cookie
            Cookie cookie = new Cookie(cookieKey, "");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
            criteria.setRemember(true);
            Map<String, Object> args;
            args = (Map<String, Object>) request.getAttribute("args");
            return new ModelAndView("authorize/login", args);
        }
        return addActionResult(request,new ModelAndView(view),resultMap);
    }


}
