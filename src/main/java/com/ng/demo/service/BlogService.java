package com.ng.demo.service;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

/**
 * Created by Intellij IDEA.
 * User:  ng
 * Date:  2020/3/23
 */
public interface BlogService {
    int upLoadBlog(Integer blogBelongerId, String blogText, String date);
}

