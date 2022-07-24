
import com.rjs.mybatis.mapper.SelectMapper;
import com.rjs.mybatis.pojo.User;
import com.rjs.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author: 软件手
 * @date: 2022/7/23 23:03
 * @description:
 */
public class SelectMapperTest {
    /*
    * MyBatis的各种查询功能
    * 1、若查询出的数据只有一条，可以通过实体类对象或者集合 接收
    * a>可以通过实体类接收
    * b>可以通过list集合接收
    * c>可以通过map集合接收
    * 结果：{password=123456, sex=男, id=3, age=23, email=12345@qq.com, username=admin}  map是无序的
    * 2、若查询出的数据有多条
    * a>可以通过list集合接收
    * b>可以通过map类型的list集合接收
    * c>可以在mapper接口的方法上添加@MapKey注解，此时就可以将每条数据转换成map集合作为值，以某个字段的值作为键，放在同一个map集合中
    * 注意：一定不能通过实体类对象接收，此时会抛出异常 TooManyResultsException
    *
    * MyBatis中设置了默认的类型名
    * java.lang.Integer-->int,integer
    * int-->_int,_integer
    * */


    // 1、根据id查询用户信息
    @Test
    public void testGetUserById(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getUserById(3));
    }

    // 2、查询所有用户信息
    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getAllUser());
    }

    // 3、查询用户信息的总记录数
    @Test
    public void testGetCount(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getCount());
    }

    // 4、根据id查询用户信息为一个map集合
    @Test
    public void testGetUserByIdToMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getUserByIdToMap(3));
    }

    // 5、查询所有用户信息为map集合
    @Test
    public void testGetAllUserToMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getAllUserToMap());
    }
}
