package com.team1.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.team1.DTO.Board;
import com.team1.Service.BoardService;
import com.team1.Service.BoardServiceImpl;
import com.team1.Util.SceneUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control. TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ListController implements Initializable {

    @FXML private TableView<Board> tableView;
    @FXML private TableColumn<Board, Integer> boardNo;
    @FXML private TableColumn<Board, String> title;
    @FXML private TableColumn<Board, String> writer;
    @FXML private TableColumn<Board, String> content;
    @FXML private TableColumn<Board, String> regDate;
    @FXML private TableColumn<Board, String> updDate;
    @FXML private Button closeBtn;
    @FXML private Button writeBtn;
    @FXML private Button deleteBtn;


    BoardService boardService = new BoardServiceImpl();

    Stage stage;
    Scene scene;
    Parent root;

    // 초기화
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        System.out.println("=========================" + tableView);
        List<Board> boardList = new ArrayList<>();

        boardList = boardService.list();

        ObservableList<Board> list = FXCollections.observableArrayList(boardList);

        boardNo.setCellValueFactory(new PropertyValueFactory<>("BoardNo"));
        title.setCellValueFactory(new PropertyValueFactory<>("Title"));
        writer.setCellValueFactory(new PropertyValueFactory<>("Writer"));
        content.setCellValueFactory(new PropertyValueFactory<>("Content"));
        regDate.setCellValueFactory(new PropertyValueFactory<>("RegDate"));
        updDate.setCellValueFactory(new PropertyValueFactory<>("UpdDate"));

        tableView.setItems(list);


        // 더블클릭
        // tableView.setOnMouseClicked(new EventHandler<MouseEvent>() {

        //     @Override
        //     public void handle(MouseEvent e) {
        //         if(e.getClickCount() == 2 & tableView.getSelectionModel().getSelectedItem() != null) {
        //             int boardNo = tableView.getSelectionModel().getSelectedItem().getBoardNo();

        //             try {
		// 				ReadController readController = (ReadController) SceneUtil.getInstance().getController("UI/Read.fxml");
		// 				readController.read(boardNo);
		// 				Parent root = SceneUtil.getInstance().getRoot();
		// 				SceneUtil.getInstance().switchScene(e, "UI/Read.fxml", root);
		// 			} catch (IOException e) {
		// 				System.err.println("[목록->읽기] 화면 이동 중 예외 발생..");
		// 				e.printStackTrace();
		// 			}
        //         }
        //     }
        // });
    }

    // 글쓰기 화면으로 이동
    public void moveToInsert(ActionEvent e) throws IOException {
        SceneUtil.getInstance().switchScene(e, "/com/team1/UI/KBG/Main.fxml");
    }

    public void close(ActionEvent e) {
        SceneUtil.getInstance().close(e);
    }
}
