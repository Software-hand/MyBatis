package com.rjs.mybatis.test;

import com.rjs.mybatis.mapper.CacheMapper;
import com.rjs.mybatis.pojo.Emp;
import com.rjs.mybatis.utils.SqlSessionUtils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

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
        CacheMapper mapper = sqlSession1.getMapper(CacheMapper.class);
        Emp emp1 = mapper.getEmpByEid(1);
        System.out.println(emp1);
        // 清空缓存
        sqlSession1.clearCache();
        // mapper.insertEmp(new Emp(null,"abc",23,"男","123@qq.com"));
        Emp emp2 = mapper.getEmpByEid(1);
        System.out.println(emp2);
        // sqlSession1.close();



//        SqlSession sqlSession2 = SqlSessionUtils.getSqlSession();
//        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
//        Emp emp2 = mapper2.getEmpByEid(1);
//        System.out.println(emp2);
    }

    @Test
    public void testTwoCache(){

        try {
            InputStream is = Resources.getResourceAsStream("mybatis-conf.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            // 同一个 sqlSessionFactory
            SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
            CacheMapper mapper = sqlSession1.getMapper(CacheMapper.class);
            System.out.println(mapper.getEmpByEid(1));
            sqlSession1.close();

            SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
            CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
            System.out.println(mapper2.getEmpByEid(1));
            sqlSession2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
