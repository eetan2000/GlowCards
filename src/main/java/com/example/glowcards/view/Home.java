package com.example.glowcards.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

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
    private Label usernameLabel;

    @FXML
    private VBox menuVbox;
    @FXML
    private AnchorPane mainAnchorPane;

    private String username;

    public void display() {
        usernameLabel.setText(username);
    }

    public void homeSideButton(ActionEvent event) throws IOException {

    }

    public void createSideButton(ActionEvent event) throws IOException {
        URL fxmlLocation = getClass().getResource("/fxml/Create.fxml");
        FXMLLoader loader = new FXMLLoader(fxmlLocation);
        Parent root = loader.load();

        Create createController = loader.getController();
        createController.setUp();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setsSideButton(ActionEvent event) throws IOException {

    }

    public void setUsername(String username) {
        this.username = username;
    }
}
