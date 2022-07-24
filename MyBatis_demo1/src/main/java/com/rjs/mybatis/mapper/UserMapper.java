package com.rjs.mybatis.mapper;

import com.rjs.mybatis.pojo.User;

import java.util.List;

/**
 * @author: 软件手
 * @date: 2022/7/22 0:59
 * @description:
 */
public interface UserMapper {
    /*
    * MyBatis面向接口编程的两个一致
    * 1、映射文件的namespace要和mapper接口的全类名一致
    * 2、映射文件中SQL语句的id要和mapper接口中的方法一致
    *
    * 表--实体类--mapper接口--映射文件
    *  */

    /*
    * 添加用户信息
    * */
    int insertUser();

    // 修改
    int updateUser();

    // 删除
    void deleteUser();

    // 查询一个实体类对象，根据id
    User getUserById();

    // 查询所有的用户信息
    List<User> getAllUser();

}
