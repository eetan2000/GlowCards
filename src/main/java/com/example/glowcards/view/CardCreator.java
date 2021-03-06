package com.example.glowcards.view;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class CardCreator extends Pane {
    private Label numberLabel = new Label("#");
    private Label termLabel = new Label("Term:");
    private Label definitionLabel = new Label("Definition:");
    private TextArea termTextArea = new TextArea();
    private TextArea definitionTextArea = new TextArea();
    private Button removeButton = new Button("Remove");

    public CardCreator() {
        numberLabel.setLayoutX(14);
        numberLabel.setLayoutY(14);

        termLabel.setLayoutX(14);
        termLabel.setLayoutY(70);
        termLabel.setPrefWidth(281);
        termLabel.setPrefHeight(26);

        definitionLabel.setLayoutX(342);
        definitionLabel.setLayoutY(74);
        definitionLabel.setPrefWidth(387);
        definitionLabel.setPrefHeight(17);

        termTextArea.setLayoutX(14);
        termTextArea.setLayoutY(107);
        termTextArea.setPrefWidth(281);
        termTextArea.setPrefHeight(128);
        termTextArea.setWrapText(true);

        definitionTextArea.setLayoutX(342);
        definitionTextArea.setLayoutY(107);
        definitionTextArea.setPrefWidth(387);
        definitionTextArea.setPrefHeight(128);
        definitionTextArea.setWrapText(true);

        numberLabel.setFont(new Font("Leelawadee UI",20));
        numberLabel.setTextFill(Color.web("#ffffff"));
        termLabel.setFont(new Font("Leelawadee UI",14));
        termLabel.setTextFill(Color.web("#ffffff"));
        definitionLabel.setFont(new Font("Leelawadee UI",14));
        definitionLabel.setTextFill(Color.web("#ffffff"));
        termTextArea.setFont(new Font("Leelawadee UI",14));
        definitionTextArea.setFont(new Font("Leelawadee UI",14));

        this.setPrefHeight(259);
        this.setPrefWidth(740);
        this.setStyle("-fx-background-color: #83DCF1");
        this.getChildren().add(numberLabel);
        this.getChildren().add(termLabel);
        this.getChildren().add(definitionLabel);
        this.getChildren().add(termTextArea);
        this.getChildren().add(definitionTextArea);
    }

    public void setNumberLabel(int i){
        numberLabel.setText("#" + String.valueOf(i));
    }

    public String getTerm(){
        return termTextArea.getText();
    }

    public String getDefinition(){
        return definitionTextArea.getText();
    }
}
