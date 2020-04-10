package com.ng.demo.dao;

import com.ng.demo.model.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

/**
 * Created by Intellij IDEA.
 * User:  ng
 * Date:  2020/3/23
 */
@Mapper
public interface BlogDao {
    int upLoadBlog(Integer blogBelongerId, String blogText, String date);
}
