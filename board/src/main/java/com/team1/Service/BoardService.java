package com.team1.Service;

import java.util.List;

import com.team1.DTO.Board;

public interface BoardService {

  //글 추가
  int insert(Board board);

  // 리스트 조회
  List<Board> list();

  // 글 조회
  Board read(int no);

  // 삭제
  int delete(int no);
}
