package com.xp.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {

  private Integer id;
  private String title;
  private String content;
  @DateTimeFormat(pattern = "yyyy-mm-dd")
  private Date createTime;
  private String type;
  private Integer authorId;

  public Blog(String title, String content, Date createTime, String type, Integer authorId) {
    this.title = title;
    this.content = content;
    this.createTime = createTime;
    this.type = type;
    this.authorId = authorId;
  }
}
