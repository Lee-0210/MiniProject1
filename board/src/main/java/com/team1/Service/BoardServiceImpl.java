package com.team1.Service;

import java.util.List;

import com.team1.DAO.BoardDAO;
import com.team1.DTO.Board;

public class BoardServiceImpl implements BoardService {

  BoardDAO bDao = new BoardDAO();

  @Override
  public List<Board> list() {
    List<Board> list = bDao.list();

    return list;
  }




  @Override
  public int update(Board board) {
    int result = bDao.update(board);

    return result;
  }

  @Override
  public int delete(int boardNo) {
    int result = bDao.delete(boardNo);
    return result;
  }
}
