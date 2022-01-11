package com.example.glowcards.view;

import com.example.glowcards.model.Set;
import com.example.glowcards.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Sets {
    @FXML
    private Label nameLabel;
    @FXML
    private AnchorPane componentAnchorPane;

    private User user;

    private int SPACING_BETWEEN_CARDS = 0;

    public void setUser(User user) {
        this.user = user;
        nameLabel.setText(user.getName());
    }

    public void setUp() {
        for (Set curSet : user.getCollectionArrayList()) {
            SetDisplay newSetDisplay = new SetDisplay(curSet);
            newSetDisplay.setLayoutX(14);
            newSetDisplay.setLayoutY(34 + SPACING_BETWEEN_CARDS);
            SPACING_BETWEEN_CARDS += 297;

            componentAnchorPane.getChildren().add(newSetDisplay);
            if (user.getCollectionArrayList().size() > 2) {
                componentAnchorPane.setPrefHeight(SPACING_BETWEEN_CARDS);
            }
        }
    }

    public void homeSideButton(ActionEvent event) throws IOException {
        URL fxmlLocation = getClass().getResource("/fxml/Home.fxml");
        FXMLLoader loader = new FXMLLoader(fxmlLocation);
        Parent root = loader.load();

        Home homeController = loader.getController();
        homeController.setUser(user);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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
}
