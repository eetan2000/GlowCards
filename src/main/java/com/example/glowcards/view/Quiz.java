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

public class Quiz {
    @FXML
    private AnchorPane componentAnchorPane;
    @FXML
    private Label nameLabel;

    private User user;
    private int SPACING_BETWEEN_CARDS = 0;

    public void setUp() {
        int i = 0;
        for (Set curSet : user.getCollectionArrayList()) {
            QuizCard quizCard = new QuizCard(curSet);
            quizCard.setLayoutX(43);
            quizCard.setLayoutY(100 + SPACING_BETWEEN_CARDS);

            componentAnchorPane.getChildren().add(quizCard);

            if (i > 0) {
                componentAnchorPane.setPrefHeight(480 + SPACING_BETWEEN_CARDS);
            }
            i++;
            SPACING_BETWEEN_CARDS += 289;
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

    public void setsSideButton(ActionEvent event) throws IOException {
        URL fxmlLocation = getClass().getResource("/fxml/Sets.fxml");
        FXMLLoader loader = new FXMLLoader(fxmlLocation);
        Parent root = loader.load();

        Sets setsController = loader.getController();
        setsController.setUser(user);
        setsController.setUp();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setUser(User user) {
        this.user = user;
        nameLabel.setText(user.getName());
    }
}
