package com.ng.demo.controller;


import com.ng.demo.enums.ResultEnum;
import com.ng.demo.pojo.Blog;
import com.ng.demo.pojo.User;
import com.ng.demo.service.BlogService;
import com.ng.demo.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;


@RestController
/**
        * Created by Intellij IDEA.
        * @author ng
        * Date:  2020/3/22
        */
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping("/uploadblog")
    private JsonResult<Blog> upBlog(@RequestParam("blog")String blogText){

        System.out.println(blogText);
        blogService.upLoadBlog(null,blogText, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        return new JsonResult<Blog>(ResultEnum.SUCCESS.getCode(),"保存成功");
    }

    @GetMapping("/selectblog")
    private JsonResult<Blog> selectblog(@RequestParam("blogId")String blogText, HttpServletRequest request){

        return new JsonResult<Blog>(ResultEnum.SUCCESS.getCode(),"保存成功");
    }
}
