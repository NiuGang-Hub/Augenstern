package com.ng.demo.mapper;

import com.ng.demo.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;


/**
 * Created by Intellij IDEA.
 *
 * @author  ng
 * Date:  2020/5/26
 */
@Mapper
public interface AdminMapper {
    Admin getByUsername(String userName);
}
