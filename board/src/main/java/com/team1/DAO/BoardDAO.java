package com.team1.DAO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.team1.DTO.Board;

public class BoardDAO extends JDBConnection {
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  // 목록 조회
  public List<Board> list() {
    List<Board> boardList = new ArrayList<>();
    String sql = "SELECT * FROM board";

    try {
      stmt = con.createStatement();
      rs = stmt.executeQuery(sql);
      while(rs.next()) {
        Board board = new Board();
        board.setBoardNo(rs.getInt(1));
        board.setTitle(rs.getString(2));
        board.setWriter(rs.getString(3));
        board.setContent(rs.getString(4));
        board.setRegDate(sdf.format(rs.getTimestamp(5)));
        board.setUpdDate(sdf.format(rs.getTimestamp(6)));
        boardList.add(board);
      }
    } catch (Exception e) {
      System.err.println("게시글 목록 조회 에러");
      e.printStackTrace();
    }
    return boardList;
  }
}
