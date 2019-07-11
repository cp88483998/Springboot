package com.warm.system.controller;

import com.warm.common.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Discription:
 * @ClassName: CommonController
 * @Author: ChenPeng
 * @Date: Created in 16:04 2019/7/4
 * @Version: 1.0
 */
@Controller
public class CommonController extends BaseController{

    @GetMapping(value = {"/403", "/401"})
    public String noSource() {
        return "403";
    }

    @RequestMapping("/login/unauthorized")
    public String unauthorized(){
        return "unauthorized";
    }
}
