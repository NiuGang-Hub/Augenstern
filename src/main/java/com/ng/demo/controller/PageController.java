package com.ng.demo.controller;

import com.ng.demo.enums.ResultEnum;
import com.ng.demo.pojo.User;
import com.ng.demo.utils.JsonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Intellij IDEA.
 * User:  ng
 * Date:  2020/3/23
 *
 * 该类方法是为了防止前端
 */
@RestController
public class PageController {
    @GetMapping("/index")
    public JsonResult<User> index(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(user == null)
            return new JsonResult<>(ResultEnum.NOT_LOGIN.getCode(),"访问失败，请登录后查看");
        else {
            System.out.println(user.getUserName()+"访问了首页");
            return new JsonResult<>(ResultEnum.SUCCESS.getCode(),"访问成功");}
    }
}
