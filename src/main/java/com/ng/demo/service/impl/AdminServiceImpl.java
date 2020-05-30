package com.ng.demo.service.impl;

import com.ng.demo.mapper.AdminMapper;
import com.ng.demo.pojo.Admin;
import com.ng.demo.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Intellij IDEA.
 *
 * @author  ng
 * Date:  2020/5/26
 */
@Service
@Slf4j
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;
    @Override
    public Admin getByUsername(String userName) {
        return adminMapper.getByUsername(userName);
    }
}
