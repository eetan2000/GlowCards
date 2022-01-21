package com.example.glowcards.view;

import com.example.glowcards.model.Set;
import com.example.glowcards.model.User;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class QuizCard extends Pane {
    private Label titleLabel;
    private Label scoreLabel;
    private Label score;
    private Label termsLabel;

    private Set set;
    private User user;

    public QuizCard(Set setInput) {
        this.set = setInput;
        titleLabel = new Label();
        scoreLabel = new Label();
        score = new Label();
        termsLabel = new Label();

        this.setPrefHeight(224);
        this.setPrefWidth(685);

        titleLabel.setPrefWidth(326);
        titleLabel.setPrefHeight(50);
        titleLabel.setLayoutX(14);
        titleLabel.setLayoutY(43);

        scoreLabel.setPrefWidth(176);
        scoreLabel.setPrefHeight(24);
        scoreLabel.setLayoutX(413);
        scoreLabel.setLayoutY(56);

        score.setPrefWidth(82);
        score.setPrefHeight(71);
        score.setLayoutX(460);
        score.setLayoutY(113);

        termsLabel.setPrefWidth(121);
        termsLabel.setPrefHeight(30);
        termsLabel.setLayoutX(14);
        termsLabel.setLayoutY(133);

        titleLabel.setText(set.getTitle());
        scoreLabel.setText("Score:");
        termsLabel.setText(set.getSize() + " terms");
        score.setText(set.getScore() + "%");

        titleLabel.setFont(new Font("Leelawadee UI", 24));
        titleLabel.setTextFill(Color.web("#ffffff"));
        termsLabel.setFont(new Font("Leelawadee UI", 14));
        termsLabel.setTextFill(Color.web("#ffffff"));
        scoreLabel.setFont(new Font("Leelawadee UI", 14));
        scoreLabel.setTextFill(Color.web("#ffffff"));
        score.setFont(new Font("Leelawadee UI", 26));
        score.setTextFill(Color.web("#ffffff"));


        this.getChildren().add(titleLabel);
        this.getChildren().add(scoreLabel);
        this.getChildren().add(termsLabel);
        this.getChildren().add(score);
        this.setStyle("-fx-background-color: #83DCF1");

        this.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setStyle("-fx-background-color: #60a3b3");
            }
        });
        this.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setStyle("-fx-background-color: #83DCF1");
            }
        });

        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    URL fxmlLocation = getClass().getResource("/fxml/QuizDisplay.fxml");
                    FXMLLoader loader = new FXMLLoader(fxmlLocation);
                    Parent root = loader.load();

                    QuizDisplay quizDisplayController = loader.getController();
                    quizDisplayController.setUser(user);
                    quizDisplayController.setUp(set);

                    Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void setUser(User user) {
        this.user = user;
    }
}
