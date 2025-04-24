package com.team1.Controller;

import java.io.IOException;

import com.team1.DTO.Board;
import com.team1.Service.BoardService;
import com.team1.Service.BoardServiceImpl;
import com.team1.Util.SceneUtil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
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
    void toUpdate(ActionEvent event) throws IOException {
        Board board = new Board(tfTitle.getText(), tfWriter.getText(), taContent.getText());
        board.setBoardNo(boardNo);
        int result = boardService.update(board);
        if (result > 0) {
            System.out.println("글 수정 완료");

        ReadController readController = (ReadController) SceneUtil.getInstance().getController("/com/team1/UI/Read.fxml");
		readController.read(boardNo);
		Parent root = SceneUtil.getInstance().getRoot();

            SceneUtil.getInstance().switchScene(event, "/com/team1/UI/Read.fxml", root);
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
            SceneUtil.getInstance().switchScene(event, "/com/team1/UI/List.fxml");
        }
    }

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
