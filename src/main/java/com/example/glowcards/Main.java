package com.example.glowcards;

import com.example.glowcards.control.UserController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        UserController.getINSTANCE().loadUsers();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Start.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("GlowCards");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
