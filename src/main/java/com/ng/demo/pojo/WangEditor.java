package com.ng.demo.pojo;

/**
 * Created by Intellij IDEA.
 * User:  ng
 * Date:  2020/3/20
 */
import java.util.Arrays;

public class WangEditor {

    private Integer errno; //错误代码，0 表示没有错误。
    private String[] data; //已上传的图片路径



    public Integer getErrno() {
        return errno;
    }
    public void setErrno(Integer errno) {
        this.errno = errno;
    }
    public String [] getData() {
        return data;
    }
    public void setData(String [] data) {
        this.data = data;
    }
    @Override
    public String toString() {
        return "WangEditor [errno=" + errno + ", data=" + Arrays.toString(data)
                + "]";
    }


}

