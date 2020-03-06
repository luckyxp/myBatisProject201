package com.xp.service;

import com.xp.dao.AuthorDao;
import com.xp.dao.BlogDao;
import com.xp.dao.CommentDao;
import com.xp.pojo.Blog;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlogService {
    @Test
    public void test1() throws IOException {
        //1.通过配置文件创建一个输入流
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.通过流创建一个SqlSessionFactory工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //3.用SqlSessionFactory创建一个SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.用sqlSession对象获得BlogDao的代理对象
        BlogDao blogDao = sqlSession.getMapper(BlogDao.class);
        AuthorDao authorDao = sqlSession.getMapper(AuthorDao.class);
        CommentDao commentDao = sqlSession.getMapper(CommentDao.class);

//        authorDao.addAuthor(new Author("张三","123","22323@qq.com","中国","12153135"));

        //        List<Blog> all = blogDao.getAll();
//        for (Blog blog : all) {
//            System.out.println(blog);
//        }

//        System.out.println(mapper.getById(15));
//        mapper.addBlog(new Blog("线上教学现状","令人担忧",new Date(),"民情",new Author(11)));
//        mapper.deleteById(17);
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("name", "黄大海");
//        blogDao.getNum(map);
//        for (String s : map.keySet()) {
//            System.out.println(s+"\t"+map.get(s));
//        }
//        for (Blog blog : blogDao.getByTitle("战争",2)) {
//            System.out.println(blog);
//        }
//        blogDao.updateBlog(new Blog(10,"新冠病毒蔓延日本","小日本该死,报应来了",new Date(),"政论",new Author(12)));
//        List<Blog> byArray = blogDao.getByArray("政论,民情".split(","));
//        for (Blog blog : byArray) {
//            System.out.println(blog);
//        }
//        List<Blog> byList = blogDao.getByList(Arrays.asList("政论,民情".split(",")));
//        for (Blog blog : byList) {
//            System.out.println(blog);
//        }

        Map<String,Object> args = new HashMap<String, Object>();
        args.put("types1", Arrays.asList("政论,民情".split(",")));
        args.put("types2", "政论,疫情".split(","));
        List<Blog> byMap = blogDao.getByMap(args);
        for (Blog blog : byMap) {
            System.out.println(blog);
        }
        sqlSession.commit();
        sqlSession.close();
    }
}
