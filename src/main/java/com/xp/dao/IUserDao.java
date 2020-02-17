package com.xp.dao;

import com.xp.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class IUserDao {
    @Test
    public void test1() throws IOException {
        //1.通过mybatis全局配置文件得到一个输入流
        String resource = "SqlMapConfig.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        //2.通过全局配置文件的输入流创建一个SqlSession工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //3.通过工厂得到一个SqlSession实例
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4.SqlSession可以进行各种数据库操作 增删改查
        User user1 = sqlSession.selectOne("com.xp.dao.IUserDao.findAll",4);
        System.out.println(user1);
    }
}
