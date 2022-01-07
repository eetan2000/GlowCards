package com.example.glowcards.view;

import com.example.glowcards.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
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
    private Label nameLabel;

    @FXML
    private VBox menuVbox;
    @FXML
    private AnchorPane mainAnchorPane;

    private User user;


    public void homeSideButton(ActionEvent event) throws IOException {

    }

    public void createSideButton(ActionEvent event) throws IOException {
        URL fxmlLocation = getClass().getResource("/fxml/Create.fxml");
        FXMLLoader loader = new FXMLLoader(fxmlLocation);
        Parent root = loader.load();

        Create createController = loader.getController();
        createController.setUp();
        createController.setUser(user);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setsSideButton(ActionEvent event) throws IOException {

    }

    public void setUser(User user) {
        this.user = user;
        nameLabel.setText(user.getName());
    }
}
