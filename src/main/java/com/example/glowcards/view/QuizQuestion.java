package com.example.glowcards.view;

import com.example.glowcards.model.CueCard;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.Arrays;
import java.util.Collections;

public class QuizQuestion extends Pane {
    private Label definitionLabel;
    private Label numLabel;
    private Label instructionLabel;
    private Pane checkBox1;
    private Pane checkBox2;
    private Pane checkBox3;
    private Pane checkBox4;
    private Label label1;
    private Label label2;
    private Label label3;
    private Label label4;

    private String answerKey;
    private String userAnswer;

    private boolean checkBox1Selected = false;
    private boolean checkBox2Selected = false;
    private boolean checkBox3Selected = false;
    private boolean checkBox4Selected = false;

    private int size;
    private boolean incorrect;

    private String term1;
    private String term2;
    private String term3;
    private String term4;
    private String definition;
    private String num;

    public QuizQuestion() {
        definitionLabel = new Label();
        numLabel = new Label();
        instructionLabel = new Label();
        checkBox1 = new Pane();
        checkBox2 = new Pane();
        checkBox3 = new Pane();
        checkBox4 = new Pane();
        label1 = new Label();
        label2 = new Label();
        label3 = new Label();
        label4 = new Label();

        definitionLabel.setPrefWidth(660);
        definitionLabel.setPrefHeight(114);
        numLabel.setPrefWidth(56);
        numLabel.setPrefHeight(23);
        instructionLabel.setPrefWidth(170);
        instructionLabel.setPrefHeight(20);
        checkBox1.setPrefWidth(276);
        checkBox1.setPrefHeight(68);
        checkBox2.setPrefWidth(276);
        checkBox2.setPrefHeight(68);
        checkBox3.setPrefWidth(276);
        checkBox3.setPrefHeight(68);
        checkBox4.setPrefWidth(276);
        checkBox4.setPrefHeight(68);
        label1.setPrefWidth(265);
        label1.setPrefHeight(59);
        label2.setPrefWidth(265);
        label2.setPrefHeight(59);
        label3.setPrefWidth(265);
        label3.setPrefHeight(59);
        label4.setPrefWidth(265);
        label4.setPrefHeight(59);

        definitionLabel.setLayoutX(35);
        definitionLabel.setLayoutY(55);
        numLabel.setLayoutX(630);
        numLabel.setLayoutY(32);
        instructionLabel.setLayoutX(35);
        instructionLabel.setLayoutY(159);
        checkBox1.setLayoutX(35);
        checkBox1.setLayoutY(182);
        checkBox2.setLayoutX(382);
        checkBox2.setLayoutY(182);
        checkBox3.setLayoutX(35);
        checkBox3.setLayoutY(260);
        checkBox4.setLayoutX(382);
        checkBox4.setLayoutY(260);
        label1.setLayoutX(6);
        label1.setLayoutY(4);
        label2.setLayoutX(6);
        label2.setLayoutY(4);
        label3.setLayoutX(6);
        label3.setLayoutY(4);
        label4.setLayoutX(6);
        label4.setLayoutY(4);

        checkBox1.getChildren().add(label1);
        checkBox2.getChildren().add(label2);
        checkBox3.getChildren().add(label3);
        checkBox4.getChildren().add(label4);

        definitionLabel.setWrapText(true);
        label1.setWrapText(true);
        label2.setWrapText(true);
        label3.setWrapText(true);
        label4.setWrapText(true);
        instructionLabel.setText("Choose matching term:");

        definitionLabel.setFont(new Font("Leelawadee UI",20));
        definitionLabel.setTextFill(Color.web("#ffffff"));
        instructionLabel.setFont(new Font("Leelawadee UI",14));
        instructionLabel.setTextFill(Color.web("#ffffff"));
        numLabel.setFont(new Font("Leelawadee UI" , 14));
        numLabel.setTextFill(Color.web("#ffffff"));
        label1.setFont(new Font("Leelawadee UI",14));
        label2.setFont(new Font("Leelawadee UI",14));
        label3.setFont(new Font("Leelawadee UI",14));
        label4.setFont(new Font("Leelawadee UI",14));
        label1.setTextFill(Color.web("#ffffff"));
        label2.setTextFill(Color.web("#ffffff"));
        label3.setTextFill(Color.web("#ffffff"));
        label4.setTextFill(Color.web("#ffffff"));
        label1.setWrapText(true);
        label2.setWrapText(true);
        label3.setWrapText(true);
        label4.setWrapText(true);

        this.getChildren().add(definitionLabel);
        this.getChildren().add(numLabel);
        this.getChildren().add(instructionLabel);
        this.getChildren().add(checkBox1);
        this.getChildren().add(checkBox2);
        this.getChildren().add(checkBox3);
        this.getChildren().add(checkBox4);
        this.setStyle("-fx-background-color: #568EA6");
        this.setPrefWidth(715);
        this.setPrefHeight(340);

        checkBox1.setOnMouseEntered(mouseEvent -> setBorderEntered(checkBox1));
        checkBox2.setOnMouseEntered(mouseEvent -> setBorderEntered(checkBox2));
        checkBox3.setOnMouseEntered(mouseEvent -> setBorderEntered(checkBox3));
        checkBox4.setOnMouseEntered(mouseEvent -> setBorderEntered(checkBox4));
        checkBox1.setOnMouseExited(mouseEvent -> setBorderExited());
        checkBox2.setOnMouseExited(mouseEvent -> setBorderExited());
        checkBox3.setOnMouseExited(mouseEvent -> setBorderExited());
        checkBox4.setOnMouseExited(mouseEvent -> setBorderExited());

        checkBox1.setOnMousePressed(mouseEvent -> setUserAnswer(label1, checkBox1, 1));
        checkBox2.setOnMousePressed(mouseEvent -> setUserAnswer(label2, checkBox2, 2));
        checkBox3.setOnMousePressed(mouseEvent -> setUserAnswer(label3, checkBox3, 3));
        checkBox4.setOnMousePressed(mouseEvent -> setUserAnswer(label4, checkBox4, 4));
    }

