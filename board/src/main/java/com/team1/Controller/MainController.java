package com.team1.Controller;

import java.io.IOException;

import com.team1.Util.SceneUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class MainController {

      @FXML private TextField userid;
      @FXML private PasswordField userpw;




      @FXML
      void toList(ActionEvent event) throws IOException {
        if(!userid.getText().equals("윤홍민바보") || !userpw.getText().equals("1234")) {
          Alert alert = new Alert(AlertType.CONFIRMATION);
          alert.setTitle("알림");
          alert.setHeaderText("알림");
          alert.setContentText("아이디: 윤홍민바보 \n 비밀번호 : 1234");
          alert.showAndWait();
          return;
        }
        SceneUtil.getInstance().switchScene(event, "/com/team1/UI/List.fxml");
      }
}
