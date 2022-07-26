package com.rjs.mybatis.mapper;

import com.rjs.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

/**
 * @author: 软件手
 * @date: 2022/7/24 8:40
 * @description:
 */
public interface DeptMapper {

    // 3、通过分步查询，查询员工以及员工所对应的部门信息
    // 分布查询第二步：通过did查询员工所对应部门
    Dept getEmpAndDeptByStepTwo(@Param("did") Integer did);

    // 1、获取部门以及部门中所有的员工信息
    Dept getDeptAndEmp(@Param("did") Integer did);

    // 2、通过分步查询，查询部门以及部门中所有的员工信息
    // 分步查询第一步：查询部门信息
    Dept getDeptAndEmpByStepOne(@Param("did") Integer did);

}