    public void answerQuestion() {
        this.getChildren().clear();
        definitionLabel = new Label();
        numLabel = new Label();
        instructionLabel = new Label();
        checkBox1 = new Pane();
        checkBox2 = new Pane();
        checkBox3 = new Pane();
        checkBox4 = new Pane();
        label1 = new Label();
        label2 = new Label();
        label3 = new Label();
        label4 = new Label();

        definitionLabel.setPrefWidth(660);
        definitionLabel.setPrefHeight(114);
        numLabel.setPrefWidth(56);
        numLabel.setPrefHeight(23);
        instructionLabel.setPrefWidth(170);
        instructionLabel.setPrefHeight(20);
        checkBox1.setPrefWidth(276);
        checkBox1.setPrefHeight(68);
        checkBox2.setPrefWidth(276);
        checkBox2.setPrefHeight(68);
        checkBox3.setPrefWidth(276);
        checkBox3.setPrefHeight(68);
        checkBox4.setPrefWidth(276);
        checkBox4.setPrefHeight(68);
        label1.setPrefWidth(265);
        label1.setPrefHeight(59);
        label2.setPrefWidth(265);
        label2.setPrefHeight(59);
        label3.setPrefWidth(265);
        label3.setPrefHeight(59);
        label4.setPrefWidth(265);
        label4.setPrefHeight(59);

        definitionLabel.setLayoutX(35);
        definitionLabel.setLayoutY(55);
        numLabel.setLayoutX(630);
        numLabel.setLayoutY(32);
        instructionLabel.setLayoutX(35);
        instructionLabel.setLayoutY(159);
        checkBox1.setLayoutX(35);
        checkBox1.setLayoutY(182);
        checkBox2.setLayoutX(382);
        checkBox2.setLayoutY(182);
        checkBox3.setLayoutX(35);
        checkBox3.setLayoutY(260);
        checkBox4.setLayoutX(382);
        checkBox4.setLayoutY(260);
        label1.setLayoutX(6);
        label1.setLayoutY(4);
        label2.setLayoutX(6);
        label2.setLayoutY(4);
        label3.setLayoutX(6);
        label3.setLayoutY(4);
        label4.setLayoutX(6);
        label4.setLayoutY(4);

        checkBox1.getChildren().add(label1);
        checkBox2.getChildren().add(label2);
        checkBox3.getChildren().add(label3);
        checkBox4.getChildren().add(label4);

        definitionLabel.setWrapText(true);
        label1.setWrapText(true);
        label2.setWrapText(true);
        label3.setWrapText(true);
        label4.setWrapText(true);

        definitionLabel.setFont(new Font("Leelawadee UI",20));
        definitionLabel.setTextFill(Color.web("#ffffff"));
        definitionLabel.setWrapText(true);
        instructionLabel.setFont(new Font("Leelawadee UI",12));
        instructionLabel.setTextFill(Color.web("#ffffff"));
        numLabel.setFont(new Font("Leelawadee UI" , 14));
        numLabel.setTextFill(Color.web("#ffffff"));
        label1.setFont(new Font("Leelawadee UI",14));
        label2.setFont(new Font("Leelawadee UI",14));
        label3.setFont(new Font("Leelawadee UI",14));
        label4.setFont(new Font("Leelawadee UI",14));
        label1.setTextFill(Color.web("#ffffff"));
        label2.setTextFill(Color.web("#ffffff"));
        label3.setTextFill(Color.web("#ffffff"));
        label4.setTextFill(Color.web("#ffffff"));
        label1.setWrapText(true);
        label2.setWrapText(true);
        label3.setWrapText(true);
        label4.setWrapText(true);

        this.getChildren().add(definitionLabel);
        this.getChildren().add(numLabel);
        this.getChildren().add(instructionLabel);
        this.getChildren().add(checkBox1);
        this.getChildren().add(checkBox2);
        this.getChildren().add(checkBox3);
        this.getChildren().add(checkBox4);
        this.setStyle("-fx-background-color: #568EA6");
        this.setPrefWidth(715);
        this.setPrefHeight(340);

        label1.setText(term1);
        label2.setText(term2);
        label3.setText(term3);
        label4.setText(term4);

        definitionLabel.setText(definition);
        instructionLabel.setText("Choose matching term:");
        numLabel.setText(num);

        if (isCorrect()) {
            if (checkBox1Selected) {
                checkBox1.setStyle("-fx-background-color: #28b87e");
            }
            if (checkBox2Selected) {
                checkBox2.setStyle("-fx-background-color: #28b87e");
            }
            if (checkBox3Selected) {
                checkBox3.setStyle("-fx-background-color: #28b87e");
            }
            if (checkBox4Selected) {
                checkBox4.setStyle("-fx-background-color: #28b87e");
            }
        }
        else if (userAnswer == null) {
            if (answerKey.equals(label1.getText())) {
                checkBox1.setStyle("-fx-background-color: #deb243");
            }
            if (answerKey.equals(label2.getText())) {
                checkBox2.setStyle("-fx-background-color: #deb243");
            }
            if (answerKey.equals(label3.getText())) {
                checkBox3.setStyle("-fx-background-color: #deb243");
            }
            if (answerKey.equals(label4.getText())) {
                checkBox4.setStyle("-fx-background-color: #deb243");
            }
            incorrect = true;
        }
        else {
            if (answerKey.equals(label1.getText())) {
                checkBox1.setStyle("-fx-background-color: #28b87e");
            }
            if (answerKey.equals(label2.getText())) {
                checkBox2.setStyle("-fx-background-color: #28b87e");
            }
            if (answerKey.equals(label3.getText())) {
                checkBox3.setStyle("-fx-background-color: #28b87e");
            }
            if (answerKey.equals(label4.getText())) {
                checkBox4.setStyle("-fx-background-color: #28b87e");
            }
            if (checkBox1Selected) {
                checkBox1.setStyle("-fx-background-color: #eb2a5a");
            }
            if (checkBox2Selected) {
                checkBox2.setStyle("-fx-background-color: #eb2a5a");
            }
            if (checkBox3Selected) {
                checkBox3.setStyle("-fx-background-color: #eb2a5a");
            }
            if (checkBox4Selected) {
                checkBox4.setStyle("-fx-background-color: #eb2a5a");
            }
            incorrect = true;
        }
    }

