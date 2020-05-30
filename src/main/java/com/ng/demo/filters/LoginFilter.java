package com.ng.demo.filters;

import com.alibaba.fastjson.JSONObject;
import com.ng.demo.enums.ResultEnum;
import com.ng.demo.utils.JsonResult;
import org.apache.shiro.web.filter.authc.UserFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @Author: 杨德石
 * @Date: 2020/2/16 16:49
 * @Version 1.0
 */
public class LoginFilter extends UserFilter {

    /**
     * 这个方法用于处理未登录时页面重定向的逻辑
     * 因此，只要进入了这个方法，就意味着登录失效了
     * 我们只需要在这个方法里，给前端返回一个登录失效的状态码即可
     * @param request
     * @param response
     * @throws IOException
     */
    @Override
    protected void redirectToLogin(ServletRequest request, ServletResponse response) throws IOException {
        response.setContentType("application/json; charset=utf-8");
        response.getWriter().write(JSONObject.toJSONString(new JsonResult<>(ResultEnum.NOT_LOGIN)));
    }
}
