package com.rjs.mybatis.mapper;

import com.rjs.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author: 软件手
 * @date: 2022/7/22 10:00
 * @description:
 */
public interface ParameterMapper {

    // 验证登录(使用@Param)
    User checkLoginByParam(@Param("username") String username, @Param("password") String password);

    // 添加用户信息
    int insertUser(User user);

    // 验证登录(参数为map)
    User checkLoginByMap(Map<String, Object> map);

    // 验证登录
    User checkLogin(String username,String password);

    // 根据用户名查询用户信息
    User getUserByUsername(String username);

    // 查询所有员工信息
    List<User> getAllUser();
}
