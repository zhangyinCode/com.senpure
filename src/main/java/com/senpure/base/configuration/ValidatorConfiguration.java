package com.senpure.base.configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Administrator on 2017/1/22.
 */
@Configuration

public class ValidatorConfiguration extends WebMvcConfigurerAdapter {
    Logger log = LogManager.getLogger(ValidatorConfiguration.class);

    //@Autowired
   // MessageSource messageSource;

    @Override
    public Validator getValidator() {

        LocalValidatorFactoryBean validator= new    org.springframework.validation.beanvalidation.LocalValidatorFactoryBean();
        validator.setProviderClass(org.hibernate.validator.HibernateValidator.class);

       // ReloadableResourceBundleMessageSource source=new ReloadableResourceBundleMessageSource();
        ResourceBundleMessageSource source=new ResourceBundleMessageSource();
       // source.setBasename("classpath:i18n/validate/validate");
        source.setBasenames("i18n/validate/validate");

       // log.info(" 注册messageSource"+messageSource);
        //validator.setValidationMessageSource(messageSource);
        log.info(" 注册messageSource"+source);
       validator.setValidationMessageSource(source);

        return validator;
    }



}
