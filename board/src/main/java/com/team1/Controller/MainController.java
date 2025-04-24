package com.team1.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class MainController {

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
    }



