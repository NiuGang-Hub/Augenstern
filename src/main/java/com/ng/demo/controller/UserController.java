package com.ng.demo.controller;


import com.ng.demo.pojo.User;
import com.ng.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Created by Intellij IDEA.
 * User:  ng
 * Date:  2020/3/6
 */
@RestController
@CrossOrigin

public class UserController {


    //注入serviece bean
    @Autowired
    public UserService userService;

    /**
     * 方法名称 login 返回值json  入参（String ，String）
     *
     * 1.查看session中是否有值 User 有则提示已经登录 ，没有就 根据@RequestParam过来的值进行登录操作
     * 2.先进行查询 看看该用户是否存在，不存在提示  "用户不存在" 并返回错误代码 401 交前台处理
     * 3.用户存在且账号密码*不正确*  提示  "密码错误"   并返回错误代码 401 交前台处理
     * 4.账号密码核对无误 ，将User传入session中记录，并在session.getAttribute("user")加上统一的标识user提示  "登陆成功" 并返回正确代码 200 交前台处理 ，
     *
     * **************特别注意*************
     *
     * 一定是登录成功才能在session中添加User，不然就会出现用户并未登录成功，但提示"您已经登录了，不要重复登录啦！"
     */
    @PostMapping("/login")
    public JsonResult<User> login(@RequestParam("userName") String userName, @RequestParam("passWord") String passWord, HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            return new JsonResult<>("401", "您已经登录了，不要重复登录啦！");
        }
        User user = userService.selectByUserName(userName);


        if (user == null) {
            return new JsonResult<>("401", "用户不存在");
        } else if (user.getPassWord().equals(passWord)) {
            session.setAttribute("user", user);
            return new JsonResult<>("200", "登陆成功");
        } else return new JsonResult<>("401", "密码错误");
    }


    /**
     * 方法名称 logout 返回值json  入参（）
     *
     * 1.检查session.getAttribute("user");的返回值是否为空 空则为未登录   提示 "您还没有登录呢！"，并返回401错误代码交前台处理
     * 2.不为空则 session.invalidate(); 清空所有信息   提示"退出成功"， 并返回200正确代码交前台处理
     */
    @GetMapping("/logout")
    public JsonResult<User> logout(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null) {
            System.out.println(user.getUserName()+"退出");
            session.invalidate();
            return new JsonResult<>("200", "退出成功");
        } else return new JsonResult<>("401", "您还没有登录呢！");
    }


    /**
     * 方法名称 logout 返回值json  入参（String , String）
     *
     * 因为是个人博客，没打算开放注册接口，先写下以后考虑开放
     *
     *
     * 1.取值，调接口 成功返回提示 "注册成功" ，并返回200成功代码交前台处理
     * （ps 其实应该先查下数据库里有么有存在这个用户名的用户）
     */

    @PostMapping(value = "/add")
    public JsonResult<User> addUser(@RequestParam("userName") String userName, @RequestParam("passWord") String passWord) {
        userService.addUser(userName, passWord);
        User user = userService.selectByUserName(userName);
        if (user != null)
            return new JsonResult<>("200", "注册成功");
        else return new JsonResult<>("401", "注册失败");
    }
}

