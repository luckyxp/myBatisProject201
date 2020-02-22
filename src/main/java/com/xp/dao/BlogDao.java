package com.xp.dao;

import com.xp.pojo.Blog;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BlogDao {
    List<Blog> getAll();

    Blog getById(Integer id);

    Integer deleteById(Integer id);

    Integer addBlog(Blog blog);

    //基于注解,无需mapper
    @Select("select * from blog")
    List<Blog> sleAll();

}
