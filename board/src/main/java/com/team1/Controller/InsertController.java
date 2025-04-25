package com.team1.Controller;

import java.io.IOException;

import com.team1.DTO.Board;
import com.team1.Service.BoardService;
import com.team1.Util.SceneUtil;
import com.team1.Service.BoardServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class InsertController {

    @FXML
    private TextField tfwriter;

    @FXML
    private TextField tftitle;

    @FXML
    private TextArea tacontent;
    @FXML
    void Delete(ActionEvent event) {
      System.out.println("선택 삭제");

    }

    @FXML
    void Edit(ActionEvent event) {
        System.out.println("등록수정");
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/team1/UI/Update.fxml"));
            Parent listRoot = loader.load();
            Scene update = new Scene(listRoot);
            javafx.stage.Stage stage = (javafx.stage.Stage)((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(update);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }


         }
         BoardService boardService = new BoardServiceImpl();



    @FXML
    void Writer(ActionEvent event) {

        System.out.println("글쓰기");
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/team1/UI/List.fxml"));
            Parent listRoot = loader.load();
            Scene update = new Scene(listRoot);
            javafx.stage.Stage stage = (javafx.stage.Stage)((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(update);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
        public void insert(ActionEvent event) throws IOException {
            System.out.println("ㅇㅇㅇㅇ");
            Board board = new Board(tftitle.getText(), tfwriter.getText(), tacontent.getText() );
            int result = boardService.insert(board);
            if( result > 0 ) {
                System.out.println("글쓰기 처리 성공!");
                SceneUtil.getInstance().switchScene(event, "/com/team1/UI/List.fxml" );
            }
        }



	}







