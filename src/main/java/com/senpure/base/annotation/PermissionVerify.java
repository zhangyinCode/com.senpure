package com.senpure.base.annotation;


import java.lang.annotation.*;

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
    String [] permissions() default {};

    /**
     * 为true是表示全部验证通过
     * @return
     */
    boolean allVerify() default false;

    /**
     * 资源所有认证，该字段用于自动生成
     * @return
     */
    String resourceVerifyName() default  "";


}
