package com.ng.demo.service.impl;

import com.ng.demo.dao.BlogDao;
import com.ng.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Intellij IDEA.
 * User:  ng
 * Date:  2020/3/23
 */
@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogDao blogDao;
    @Override
    public int upLoadBlog(int blogId, String blogText){
        return blogDao.upLoadBlog(blogId,blogText);
    }
}
