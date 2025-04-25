package com.team1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class Main extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        // System.out.println("안녕하세요");
        scene = new Scene(loadFXML("UI/Main"));
        stage.setScene(scene);
        stage.show();

        Image icon = new Image(getClass().getResource("/com/team1/img/18.jpg").toString());
        stage.getIcons().add(icon);
        stage.setTitle("JavaFX Board MiniProject");
        // 게시판 창 크기 임의조절 불가능 코드
        stage.setResizable(false);
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}