package com.xp.dao;

import com.xp.pojo.Blog;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface BlogDao {
    List<Blog> getByArray(String[] types);
    List<Blog> getByList(List<String> types);
    List<Blog> getByMap(Map<String,Object> args);
    void updateBlog(Blog blog);
    List<Blog> getByTitle(@Param("title") String title,@Param("arg") int arg);
    void getNum(Map<String, Object> map);
    List<Blog> getAll();

    Blog getById(Integer id);

    Integer deleteById(Integer id);

    Integer addBlog(Blog blog);

    //基于注解,无需mapper
    @Select("select * from blog")
    List<Blog> sleAll();

    List<Blog> getByMore(Integer id, String type);

}
