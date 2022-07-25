package com.rjs.mybatis.test;

import com.rjs.mybatis.mapper.CacheMapper;
import com.rjs.mybatis.pojo.Emp;
import com.rjs.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author: 软件手
 * @date: 2022/7/25 9:13
 * @description:
 */
public class CacheMapperTest {


    // 1级缓存默认开启 统一 sqlSession
    @Test
    public void testCache(){
        SqlSession sqlSession1 = SqlSessionUtils.getSqlSession();
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        Emp emp1 = mapper1.getEmpByEid(1);
        System.out.println(emp1);

        SqlSession sqlSession2 = SqlSessionUtils.getSqlSession();
        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
        Emp emp2 = mapper2.getEmpByEid(1);
        System.out.println(emp2);
    }

}
