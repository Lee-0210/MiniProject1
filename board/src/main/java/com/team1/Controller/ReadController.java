package com.team1.Controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import com.team1.Util.SceneUtil;

public class ReadController {

    @FXML
    private Button btn;

    @FXML
    private TextArea taContent;

    @FXML
    private TextField tfTitle;

    @FXML
    private TextField tfWriter;

    @FXML
    void TextContent(MouseEvent event) {

    }

    @FXML
    void TitleAction(ActionEvent event) {

    }

    @FXML
    void WriterAction(ActionEvent event) {

    }

    @FXML
    void btnDelete(ActionEvent event) {

    }

    @FXML
    void btnList(ActionEvent event) {

    }

    @FXML
    void btnModify(ActionEvent event) {

    }

    // 목록 화면으로 이동
    public void moveToList(ActionEvent event) throws IOException {
        SceneUtil.getInstance().switchScene(event, "/com/team1/UI/List.fxml");
    }

    // 수정 화면으로 이동
    public void moveToModify(ActionEvent event) throws IOException {
        SceneUtil.getInstance().switchScene(event, "/com/team1/UI/Update.fxml");
    }

}
