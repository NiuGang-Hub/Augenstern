package com.ng.demo.enums;


import lombok.Getter;

/**
 * Created by Intellij IDEA.
 *
 * @author  ng
 * Date:  2020/5/26
 */

@Getter
public enum ResultEnum {

    /*
     * 返回的状态码枚举，一个枚举代表一个请求返回状态
     * */

    SUCCESS(2000, "操作成功！"),
    ERROR(4000, "操作失败！"),
    DATA_NOT_FONUD(40001, "查询失败！"),
    PARAMS_NULL(40002,"参数不能为空！"),

    NOT_LOGIN(40003,"当前账号未登录！")
    ;

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
