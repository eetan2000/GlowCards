package com.example.glowcards.view;

import com.example.glowcards.model.CueCard;
import com.example.glowcards.model.Set;
import com.example.glowcards.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

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

    private Button finishButton;

    private ArrayList<QuizQuestion> arrOfQuestions = new ArrayList<>();

    public void setUp(Set set) {
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
    }

    public void checkAnswers(ActionEvent event) {
        componentAnchorPane.getChildren().clear();
        mainAnchorPane.getChildren().remove(bottomPane);
        scrollPane.setPrefHeight(600);
        scrollPane.setVvalue(0);

        for (QuizQuestion curQuestion : arrOfQuestions) {
            curQuestion.answerQuestion();

            componentAnchorPane.getChildren().add(curQuestion);
        }
    }

    public void setUser(User user) {
        nameLabel.setText(user.getName());
    }
}
