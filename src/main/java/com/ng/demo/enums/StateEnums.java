package com.ng.demo.enums;

/**
 * 状态码枚举，
 * Created by Intellij IDEA.
 *
 * @author  ng
 * Date:  2020/5/26
 */
public enum StateEnums {
    /**
     * 逻辑删除状态
     */

    DEL(1,"已删除"),
    NOT_DEL(0,"未删除！"),

    /**
     * 启用状态
     */

    ENABLED(1,"启用"),
    NOT_ENABLED(2,"未启用！"),

    /**
     *性别状态
     */

    SEX_MAN(1,"男"),
    SEX_WOMAN(2,"女"),
    ;

    private Integer code;
    private String msg;

    StateEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
