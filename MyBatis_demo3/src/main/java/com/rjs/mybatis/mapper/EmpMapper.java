package com.rjs.mybatis.mapper;

import com.rjs.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: 软件手
 * @date: 2022/7/24 8:39
 * @description:
 */
public interface EmpMapper {

    // 1、查询所有的员工信息
    List<Emp> getAllEmp();

    // 2、查询员工以及员工所对应的部门信息
    Emp getEmpAndDept(@Param("eid") Integer eid);


    // 3、通过分步查询，查询员工以及员工所对应的部门信息
    // 分布查询第一步：查询员工信息
    Emp getEmpAndDeptByStepOne(@Param("eid") Integer eid);
}
