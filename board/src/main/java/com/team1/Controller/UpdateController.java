package com.team1.Controller;

import java.io.IOException;

import com.team1.DTO.Board;
import com.team1.Service.BoardService;
import com.team1.Service.BoardServiceImpl;
import com.team1.Util.SceneUtil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class UpdateController {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnList;

    @FXML
    private Button btnUpdate;

    @FXML
    private TextArea taContent;

    @FXML
    private TextField tfTitle;

    @FXML
    private TextField tfWriter;

    @FXML
    void content(MouseEvent event) {

    }
    @FXML
    void title(ActionEvent event) {

    }
    @FXML
    void writer(ActionEvent event) {

    }

    private BoardService boardService = new BoardServiceImpl();
    int boardNo;
    
    
    @FXML
    void toList(ActionEvent event) throws Exception {
        SceneUtil.getInstance().switchScene(event, "/com/team1/UI/List.fxml");
    }
    
    @FXML
    void toUpdate(ActionEvent event) throws Exception {
        Board board = new Board(tfTitle.getTitle(), tfWriter.getWriter(), taContent.getContent());
        board.setBoardNo(boardNo);
        int result = boardService.update(board);
        if (result > 0) {
            System.out.println("글 수정 완료");
            SceneUtil.getInstance().switchScene(event, UI.LIST.getPath());
        }
    }
    
    @FXML
    void delete(ActionEvent event) throws IOException {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        int result = 0;
        if (alert.showAndWait().get() == ButtonType.OK) {
            result = boardService.delete(boardNo);
        }

        if (result > 0) {
            System.out.println("삭제 완료");
            SceneUtil.getInstance().switchScene(event, UI.LIST.getPath());
        }
    }

}
