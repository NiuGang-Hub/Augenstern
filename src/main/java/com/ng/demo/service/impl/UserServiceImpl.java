package com.ng.demo.service.impl;

import com.ng.demo.dao.UserDao;
import com.ng.demo.pojo.User;
import com.ng.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Intellij IDEA.
 * User:  ng
 * Date:  2020/3/6
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User selectByUserName(String userName ){
        return userDao.selectByUserName(userName);
    }

    @Override
    public int addUser(String userName, String passWord) {
        return userDao.addUser(userName,passWord);
    }
}
