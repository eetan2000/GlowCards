package com.example.glowcards.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class CardCreator extends Pane {
    /*@FXML
    private Pane cardPane;
    @FXML
    private Label numberLabel;
    @FXML
    private Label termLabel;
    @FXML
    private Label definitionLabel;
    @FXML
    private TextField termTextField;
    @FXML
    private TextField definitionTextField;*/

    private Label numberLabel = new Label("#");
    private Label termLabel = new Label("Term:");
    private Label definitionLabel = new Label("Definition:");
    private TextField termTextField = new TextField();
    private TextField definitionTextField = new TextField();

    public CardCreator(){
        numberLabel.setLayoutX(14);
        numberLabel.setLayoutY(14);

        termLabel.setLayoutX(14);
        termLabel.setLayoutY(31);
        termLabel.setPrefWidth(281);
        termLabel.setPrefHeight(26);

        definitionLabel.setLayoutX(342);
        definitionLabel.setLayoutY(36);
        definitionLabel.setPrefWidth(387);
        definitionLabel.setPrefHeight(17);

        termTextField.setLayoutX(18);
        termTextField.setLayoutY(57);
        termTextField.setPrefWidth(281);
        termTextField.setPrefHeight(128);

        definitionTextField.setLayoutX(342);
        definitionTextField.setLayoutY(57);
        definitionTextField.setPrefWidth(387);
        definitionTextField.setPrefHeight(128);

        this.setPrefHeight(200);
        this.setPrefWidth(740);
        this.getChildren().add(numberLabel);
        this.getChildren().add(termLabel);
        this.getChildren().add(definitionLabel);
        this.getChildren().add(termTextField);
        this.getChildren().add(definitionTextField);
    }
}
