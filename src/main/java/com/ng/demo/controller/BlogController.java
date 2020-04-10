package com.ng.demo.controller;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.mysql.cj.util.Util;
import com.ng.demo.model.Blog;
import com.ng.demo.model.User;
import com.ng.demo.service.BlogService;
import com.ng.demo.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Intellij IDEA.
 * User:  ng
 * Date:  2020/3/22
 */
@RestController
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping("/uploadblog")
    private JsonResult<Blog> upBlog(@RequestParam("blog")String blogText, HttpServletRequest request){

        HttpSession session =  request.getSession();
        User user= (User) session.getAttribute("user");

        blogService.upLoadBlog(user.getUserId(),blogText, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        return new JsonResult<Blog>("200","保存成功");
    }
}
