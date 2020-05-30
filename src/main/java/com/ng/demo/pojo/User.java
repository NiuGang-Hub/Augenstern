package com.ng.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;


import java.io.Serializable;
/**
 * Created by Intellij IDEA.
 * User:  ng
 * Date:  2020/3/6
 */
@Data
//<!--resultMap返回pojo必须得有无参构造方法-->
//<!--resultType返回pojo必须得有全参构造方法-->
@AllArgsConstructor
public class User implements Serializable {

    private Integer userId;
    private String userName;
    private String passWord;
}
