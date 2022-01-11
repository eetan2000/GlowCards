package com.example.glowcards.view;

import com.example.glowcards.control.CueCardFactory;
import com.example.glowcards.control.UserController;
import com.example.glowcards.model.CueCard;
import com.example.glowcards.model.Set;
import com.example.glowcards.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class Create {
    @FXML
    private AnchorPane componentAnchorPane;
    @FXML
    private VBox mainVBox;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private TextField titleTextField;
    @FXML
    private Label nameLabel;

    private Parent root;
    private Scene scene;
    private Stage stage;

    private int SPACING_BETWEEN_CARDS = 0;
    private ArrayList<CardCreator> cardCreatorArrayList = new ArrayList<>();
    private User user;
    private int numOfCards = 0;

    public void setUp() {
        for (int i = 0; i < 5; i++) {
            CardCreator newCard = new CardCreator();
            newCard.setTranslateX(14);
            newCard.setTranslateY(127 + SPACING_BETWEEN_CARDS);

            componentAnchorPane.setPrefHeight(480 + (SPACING_BETWEEN_CARDS));
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

        componentAnchorPane.setPrefHeight(480 + (SPACING_BETWEEN_CARDS));
        SPACING_BETWEEN_CARDS += 330;
        numOfCards++;
        newCard.setNumberLabel(numOfCards);

        componentAnchorPane.getChildren().add(newCard);
        cardCreatorArrayList.add(newCard);
    }

    public void createSet(ActionEvent event) {
        Set newSet = new Set(titleTextField.getText());
        for (CardCreator curCardCreator : cardCreatorArrayList){
            String newTerm = curCardCreator.getTerm();
            String newDefinition = curCardCreator.getDefinition();
            CueCard newCueCard = CueCardFactory.getINSTANCE().createCueCard(newTerm,newDefinition);

            newSet.addCard(newCueCard);
        }
        user.addSet(newSet);
        UserController.getINSTANCE().saveUser(user);
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

    public void setUser(User user){
        this.user = user;
        nameLabel.setText(user.getName());
    }
}
