package com.rjs.mybatis.mapper;

import com.rjs.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

/**
 * @author: 软件手
 * @date: 2022/7/25 9:10
 * @description:
 */
public interface CacheMapper {

    Emp getEmpByEid(@Param("eid") Integer eid);

    void insertEmp(Emp emp);
}
