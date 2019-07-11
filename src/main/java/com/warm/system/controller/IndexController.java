package com.warm.system.controller;


import java.util.List;

import com.warm.common.base.controller.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.warm.system.entity.UserInfo;
import com.warm.system.service.IUserInfoService;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author dgd123
 * @since 2018-02-10
 */
@Controller
public class IndexController extends BaseController {
    @Autowired
    private IUserInfoService iUserInfoService;

    @RequestMapping("/user")
    @ResponseBody
    public ResponseEntity<List<UserInfo>> getUserList() {
        return ResponseEntity.ok(this.iUserInfoService.getUserList());
    }


    /**
     * 跳转登录页面
     * @return
     */
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/test")
    @RequiresPermissions(value = {"test"})
    public String test(){
        return "test";
    }

    @RequestMapping("/test1")
    @RequiresPermissions(value = {"test1"})
    public String test1(){
        return "test1";
    }
}

