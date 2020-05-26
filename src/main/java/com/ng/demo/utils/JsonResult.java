package com.ng.demo.utils;


import com.ng.demo.enums.ResultEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by Intellij IDEA.
 *
 * @author  ng
 * Date:  2020/5/26
 */
@Data
public class JsonResult<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;

    public JsonResult() {
        this.code = ResultEnum.SUCCESS.getCode();
        this.msg = ResultEnum.SUCCESS.getMsg();
    }

    public JsonResult(String msg) {
        this.code = ResultEnum.SUCCESS.getCode();
        this.msg = msg;
    }

    public JsonResult(T data) {
        this.code = ResultEnum.SUCCESS.getCode();
        this.msg = ResultEnum.SUCCESS.getMsg();
        this.data = data;
    }

    public JsonResult(String msg, T data) {
        this.code = ResultEnum.SUCCESS.getCode();
        this.msg = msg;
        this.data = data;
    }

    public JsonResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public JsonResult(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
    }

    public JsonResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

}
