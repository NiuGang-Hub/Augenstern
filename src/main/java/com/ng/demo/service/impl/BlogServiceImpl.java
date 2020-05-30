package com.ng.demo.service.impl;

import com.ng.demo.mapper.BlogDao;
import com.ng.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

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
    public int upLoadBlog(Integer blogBelongerId, String blogText, String date) {
        String BlogText =HtmlUtils.htmlEscapeDecimal(blogText);
        return blogDao.upLoadBlog(blogBelongerId,BlogText,date);
    }
}
