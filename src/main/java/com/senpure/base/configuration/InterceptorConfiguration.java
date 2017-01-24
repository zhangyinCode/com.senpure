package com.senpure.base.configuration;

import com.senpure.base.spring.MultipleInterceptor;
import com.senpure.base.spring.URLInfoInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Administrator on 2017/1/20.
 */
@Configuration
public class InterceptorConfiguration  extends WebMvcConfigurerAdapter{

    @Autowired
    private URLInfoInterceptor urlInfoInterceptor;
    @Autowired
    private MultipleInterceptor multipleInterceptor;
    public InterceptorConfiguration() {
        super();
    }
    public void addInterceptors(InterceptorRegistry registry) {

        // 多个拦截器组成一个拦截器链

        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截

          registry.addInterceptor(urlInfoInterceptor);
          registry.addInterceptor(multipleInterceptor).excludePathPatterns("/resources/**");

        super.addInterceptors(registry);

    }
}
