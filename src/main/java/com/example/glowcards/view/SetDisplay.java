package com.example.glowcards.view;

import com.example.glowcards.model.Set;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class SetDisplay {
    private Text cardText;
    private Button rightButton;
    private Button leftButton;
    private Label numOfTermsLabel;
    private AnchorPane mainAnchorPane;
    private Pane cardPane;

    private Set set;
    private int index;
    private String termOrDefinition = "term";

    public SetDisplay(Set set) {
        this.set = set;
        index = 0;

        cardText = new Text();
        rightButton = new Button("→");
        leftButton = new Button("←");
        numOfTermsLabel = new Label();
        mainAnchorPane = new AnchorPane();
        cardPane = new Pane();

        mainAnchorPane.setPrefHeight(500);
        mainAnchorPane.setPrefWidth(700);

        cardPane.setPrefHeight(300);
        cardPane.setPrefWidth(460);
        cardPane.setStyle("-fx-background-color :  #34dcde");
        cardPane.setLayoutX(120);
        cardPane.setLayoutY(58);

        rightButton.setPrefHeight(40);
        rightButton.setPrefWidth(100);
        rightButton.setLayoutY(388);
        rightButton.setLayoutX(378);
        rightButton.setFocusTraversable(false);
        leftButton.setPrefHeight(40);
        leftButton.setPrefWidth(100);
        leftButton.setLayoutY(388);
        leftButton.setLayoutX(219);
        leftButton.setFocusTraversable(false);

        numOfTermsLabel.setPrefWidth(57);
        numOfTermsLabel.setPrefHeight(29);
        numOfTermsLabel.setLayoutY(438);
        numOfTermsLabel.setLayoutX(321);

        cardText.setWrappingWidth(416);
        cardText.setLayoutX(22);
        cardText.setLayoutY(150);
        cardText.setTextOrigin(VPos.CENTER);
        cardText.setTextAlignment(TextAlignment.CENTER);

        cardText.setText(getTerm(index));
        numOfTermsLabel.setText((index + 1) + "/" + set.getSize());

        cardPane.getChildren().add(cardText);
        mainAnchorPane.getChildren().add(cardPane);
        mainAnchorPane.getChildren().add(rightButton);
        mainAnchorPane.getChildren().add(leftButton);
        mainAnchorPane.getChildren().add(numOfTermsLabel);

        rightButton.setOnAction(event -> rightButton());
        leftButton.setOnAction(event -> leftButton());

        cardPane.setOnMouseClicked(mouseEvent -> switchCard());
    }

    public String getTerm(int index) {
        return set.getTerm(index);
    }

    public String getDefinition(int index) {
        return set.getDefinition(index);
    }

    public void rightButton() {
        if (index != set.getSize() - 1) {
            index++;
            cardText.setText(getTerm(index));
            numOfTermsLabel.setText((index + 1) + "/" + set.getSize());
            termOrDefinition = "term";
        }
    }

    public void leftButton() {
        if (index != 0) {
            index--;
            cardText.setText(getTerm(index));
            numOfTermsLabel.setText((index + 1) + "/" + set.getSize());
            termOrDefinition = "term";
        }
    }

    public void switchCard() {
        if (termOrDefinition.equals("term")) {
            cardText.setText(getDefinition(index));
            termOrDefinition = "definition";
        } else {
            cardText.setText(getTerm(index));
            termOrDefinition = "term";
        }
    }

    public void startForm() {
        Scene scene = new Scene(mainAnchorPane);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}
