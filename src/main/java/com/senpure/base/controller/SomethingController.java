package com.senpure.base.controller;

import com.senpure.base.annotation.PermissionVerify;
import com.senpure.base.spring.BaseController;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/2/6.
 */
@Controller
public class SomethingController extends BaseController {



    @RequestMapping("/something")
    @PermissionVerify(resourceVerifyName = "somethingResource")
    public Object addSomething(HttpRequest request)
    {

        return  null;
    }
}
