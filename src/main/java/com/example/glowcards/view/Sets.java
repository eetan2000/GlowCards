package com.example.glowcards.view;

import com.example.glowcards.model.Set;
import com.example.glowcards.model.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Sets {
    @FXML
    private Label nameLabel;
    @FXML
    private AnchorPane componentAnchorPane;
    @FXML
    private Button homeSideButton;
    @FXML
    private Button createSideButton;
    @FXML
    private Button setsSideButton;
    @FXML
    private Button quizSideButton;
    @FXML
    private ImageView icon;

    private User user;

    private int SPACING_BETWEEN_CARDS = 0;

    public void setUser(User user) {
        this.user = user;
        nameLabel.setText(user.getName());
    }

    public void setUp() {
        Image image = new Image(getClass().getResourceAsStream("/avatars/" + user.getImage()+".png"));
        icon.setImage(image);
        for (Set curSet : user.getCollectionArrayList()) {
            SetCard newSetCard = new SetCard(curSet);
            newSetCard.setLayoutX(14);
            newSetCard.setLayoutY(34 + SPACING_BETWEEN_CARDS);
            SPACING_BETWEEN_CARDS += 297;

            componentAnchorPane.getChildren().add(newSetCard);
            if (user.getCollectionArrayList().size() > 2) {
                componentAnchorPane.setPrefHeight(SPACING_BETWEEN_CARDS);
            }
        }

        homeSideButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                homeSideButton.setStyle("-fx-background-color: #F18C8E");
            }
        });
        createSideButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                createSideButton.setStyle("-fx-background-color: #F18C8E");
            }
        });
        setsSideButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setsSideButton.setStyle("-fx-background-color: #F18C8E");
            }
        });
        quizSideButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                quizSideButton.setStyle("-fx-background-color: #F18C8E");
            }
        });

        homeSideButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                homeSideButton.setStyle("-fx-background-color: #FF9187");
            }
        });
        createSideButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                createSideButton.setStyle("-fx-background-color: #FF9187");
            }
        });
        setsSideButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setsSideButton.setStyle("-fx-background-color: #FF9187");
            }
        });
        quizSideButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                quizSideButton.setStyle("-fx-background-color: #FF9187");
            }
        });
    }

    public void homeSideButton(ActionEvent event) throws IOException {
        URL fxmlLocation = getClass().getResource("/fxml/Home.fxml");
        FXMLLoader loader = new FXMLLoader(fxmlLocation);
        Parent root = loader.load();

        Home homeController = loader.getController();
        homeController.setUser(user);
        homeController.setUp();

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
        createController.setUser(user);
        createController.setUp();


        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void quizSideButton(ActionEvent event) throws IOException {
        URL fxmlLocation = getClass().getResource("/fxml/Quiz.fxml");
        FXMLLoader loader = new FXMLLoader(fxmlLocation);
        Parent root = loader.load();

        Quiz quizController = loader.getController();
        quizController.setUser(user);
        quizController.setUp();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
