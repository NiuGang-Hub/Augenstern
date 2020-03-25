package com.ng.demo.service;

import com.ng.demo.model.User;

/**
 * Created by Intellij IDEA.
 * User:  ng
 * Date:  2020/3/6
 */
public interface UserService {

     User selectByUserName(String userName );
     int addUser(String userName,String passWord);
}
