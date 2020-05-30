package com.ng.demo.mapper;

import com.ng.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Intellij IDEA.
 * User:  ng
 * Date:  2020/3/6
 */
@Mapper
public interface UserDao {

    User selectByUserName(String userName);
    int addUser(String userName,String passWord);

}
