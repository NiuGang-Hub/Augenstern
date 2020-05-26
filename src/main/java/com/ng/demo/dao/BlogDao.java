package com.ng.demo.dao;

import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Intellij IDEA.
 * User:  ng
 * Date:  2020/3/23
 */
@Mapper
public interface BlogDao {
    int upLoadBlog(Integer blogBelongerId, String blogText, String date);
}
