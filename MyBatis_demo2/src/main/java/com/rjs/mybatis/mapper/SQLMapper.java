package com.rjs.mybatis.mapper;

import com.rjs.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: 软件手
 * @date: 2022/7/23 23:52
 * @description:
 */
public interface SQLMapper {

    // 1、根据用户名模糊查询用户信息
    List<User> getUserByLike(@Param("username") String username);

    // 2、批量删除
    int deleteMore(@Param("ids") String ids);

    // 3、查询指定表中的数据
    List<User> getUserByTableName(@Param("tableName") String tableName);

    // 4、添加用户信息
    void insertUser(User user);


}
