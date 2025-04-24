package com.team1.DAO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.team1.DTO.Board;

public class BoardDAO extends JDBConnection {
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  // 리스트 조회
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


  
  // 글 조회
  public Board read(int no) {
    String sql = "SELECT * FROM board WHERE no = ?";
    Board board = new Board();
    try {
      psmt = con.prepareStatement(sql);
      psmt.setInt(1, no);
      
      rs = psmt.executeQuery();
      
      board.setTitle(rs.getString(2));
      board.setWriter(rs.getString(3));
      board.setContent(rs.getString(4));
    } catch (Exception e) {
      
    }
    return board;
  }

  // 글 수정
  public int update(Board board) {
    int result = 0;

    String sql = "UPDATE board" 
    + "SET title = ?" 
    + ", writer = ?" 
    + ", content = ?" 
    + ", updDate = now()"
    + "WHERE boardNo = ?";

    try {
      psmt = con.prepareStatement(sql);
      result = psmt.executeUpdate();
      psmt.setString(1, board.getTitle());
      psmt.setString(2, board.getWriter());
      psmt.setString(3, board.getContent());
      psmt.setInt(4, board.getBoardNo());

    } catch (Exception e) {
      System.err.println("수정중 에러 발생");
      e.printStackTrace();
    }
    return result;
    
  }
  // 글 삭제
  public int delete(int no) {
    int result = 0;
    String sql = "DELETE FROM board WHERE no = ?";
    try {
      psmt = con.prepareStatement(sql);
      psmt.setInt(1, no);
      result = psmt.executeUpdate();
    } catch (Exception e) {
      System.err.println("삭제중 에러 발생");
      e.printStackTrace();
    }
      return result;
    }
}
