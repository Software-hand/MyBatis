package com.rjs.mybatis.test;

import com.rjs.mybatis.mapper.DeptMapper;
import com.rjs.mybatis.mapper.DynamicSQLMapper;
import com.rjs.mybatis.pojo.Emp;
import com.rjs.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author: 软件手
 * @date: 2022/7/24 20:12
 * @description:
 */
public class DynamicSQLMapperTest {

    /*
    * 动态SQL
    * 1、if:根据标签中test属性所对应的表达式决定标签中的内容是否需要拼接到SQL中
    * */

    @Test
    public void testGetEmpByCondition(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        // List<Emp> list = mapper.getEmpByCondition(new Emp(null, "张三", 23, "男", "123@qq.com"));
        // List<Emp> list = mapper.getEmpByCondition(new Emp(null, "张三", null, "男", "123@qq.com"));
        List<Emp> list = mapper.getEmpByCondition(new Emp(null, null, 23, "男", "123@qq.com"));
        System.out.println(list);

    }
}
