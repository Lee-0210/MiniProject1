package com.team1.Controller;

import java.io.IOException;

import com.team1.DTO.Board;
import com.team1.Service.BoardService;
import com.team1.Service.BoardServiceImpl;
import com.team1.Util.SceneUtil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ReadController {

    @FXML
    private Button btnList;

    @FXML
    private Button btnModify;

    @FXML
    private TextArea taContent;

    @FXML
    private TextField tfTitle;

    @FXML
    private TextField tfWriter;

    // 목록 화면으로 이동
    public void moveToList(ActionEvent event) throws IOException {
        SceneUtil.getInstance().switchScene(event, "/com/team1/UI/List.fxml");
    }

    // 수정 화면으로 이동
    public void moveToModify(ActionEvent event) throws IOException {
        SceneUtil.getInstance().switchScene(event, "/com/team1/UI/Update.fxml");
    }

    BoardService boardService = new BoardServiceImpl();
    int boardNo;

    public void read(int boardNo) {
        this.boardNo = boardNo;
        System.out.println(boardNo);
        Board board = boardService.read(boardNo);

        // TODO : 텍스트필드에 내용 표시
        tfTitle.setText(board.getTitle());
        System.out.println(board.getTitle());
        tfWriter.setText(board.getWriter());
        taContent.setText(board.getContent());
    }

}
