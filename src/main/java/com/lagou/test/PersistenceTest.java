package com.lagou.test;

import com.lagou.io.Resources;
import com.lagou.sqlSession.SqlSession;
import com.lagou.sqlSession.SqlSessionFactory;
import com.lagou.sqlSession.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class PersistenceTest {

    @Test
    public void test() throws Exception {
        InputStream resourceAsSteam = Resources.getResourceAsSteam("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsSteam);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.findAll();
        for (User user1 : userList) {
            System.out.println(user1);
        }
        //插入
        User user = new User();
        user.setId(6);
        user.setUsername("xiaoming");
        user.setPassword("346457");
        user.setBirthday("2019-01-25");
        System.out.println(mapper.insert(user));
        userList = mapper.findAll();
        for (User user1 : userList) {
            System.out.println(user1);
        }
        //修改
        user.setUsername("Tony");
        System.out.println(mapper.updateById(user));
        userList = mapper.findAll();
        for (User user1 : userList) {
            System.out.println(user1);
        }
        //删除
        System.out.println(mapper.deleteById(user));
        userList = mapper.findAll();
        for (User user1 : userList) {
            System.out.println(user1);
        }
    }

}
