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
  public Board read(int no) {
    System.out.println(no);
    Board board = bDao.read(no);
    System.out.println("작동2");
    return board;
  }

  @Override
  public int update(Board board) {
    int result = bDao.update(board);

    return result;
  }

   @Override
  public int delete(int no) {
    int result = bDao.delete(no);

    return result;
  }



  @Override
  public int insert(Board board) {
    int result = bDao.insert(board);
    System.out.println("야");
    return result;
  }
}
