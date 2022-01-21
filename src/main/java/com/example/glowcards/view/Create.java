package com.example.glowcards.view;

import com.example.glowcards.control.CueCardFactory;
import com.example.glowcards.control.UserController;
import com.example.glowcards.model.CueCard;
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
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
    private ScrollPane scrollPane;
    @FXML
    private TextField titleTextField;
    @FXML
    private Label nameLabel;
    @FXML
    private Button homeSideButton;
    @FXML
    private Button createSideButton;
    @FXML
    private Button setsSideButton;
    @FXML
    private Button quizSideButton;
    @FXML
    private Button addCardButton;
    @FXML
    private Button createButton;
    @FXML
    private ImageView icon;

    private Parent root;
    private Scene scene;
    private Stage stage;

    private int SPACING_BETWEEN_CARDS = 0;
    private ArrayList<CardCreator> cardCreatorArrayList = new ArrayList<>();
    private User user;
    private int numOfCards = 0;

    public void setUp() {
        Image image = new Image(getClass().getResourceAsStream("/avatars/" + user.getImage()+".png"));
        icon.setImage(image);
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

        addCardButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                addCardButton.setStyle("-fx-background-color: #305F72");
            }
        });
        createButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                createButton.setStyle("-fx-background-color: #305F72");
            }
        });
        addCardButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                addCardButton.setStyle("-fx-background-color: #568EA6");
            }
        });
        createButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                createButton.setStyle("-fx-background-color: #568EA6");
            }
        });
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
        homeController.setUp();

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

    public void setUser(User user){
        this.user = user;
        nameLabel.setText(user.getName());
    }
}
