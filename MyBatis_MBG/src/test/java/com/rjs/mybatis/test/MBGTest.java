package com.rjs.mybatis.test;

import com.rjs.mybatis.mapper.EmpMapper;
import com.rjs.mybatis.pojo.Emp;
import com.rjs.mybatis.pojo.EmpExample;
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
 * @date: 2022/7/25 10:54
 * @description:
 */
public class MBGTest {

    @Test
    public void testMBG(){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            // 查询所有数据
//            List<Emp> list = mapper.selectByExample(null);
//            list.forEach(emp -> System.out.println(emp));
            // 根据条件查询
//            EmpExample example = new EmpExample();
//            example.createCriteria().andEmpNameEqualTo("张三").andAgeGreaterThanOrEqualTo(20);
//            example.or().andDidIsNotNull();
//            List<Emp> list = mapper.selectByExample(example);
//            list.forEach(emp -> System.out.println(emp));
            // 修改
            // mapper.updateByPrimaryKey(new Emp(1,"admin",12,"女","456@qq.com",3));
            mapper.updateByPrimaryKeySelective(new Emp(1,"admin",12,null,"456@qq.com",3));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
