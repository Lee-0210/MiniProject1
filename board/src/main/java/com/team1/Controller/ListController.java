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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ListController implements Initializable {

    @FXML private TableView<Board> boardTable;
    @FXML private TableColumn<Board, Integer> boardNo;
    @FXML private TableColumn<Board, String> title;
    @FXML private TableColumn<Board, String> writer;
    @FXML private TableColumn<Board, String> content;
    @FXML private TableColumn<Board, String> regDate;
    @FXML private TableColumn<Board, String> updDate;
    @FXML private Button closeBtn;
    @FXML private Button writeBtn;
    @FXML private Button deleteBtn;

    int no;

    BoardService boardService = new BoardServiceImpl();

    Stage stage;
    Scene scene;
    Parent root;

    // 초기화
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        List<Board> boardList = new ArrayList<>();

        boardList = boardService.list();
        ObservableList<Board> list = FXCollections.observableArrayList(boardList);

        boardNo.setCellValueFactory(new PropertyValueFactory<>("BoardNo"));
        title.setCellValueFactory(new PropertyValueFactory<>("Title"));
        writer.setCellValueFactory(new PropertyValueFactory<>("Writer"));
        content.setCellValueFactory(new PropertyValueFactory<>("Content"));
        regDate.setCellValueFactory(new PropertyValueFactory<>("RegDate"));
        updDate.setCellValueFactory(new PropertyValueFactory<>("UpdDate"));

        boardTable.setItems(list);

        // 더블클릭
        boardTable.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {
                no = boardTable.getSelectionModel().getSelectedItem().getBoardNo();
                if(e.getClickCount() == 2 & boardTable.getSelectionModel().getSelectedItem() != null) {
                    int boardNo = boardTable.getSelectionModel().getSelectedItem().getBoardNo();

                    try {
                        System.out.println("실행됨");
						ReadController readController = (ReadController) SceneUtil.getInstance().getController("/com/team1/UI/Read.fxml");
						readController.read(boardNo);
						Parent root = SceneUtil.getInstance().getRoot();
						SceneUtil.getInstance().switchScene(e, "/com/team1/UI/Insert.fxml", root);
					} catch (Exception exe) {
						System.err.println("[목록->읽기] 화면 이동 중 예외 발생..");
						exe.printStackTrace();
					}
                }
            }
        });
    }

    // 글쓰기 화면으로 이동 메서드
    public void moveToInsert(ActionEvent e) throws IOException {
        System.out.println("글쓰기 화면 이동");
        SceneUtil.getInstance().switchScene(e, "/com/team1/UI/Insert.fxml");
    }

    // 종료 메서드
    public void close(ActionEvent e) {
        System.out.println("종료");
        SceneUtil.getInstance().close(e);
    }

    // 게시글 삭제 메서드
    public void delete() {
        System.out.println("삭제 메서드 실행");
        boardService.delete(no);
        initialize(null, null);
    }
}
