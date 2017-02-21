package com.senpure.base.controller;

import com.senpure.base.criterion.LoginCriteria;
import com.senpure.base.result.ResultMap;
import com.senpure.base.service.AuthorizeService;
import com.senpure.base.spring.BaseController;
import com.senpure.base.struct.LoginedAccount;
import com.senpure.base.util.Http;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Created by Administrator on 2017/1/20.
 */
@Controller
@RequestMapping("/")
public class LoginController extends BaseController {
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
       ResultMap resultMap= authorizeService.login(criteria);
        if(resultMap.isSuccess())
        {
            LoginedAccount loginedAccount= (LoginedAccount) resultMap.get("account");

            Http.setSubject(request,loginedAccount);
        }
        return addActionResult(request,new ModelAndView(view),resultMap);
    }

}
