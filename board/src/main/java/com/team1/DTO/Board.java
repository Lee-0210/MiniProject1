package com.team1.DTO;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
public class Board {
  private int boardNo;
  private String title;
  private String writer;
  private String content;
  private String regDate;
  private String updDate;

  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  public Board() {
    this("제목없음", "작성자없음", "내용 없음");
  }

  public Board(String title, String writer, String content) {
    this.title = title;
    this.writer = writer;
    this.content = content;
    this.regDate = sdf.format(new Date());
    this.updDate = sdf.format(new Date());
  }
}
