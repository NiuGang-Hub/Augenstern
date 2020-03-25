package com.ng.demo.controller;


import com.ng.demo.model.Blog;
import com.ng.demo.service.BlogService;
import com.ng.demo.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    private JsonResult<Blog> upBlog(@RequestParam("blog")String blogText){
        blogService.upLoadBlog(15,blogText);
        return new JsonResult<Blog>("200","保存成功");
    }
}
