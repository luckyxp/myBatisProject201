package com.xp.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog implements Serializable {

  private Integer id;
  private String title;
  private String content;
  @DateTimeFormat(pattern = "yyyy-mm-dd")
  private Date createTime;
  private String type;
  private Author author;
  private List<Comment> comments;

  public Blog(String title, String content, Date createTime, String type, Author author) {
    this.title = title;
    this.content = content;
    this.createTime = createTime;
    this.type = type;
    this.author = author;
  }

  public Blog(Integer id, String title, String content, Date createTime, String type, Author author) {
    this.id = id;
    this.title = title;
    this.content = content;
    this.createTime = createTime;
    this.type = type;
    this.author = author;
  }
}
