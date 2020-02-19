package com.xp.dao;

import com.xp.pojo.Blog;

import java.util.List;

public interface BlogDao {
    List<Blog> getAll();

    Blog getById(Integer id);

    Integer deleteById(Integer id);

}
