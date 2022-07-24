
import com.rjs.mybatis.mapper.DeptMapper;
import com.rjs.mybatis.mapper.EmpMapper;
import com.rjs.mybatis.pojo.Dept;
import com.rjs.mybatis.pojo.Emp;
import com.rjs.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author: 软件手
 * @date: 2022/7/24 8:49
 * @description:
 */
public class ResultMapTest {
    /*
    * 解决字段名二号属性名不一致的情况：
    * a>为字段名起别名，保持和属性名的一致
    * b>设置全局配置，将_自动映射为驼峰
    *  <setting name="mapUnderscoreToCamelCase" value="true"/>
    * c>通过resultMap设置自定义的映射关系
    * <resultMap id="empResultMap" type="Emp">
        <id property="eid" column="eid"></id>
        <result property="empName" column="emp_name"></result>
        <result property="age" column="age"></result>
        <result property="sex" column="sex"></result>
        <result property="email" column="email"></result>
    </resultMap>
    <select id="getAllEmp" resultMap="empResultMap">
        select * from t_emp
    </select>
    *
    * 处理多对一的映射关系
    * a>级联属性赋值
    * b>association
    * c>分步查询
    *
    * 处理一对多的映射关系
    * a>collection
    * b>分步查询
    * */

    @Test
    public void testGetAllEmp(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> list = mapper.getAllEmp();
        list.forEach(emp -> System.out.println(emp));
    }


    @Test
    public void testGetEmpAndDept(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDept(1);
        System.out.println(emp);
    }

    //  c>分步查询
    @Test
    public void testGetEmpAndDeptByStepOne(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDeptByStepOne(3);
        System.out.println(emp.getEmpName());
        System.out.println("++++++++++++++++++++++++++++++");
        System.out.println(emp.getDept());
    }
    // 1对多
    @Test
    public void testDeptAndEmpResultMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmp(1);
        System.out.println(dept);
    }

    // 1对多-分步查询
    @Test
    public void testGetDeptAndEmpByStep(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmpByStepOne(1);
        System.out.println(dept);
    }
}
