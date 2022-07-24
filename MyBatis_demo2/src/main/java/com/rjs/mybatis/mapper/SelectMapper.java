package com.rjs.mybatis.mapper;

import com.rjs.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author: 软件手
 * @date: 2022/7/23 23:00
 * @description:
 */
public interface SelectMapper {

    // 1、根据id查询用户信息
    // User getUserById(@Param("id") Integer id);
    List<User> getUserById(@Param("id") Integer id);

    // 2、查询所有用户信息
    List<User> getAllUser();

    // 3、查询用户信息的总记录数
    Integer getCount();

    // 4、根据id查询用户信息为一个map集合
    Map<String, Object> getUserByIdToMap(@Param("id") Integer id);

    // 5、查询所有用户信息为map集合
    List<Map<String, Object>> getAllUserToMap();
    /*@MapKey("id")
    Map<String, Object> getAllUserToMap();*/



}
