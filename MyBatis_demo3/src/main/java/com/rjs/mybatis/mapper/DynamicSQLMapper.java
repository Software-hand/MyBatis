package com.rjs.mybatis.mapper;

import com.rjs.mybatis.pojo.Emp;

import java.util.List;

/**
 * @author: 软件手
 * @date: 2022/7/24 20:02
 * @description:
 */
public interface DynamicSQLMapper {

    // 多条件查询
    List<Emp> getEmpByCondition(Emp emp);

}
