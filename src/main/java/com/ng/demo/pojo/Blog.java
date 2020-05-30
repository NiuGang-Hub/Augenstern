package com.ng.demo.pojo;

import lombok.Data;

/**
 * Created by Intellij IDEA.
 * User:  ng
 * Date:  2020/3/22
 */
@Data
public class Blog {

    private Integer blogId;
    private String blogText;
    private Integer blogBelongerId;
    private String blogCreateTime;


}