    public void createQuestion(CueCard answer, CueCard cueCard2, CueCard cueCard3, CueCard cueCard4) {
        answerKey = answer.getTerm();
        definitionLabel.setText(answer.getDefinition());
        CueCard[] arr = new CueCard[4];
        arr[0] = answer;
        arr[1] = cueCard2;
        arr[2] = cueCard3;
        arr[3] = cueCard4;
        Collections.shuffle(Arrays.asList(arr));

        label1.setText(arr[0].getTerm());
        label2.setText(arr[1].getTerm());
        label3.setText(arr[2].getTerm());
        label4.setText(arr[3].getTerm());

        term1 = arr[0].getTerm();
        term2 = arr[1].getTerm();
        term3 = arr[2].getTerm();
        term4 = arr[3].getTerm();
        definition = answer.getDefinition();
    }

    private void setUserAnswer(Label checkedLabel, Pane pane, int boxNumber) {
        if (boxNumber == 1) {
            checkBox1Selected = true;
            checkBox2Selected = false;
            checkBox3Selected = false;
            checkBox4Selected = false;
            selected(pane);
        }
        if (boxNumber == 2) {
            checkBox1Selected = false;
            checkBox2Selected = true;
            checkBox3Selected = false;
            checkBox4Selected = false;
            selected(pane);
        }
        if (boxNumber == 3) {
            checkBox1Selected = false;
            checkBox2Selected = false;
            checkBox3Selected = true;
            checkBox4Selected = false;
            selected(pane);
        }
        if (boxNumber == 4) {
            checkBox1Selected = false;
            checkBox2Selected = false;
            checkBox3Selected = false;
            checkBox4Selected = true;
            selected(pane);
        }
        userAnswer = checkedLabel.getText();
    }

