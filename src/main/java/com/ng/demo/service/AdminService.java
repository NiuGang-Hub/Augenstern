package com.ng.demo.service;

import com.ng.demo.pojo.Admin;

/**
 * Created by Intellij IDEA.
 *
 * @author  ng
 * Date:  2020/5/26
 */
public interface AdminService {
    /**
     * 根据用户名查询
     * @param userName
     * @return
     */
     Admin getByUsername(String userName);
}
