package com.team1.Controller;

import java.io.IOException;

import com.team1.Util.SceneUtil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
    void title(ActionEvent event) {

    }

    @FXML
    void writer(ActionEvent event) {

    }

    @FXML
    void content(MouseEvent event) {

    }

    @FXML
    void delete(ActionEvent event) {

    }

    @FXML
    void toList(ActionEvent event) throws IOException {
       SceneUtil.getInstance().switchScene(e, "UI/List");
    }

    @FXML
    void update(ActionEvent event) {

    }


}
