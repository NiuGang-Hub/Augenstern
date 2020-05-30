package com.ng.demo.controller;

import com.ng.demo.enums.ResultEnum;
import com.ng.demo.pojo.User;
import com.ng.demo.service.UserService;
import com.ng.demo.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Intellij IDEA.
 * User:  ng
 * Date:  2020/3/23
 * <p>
 * 该类方法是为了防止前端
 */
@RestController
public class PageController {
    @Autowired
    public UserService userService;

    @GetMapping("/index")
    public JsonResult<User> index() {

        return new JsonResult<>(ResultEnum.SUCCESS.getCode(), "访问成功");

    }
}
