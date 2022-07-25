package com.rjs.mybatis.mapper;

import com.rjs.mybatis.pojo.Emp;
import java.util.List;

public interface EmpMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_emp
     *
     * @mbggenerated Mon Jul 25 10:41:47 CST 2022
     */
    int deleteByPrimaryKey(Integer eid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_emp
     *
     * @mbggenerated Mon Jul 25 10:41:47 CST 2022
     */
    int insert(Emp record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_emp
     *
     * @mbggenerated Mon Jul 25 10:41:47 CST 2022
     */
    Emp selectByPrimaryKey(Integer eid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_emp
     *
     * @mbggenerated Mon Jul 25 10:41:47 CST 2022
     */
    List<Emp> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_emp
     *
     * @mbggenerated Mon Jul 25 10:41:47 CST 2022
     */
    int updateByPrimaryKey(Emp record);
}