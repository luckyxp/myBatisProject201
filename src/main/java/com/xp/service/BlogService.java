package com.xp.service;

import com.xp.dao.BlogDao;
import com.xp.pojo.Blog;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class BlogService {
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
        BlogDao blogDao = sqlSession.getMapper(BlogDao.class);

        List<Blog> all = blogDao.getAll();
        for (Blog b : all){
            System.out.println(b);
        }
        List<Blog> all2 = blogDao.sleAll();
        for (Blog b : all){
            System.out.println(b);
        }
//        System.out.println(blogDao.getById(1));
//        System.out.println(blogDao.deleteById(9));
//        System.out.println(blogDao.addBlog(new Blog("新冠疫情", "中国加油", new Date(), "疫情", 11)));
        sqlSession.commit();
        sqlSession.close();
    }
}
