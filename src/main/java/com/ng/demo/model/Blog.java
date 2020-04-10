package com.ng.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created by Intellij IDEA.
 * User:  ng
 * Date:  2020/3/22
 */
public class Blog {

    private Integer blogId;
    private String blogText;
    private Integer blogBelongerId;

    private String blogCreateTime;

    public Blog(Integer blogId, String blogText, Integer blogBelongerId, String blogCreateTime) {
        this.blogId = blogId;
        this.blogText = blogText;
        this.blogBelongerId = blogBelongerId;
        this.blogCreateTime = blogCreateTime;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getBlogText() {
        return blogText;
    }

    public void setBlogText(String blogText) {
        this.blogText = blogText;
    }

    public Integer getBlogBelongerId() {
        return blogBelongerId;
    }

    public void setBlogBelongerId(Integer blogBelongerId) {
        this.blogBelongerId = blogBelongerId;
    }

    public String getBlogCreateTime() {
        return blogCreateTime;
    }

    public void setBlogCreateTime(String blogCreateTime) {
        this.blogCreateTime = blogCreateTime;
    }
}
