package com.senpure.base.controller;

import com.senpure.base.criterion.AccountCriteria;
import com.senpure.base.spring.BaseController;
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
    //String view="helloWorld";
    String view="authorize/login";
    @RequestMapping(value = { "authorize/login","" })
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response, @Valid @ModelAttribute("criteria") AccountCriteria criteria, BindingResult result) {

       log.debug("login method");
        if (result.hasErrors()) {
            log.warn("验证不通过");
          //  Exception exception=new Exception();
           // log.error("",exception);

            return addFormatIncorrectResult(request, result, new ModelAndView(view));
        }
        log.debug("login  return");
        return new ModelAndView(view);
    }

}
