package com.rjs.mybatis.test;

import com.rjs.mybatis.mapper.UserMapper;
import com.rjs.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class MyBatisTest {

    /*
    * sqlSession默认不自动提交事务，若需要自动提交事务
    * 可以使用 SqlSession sqlSession = sqlSessionFactory.openSession(true);
    * 而不写sqlSession.commit();
    * */

    @Test
    public void testMyBatis() throws IOException {
        // 加载核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-conf.xml");
        // 获取sqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 获取sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        // 获取SqlSession                            自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        // 获取mapper接口对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 测试功能
        int result = mapper.insertUser();
        // 提交事务 !!!
        // sqlSession.commit();
        System.out.println("result:"+result);

    }

    // 修改
    @Test
    public void testUpdate() throws IOException {
        // 加载核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-conf.xml");
        // 获取sqlSessionFactoryBuilder
        // SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 获取sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 获取SqlSession                            自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        // 获取mapper接口对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 测试功能
        int result = mapper.updateUser();
        // 提交事务 !!!
        // sqlSession.commit();
        System.out.println("result:"+result);

    }

    // 删除
    @Test
    public void testDelete() throws IOException {
        // 加载核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-conf.xml");
        // 获取sqlSessionFactoryBuilder
        // SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 获取sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 获取SqlSession                            自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        // 获取mapper接口对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 测试功能
        mapper.deleteUser();

    }

    // 查询一个实体
    @Test
    public void testSelect() throws IOException {
        // 加载核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-conf.xml");
        // 获取sqlSessionFactoryBuilder
        // SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 获取sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 获取SqlSession                            自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        // 获取mapper接口对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 测试功能
        User user = mapper.getUserById();
        System.out.println(user);

    }

    // 查询一个集合
    @Test
    public void testSelectAll() throws IOException {
        // 加载核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-conf.xml");
        // 获取sqlSessionFactoryBuilder
        // SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 获取sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 获取SqlSession                            自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        // 获取mapper接口对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> list = mapper.getAllUser();
        list.forEach(user -> System.out.println(user));

    }
}
