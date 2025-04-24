package com.team1.Service;

import java.util.List;

import com.team1.DTO.Board;

public interface BoardService {
  List<Board> list();

  int update(Board board);

  int delete(int boardNo);
}
