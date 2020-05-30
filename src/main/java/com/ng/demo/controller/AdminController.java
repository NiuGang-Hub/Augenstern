package com.ng.demo.controller;


import com.ng.demo.enums.ResultEnum;
import com.ng.demo.enums.StateEnums;
import com.ng.demo.pojo.Admin;
import com.ng.demo.token.UsernamePasswordToken;
import com.ng.demo.utils.JsonResult;
import com.ng.demo.utils.ShiroUtils;
import com.ng.demo.utils.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;

import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by Intellij IDEA.
 * 管理员的登录处理
 *
 * @author  ng
 * Date:  2020/5/26
 */

@RestController
@RequestMapping("/admin")
public class AdminController {
    @PostMapping("/login")
    public JsonResult<Object> login(@RequestBody Admin admin) {

        if (admin == null || StringUtils.isBlank(admin.getUsername()) || StringUtils.isBlank(admin.getPassword())) {
            return new JsonResult<>(ResultEnum.PARAMS_NULL.getCode(), "用户名或密码错误！");
        }
        Subject subject = SecurityUtils.getSubject();
        AuthenticationToken authenticationToken = new UsernamePasswordToken(admin.getUsername(), admin.getPassword(), StateEnums.ADMIN.getCode());
        try {
            subject.login(authenticationToken);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult<>(ResultEnum.PARAMS_NULL.getCode(), "用户名或密码错误！");
        }
        // 登录成功
        Serializable sessionId = subject.getSession().getId();
        Map<String, Object> returnMap = new HashMap<>(2);
        returnMap.put("token", sessionId);
        return new JsonResult<>(returnMap);
    }

    @GetMapping("/info")
    public JsonResult<Admin> getLoginAdnin(){
        Admin admin = (Admin) ShiroUtils.getLoginUser();
        admin.setPassword("");
        return new JsonResult<>(admin);
    }
}
