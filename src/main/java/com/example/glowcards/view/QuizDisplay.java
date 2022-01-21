package com.example.glowcards.view;

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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

public class QuizDisplay {
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
    private Button settingsSideButton;
    @FXML
    private Button checkAnswersButton;
    @FXML
    private AnchorPane mainAnchorPane;
    @FXML
    private Pane bottomPane;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private Label nameLabel;

    private int SPACING_BETWEEN_CARDS = 0;

    private Set set;
    private ArrayList<QuizQuestion> arrOfQuestions = new ArrayList<>();
    private User user;
    private float score;


    public void setUp(Set setInput) {
        this.set = setInput;
        for (int i = 0; i < set.getSetArrayList().size(); i++) {
            CueCard curCueCard = set.getSetArrayList().get(i);
            QuizQuestion newQuestion = new QuizQuestion();
            newQuestion.setLayoutX(32);
            newQuestion.setLayoutY(69 + SPACING_BETWEEN_CARDS);
            newQuestion.setDefinitionLabel(curCueCard.getDefinition());
            newQuestion.setSize(set.getSetArrayList().size());
            newQuestion.setNumber(i + 1);

            Integer[] arr = new Integer[3];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = (int) ((Math.random() * (set.getSetArrayList().size())));
                while (arr[j] == i || Arrays.asList(arr).contains(i)) {
                    arr[j] = (int) ((Math.random() * (set.getSetArrayList().size())));
                }
            }

            newQuestion.createQuestion(curCueCard,set.getSetArrayList().get(arr[0]), set.getSetArrayList().get(arr[1]), set.getSetArrayList().get(arr[2]));

            arrOfQuestions.add(newQuestion);
            componentAnchorPane.getChildren().add(newQuestion);
            componentAnchorPane.setPrefHeight(480 + SPACING_BETWEEN_CARDS);
            SPACING_BETWEEN_CARDS += 449;
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
        checkAnswersButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                checkAnswersButton.setStyle("-fx-background-color: #305F72");
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
        checkAnswersButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                checkAnswersButton.setStyle("-fx-background-color: #568EA6");
            }
        });
    }

    public void checkAnswers(ActionEvent event) {
        float correctAnswers = 0;
        float size = set.getSize();
        componentAnchorPane.getChildren().clear();
        mainAnchorPane.getChildren().remove(bottomPane);
        scrollPane.setPrefHeight(600);
        scrollPane.setVvalue(0);

        for (QuizQuestion curQuestion : arrOfQuestions) {
            curQuestion.answerQuestion();

            componentAnchorPane.getChildren().add(curQuestion);
            if (curQuestion.isCorrect()) {
                correctAnswers++;
            }
        }
        this.score = correctAnswers/size * 100;
        int roundedScore = Math.round(score);
        UserController.getINSTANCE().setScore(user.getUsername(), set.getTitle(), roundedScore);
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

    public void createSideButton(ActionEvent event) throws IOException {
        URL fxmlLocation = getClass().getResource("/fxml/Create.fxml");
        FXMLLoader loader = new FXMLLoader(fxmlLocation);
        Parent root = loader.load();

        Create createController = loader.getController();
        createController.setUp();
        createController.setUser(user);

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

    public void setUser(User user) {
        this.user = user;
        nameLabel.setText(user.getName());
    }
}
