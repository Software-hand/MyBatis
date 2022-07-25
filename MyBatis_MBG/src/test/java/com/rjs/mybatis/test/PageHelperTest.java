package com.rjs.mybatis.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rjs.mybatis.mapper.EmpMapper;
import com.rjs.mybatis.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author: 软件手
 * @date: 2022/7/25 11:22
 * @description:
 */
public class PageHelperTest {

    /*
    * limit index,pgeSize
    * index:当前页的起始索引，从0开始
    * pageSize：每页显示的条数
    * pageNum：当前页的页码
    * index=(pageNum-1)*pageSize
    *
    * 使用MyBatis的分页插件实现分页功能
    * 1、需要在查询功能之前开启分页
    * PageHelper.startPage(int pageNum,int pageSize)
    * 2、在查询功能之后获取分页相关信息
    * PageInfo<Emp> page = new PageInfo<>(list,5);
    * list表示分页数据
    * 5表示当前导航分页的数量
    *
    *
    * */

    @Test
    public void testPageHelper() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //访问第一页，每页四条数据
        PageHelper.startPage(2,4);

        List<Emp> list = mapper.selectByExample(null);
        PageInfo<Emp> page = new PageInfo<Emp>(list,1);
        // list.forEach(System.out::println);
        System.out.println(page);
    }
}
