package com.senpure.base.annotation;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface PermissionVerify {
    /**
     * 是否开启检查
     * @return
     */
    boolean verify()default true;

    /**
     * 是否开启检查登陆
     * @return
     */
    boolean login() default  true;
    int [] perssionId();
    /**
     * 为true是表示全部验证通过
     * @return
     */
    boolean allVerify() default false;



}
