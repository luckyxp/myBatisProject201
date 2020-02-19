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
}
