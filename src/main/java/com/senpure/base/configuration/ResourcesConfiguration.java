package com.senpure.base.configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Administrator on 2017/1/22.
 */
@Configuration

public class ResourcesConfiguration extends WebMvcConfigurerAdapter {
    Logger log = LogManager.getLogger(ResourcesConfiguration.class);


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("classpath:/resources/");
    }
}