    private void setBorderEntered(Pane pane) {
        pane.setStyle("-fx-background-color: #305F72");
    }

    private void setBorderExited() {
        if (!checkBox1Selected) {
            checkBox1.setStyle("-fx-background-color: #568EA6");
        }
        if (!checkBox2Selected) {
            checkBox2.setStyle("-fx-background-color: #568EA6");
        }
        if (!checkBox3Selected) {
            checkBox3.setStyle("-fx-background-color: #568EA6");
        }
        if (!checkBox4Selected) {
            checkBox4.setStyle("-fx-background-color: #568EA6");
        }
    }

    public boolean isCorrect() {
        if (userAnswer == null) {
            return false;
        }
        else {
            return userAnswer.equals(answerKey);
        }
    }

    public void setDefinitionLabel(String text) {
        definitionLabel.setText(text);
    }

    public void selected(Pane pane) {
        checkBox1.setStyle("-fx-background-color: #568EA6 ");
        checkBox2.setStyle("-fx-background-color: #568EA6 ");
        checkBox3.setStyle("-fx-background-color: #568EA6 ");
        checkBox4.setStyle("-fx-background-color: #568EA6 ");

        pane.setStyle("-fx-background-color: #305F72");
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setNumber(int cardNumber) {
        num = cardNumber + " of " + size;
        numLabel.setText(num);
    }

    public boolean isIncorrect() {
        return incorrect;
    }
}
