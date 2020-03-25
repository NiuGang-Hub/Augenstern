package com.ng.demo.dao;

import com.ng.demo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

/**
 * Created by Intellij IDEA.
 * User:  ng
 * Date:  2020/3/6
 */
@Mapper
public interface UserDao {

    User selectByUserName(String userName);
    User selectByUserId(String Id,String passWord);
    int addUser(String userName,String passWord);

}
