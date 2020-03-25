package com.ng.demo.dao;

import com.ng.demo.model.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Intellij IDEA.
 * User:  ng
 * Date:  2020/3/23
 */
@Mapper
public interface BlogDao {
    int upLoadBlog(int blogId, String blogText);
}
