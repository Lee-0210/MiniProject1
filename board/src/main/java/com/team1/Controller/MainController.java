package com.team1.Controller;

import java.io.IOException;
import com.team1.Util.SceneUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainController {

      @FXML
      void toList(ActionEvent event) throws IOException {
        SceneUtil.getInstance().switchScene(event, "/com/team1/UI/List.fxml");
      }

}
