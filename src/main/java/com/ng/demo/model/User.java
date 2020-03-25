package com.ng.demo.model;

/**
 * Created by Intellij IDEA.
 * User:  ng
 * Date:  2020/3/6
 */

public class User {

    private Integer userId;
    private String userName;
    private String passWord;

    //mybatis是以构造方法传值所以必须要有构造方法
    public  User(Integer userId,String userName,String passWord){
        this.userName = userName;
        this.passWord = passWord;
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }
}
