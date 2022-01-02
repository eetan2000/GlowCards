package com.example.glowcards.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Create {
    @FXML
    private AnchorPane componentAnchorPane;
    @FXML
    private VBox mainVBox;

    private Parent root;
    private Scene scene;
    private Stage stage;

    @FXML
    private ScrollPane scrollPane;

    private int SPACING_BETWEEN_CARDS = 0;
    private ArrayList<CardCreator> cardCreatorArrayList = new ArrayList<>();
    private int numOfCards = 0;

    public void setUp() {
        for (int i = 0; i < 5; i++) {
            CardCreator newCard = new CardCreator();
            newCard.setTranslateX(14);
            newCard.setTranslateY(127 + SPACING_BETWEEN_CARDS);

            componentAnchorPane.setPrefHeight(480 + (SPACING_BETWEEN_CARDS - 70));
            SPACING_BETWEEN_CARDS += 330;
            componentAnchorPane.getChildren().add(newCard);
            newCard.setNumberLabel(i + 1);

            numOfCards++;
            cardCreatorArrayList.add(newCard);
        }
    }

    public void addCard(ActionEvent event) {
        CardCreator newCard = new CardCreator();
        newCard.setTranslateX(14);
        newCard.setTranslateY(127 + SPACING_BETWEEN_CARDS);

        componentAnchorPane.setPrefHeight(480 + (SPACING_BETWEEN_CARDS - 70));
        SPACING_BETWEEN_CARDS += 254;
        numOfCards++;
        newCard.setNumberLabel(numOfCards);

        componentAnchorPane.getChildren().add(newCard);
        cardCreatorArrayList.add(newCard);
    }

    public void createSet(ActionEvent event) {

    }

    public void homeSideButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Home.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
