package com.example.glowcards.view;

import com.example.glowcards.model.Set;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class SetCard extends Pane {
    private Set set;

    public SetCard(Set setInput) {
        this.set = setInput;
        Label numOfTermsLabel = new Label();
        Label titleLabel = new Label();

        numOfTermsLabel.setPrefWidth(184);
        numOfTermsLabel.setPrefHeight(32);
        numOfTermsLabel.setLayoutX(38);
        numOfTermsLabel.setLayoutY(61);

        titleLabel.setPrefWidth(470);
        titleLabel.setPrefHeight(83);
        titleLabel.setLayoutX(38);
        titleLabel.setLayoutY(93);

        numOfTermsLabel.setText(String.valueOf(set.getSize()) + " terms");
        titleLabel.setText(set.getTitle());

        this.setPrefWidth(685);
        this.setPrefHeight(224);
        this.setStyle("-fx-background-color: #ed5565");
        this.getChildren().add(numOfTermsLabel);
        this.getChildren().add(titleLabel);

        this.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setStyle("-fx-background-color: #da4453");
            }
        });
        this.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setStyle("-fx-background-color: #ed5565");
            }
        });
        this.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                SetDisplay setDisplayController = new SetDisplay(set);
                setDisplayController.startForm();
            }
        });
    }
}
