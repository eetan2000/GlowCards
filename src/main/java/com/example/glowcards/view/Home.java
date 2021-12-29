package com.example.glowcards.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class Home {
    @FXML
    private Button homeButton;
    @FXML
    private Button createButton;
    @FXML
    private Button setsButton;
    @FXML
    private Button quizButton;

    @FXML
    private VBox menuVbox;
    @FXML
    private AnchorPane mainAnchorPane;

    public void display(){
        System.out.println("Here");
    }

    public void homeSideButton(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Text text = new Text();
        text.setText("Sets");
        text.setX(400);
        text.setY(100);

        mainAnchorPane.getChildren().add(text);
        stage.show();
    }

    public void createSideButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Create.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.show();
    }

    public void setsSideButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Sets.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.show();
    }
}
