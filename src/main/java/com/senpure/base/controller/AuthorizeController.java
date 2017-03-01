package com.senpure.base.controller;

import com.senpure.base.util.Assert;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/3/1.
 */
@Controller
@RequestMapping("/authorize")
public class AuthorizeController {

    @RequestMapping(value = "/notallow")
    public  void notPermission()
    {

        Assert.error("权限不足。");
    }

}
