package com.senpure.base.spring;


import com.senpure.AppConstant;
import com.senpure.base.result.Result;
import com.senpure.base.result.ResultHelper;
import com.senpure.base.result.ResultMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseController {
    protected Logger log;
    public BaseController() {
        log= LogManager.getLogger(getClass());
    }
    protected LocaleResolver localeResolver;

    public LocaleResolver getLocaleResolver() {
        return localeResolver;
    }

    @Autowired
    @Qualifier("localeResolver")
    public void setLocaleResolver(LocaleResolver localeResolver) {
        this.localeResolver = localeResolver;
    }
    protected ModelAndView addFormatIncorrectResult(HttpServletRequest request, BindingResult result,
                                                    ModelAndView modelAndView) {
       // LocaleContextHolder.getLocale();
        return modelAndView.addObject(AppConstant.ACTION_RESULT_MODEL_VIEW_KEY, formatIncorrectResult(request, result));
    }
    private ResultMap formatIncorrectResult(HttpServletRequest request, BindingResult result) {
        List<ObjectError> es = result.getAllErrors();
        List<Map<String,String>> validators=new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0, l = es.size(), t = l - 1; i < l; i++) {
            ObjectError e = es.get(i);
            Object[] args=e.getArguments();
            MessageSourceResolvable sr= (MessageSourceResolvable) args[0];
            String codes[]=sr.getCodes();
            Map<String,String> validator=new HashMap();
            validator.put(codes[codes.length-1],e.getDefaultMessage());
            validators.add(validator);
            log.trace(e);
            sb.append(e.getDefaultMessage());
            if (i < t) {
                sb.append("\n");
            }
        }
        ResultMap rm = ResultMap.getResult(Result.FORMAT_INCORRECT);
        rm.put(ResultMap.VALIDATOR_KEY,validators);
        ResultHelper.wrapMessage(rm, localeResolver.resolveLocale(request));
        return rm;
    }
}
