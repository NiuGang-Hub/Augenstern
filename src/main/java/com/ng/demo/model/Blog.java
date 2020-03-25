package com.ng.demo.model;

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
    private Date blogCreateTime;

    public Blog(Integer blogId, String blogText, Integer blogBelongerId, Date blogCreateTime) {
        this.blogId = blogId;
        this.blogText = blogText;
        this.blogBelongerId = blogBelongerId;
        this.blogCreateTime = blogCreateTime;
    }

    public Integer getBlogBelongerId() {
        return blogBelongerId;
    }

    public void setBlogBelongerId(Integer blogBelongerId) {
        this.blogBelongerId = blogBelongerId;
    }

    public Date getBlogCreateTime() {
        return blogCreateTime;
    }

    public void setBlogCreateTime(Date blogCreateTime) {
        this.blogCreateTime = blogCreateTime;
    }

    public String getBlogText() {
        return blogText;
    }

    public void setBlogText(String blogText) {
        this.blogText = blogText;
    }


    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

}
