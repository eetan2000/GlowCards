package com.example.glowcards.view;

import com.example.glowcards.model.Set;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class QuizCard extends Pane {
    private Label titleLabel;
    private Label scoreLabel;
    private Label score;
    private Label termsLabel;

    private Set set;

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

        this.getChildren().add(titleLabel);
        this.getChildren().add(scoreLabel);
        this.getChildren().add(termsLabel);
        this.getChildren().add(score);
        this.setStyle("-fx-background-color: #fcba03");

        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    URL fxmlLocation = getClass().getResource("/fxml/QuizDisplay.fxml");
                    FXMLLoader loader = new FXMLLoader(fxmlLocation);
                    Parent root = loader.load();

                    QuizDisplay quizDisplayController = loader.getController();
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
}
