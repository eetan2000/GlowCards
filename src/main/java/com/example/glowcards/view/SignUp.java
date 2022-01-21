package com.example.glowcards.view;

import com.example.glowcards.model.User;
import com.example.glowcards.control.UserController;
import com.example.glowcards.control.UserFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class SignUp {
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private TextField confirmPasswordTextField;
    @FXML
    private Button createAccButton;

    @FXML
    private Button falconButton;
    @FXML
    private Button orangutanButton;
    @FXML
    private Button owlButton;
    @FXML
    private Button penguinButton;
    @FXML
    private Button storkButton;
    @FXML
    private Button zebraButton;


    private Stage stage;
    private Scene scene;
    private Parent root;

    private String imageSelected;

    public void createAcc(ActionEvent event) throws IOException {
        String name = nameTextField.getText();
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();
        if (!password.equals(confirmPasswordTextField.getText())){
            Alert passwordAlert = new Alert(Alert.AlertType.ERROR);
            passwordAlert.setContentText("Your password does not match.");
            passwordAlert.showAndWait();
        }
        else if (imageSelected == null) {
            Alert passwordAlert = new Alert(Alert.AlertType.ERROR);
            passwordAlert.setContentText("Please choose an avatar.");
            passwordAlert.showAndWait();
        }
        else if (!UserController.getINSTANCE().uniqueUsername(username)){
            Alert passwordAlert = new Alert(Alert.AlertType.ERROR);
            passwordAlert.setContentText("There is already a user with the same username.");
            passwordAlert.showAndWait();
        }
        else if (nameTextField.getText().isEmpty() && usernameTextField.getText().isEmpty() && passwordTextField.getText().isEmpty()) {
            Alert passwordAlert = new Alert(Alert.AlertType.ERROR);
            passwordAlert.setContentText("You have left one of the boxes blank.");
            passwordAlert.showAndWait();
        }
        else {
            User newUser = UserFactory.getINSTANCE().createUser(name,username,password,imageSelected);
            UserController.getINSTANCE().addUser(newUser);
            UserController.getINSTANCE().saveUser(newUser);

            URL fxmlLocation = getClass().getResource("/fxml/Home.fxml");
            FXMLLoader loader = new FXMLLoader(fxmlLocation);
            root = loader.load();

            Home homeController = loader.getController();
            homeController.setUser(newUser);
            homeController.setUp();

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    public void returnToStart(ActionEvent event) throws IOException {
        URL fxmlLocation = getClass().getResource("/fxml/Start.fxml");
        FXMLLoader loader = new FXMLLoader(fxmlLocation);
        Parent root = loader.load();

        Start startController = loader.getController();


        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void falcon(ActionEvent event) {
        imageSelected = "falcon";
        falconButton.setStyle("-fx-background-color: #F1828D");
        orangutanButton.setStyle("-fx-background-color: #FEFAD4");
        owlButton.setStyle("-fx-background-color: #FEFAD4");
        penguinButton.setStyle("-fx-background-color: #FEFAD4");
        storkButton.setStyle("-fx-background-color: #FEFAD4");
        zebraButton.setStyle("-fx-background-color: #FEFAD4");
    }

    public void orangutan(ActionEvent event) {
        imageSelected = "orangutan";
        falconButton.setStyle("-fx-background-color: #FEFAD4");
        orangutanButton.setStyle("-fx-background-color: #F1828D");
        owlButton.setStyle("-fx-background-color: #FEFAD4");
        penguinButton.setStyle("-fx-background-color: #FEFAD4");
        storkButton.setStyle("-fx-background-color: #FEFAD4");
        zebraButton.setStyle("-fx-background-color: #FEFAD4");
    }

    public void owl(ActionEvent event) {
        imageSelected = "owl";
        falconButton.setStyle("-fx-background-color: #FEFAD4");
        orangutanButton.setStyle("-fx-background-color: #FEFAD4");
        owlButton.setStyle("-fx-background-color: #F1828D");
        penguinButton.setStyle("-fx-background-color: #FEFAD4");
        storkButton.setStyle("-fx-background-color: #FEFAD4");
        zebraButton.setStyle("-fx-background-color:  #FEFAD4");
    }

    public void penguin(ActionEvent event) {
        imageSelected = "penguin";
        falconButton.setStyle("-fx-background-color: #FEFAD4");
        orangutanButton.setStyle("-fx-background-color: #FEFAD4");
        owlButton.setStyle("-fx-background-color: #FEFAD4");
        penguinButton.setStyle("-fx-background-color: #F1828D");
        storkButton.setStyle("-fx-background-color: #FEFAD4");
        zebraButton.setStyle("-fx-background-color: #FEFAD4");
    }

    public void stork(ActionEvent event) {
        imageSelected = "stork";
        falconButton.setStyle("-fx-background-color: #FEFAD4");
        orangutanButton.setStyle("-fx-background-color: #FEFAD4");
        owlButton.setStyle("-fx-background-color: #FEFAD4");
        penguinButton.setStyle("-fx-background-color: #FEFAD4");
        storkButton.setStyle("-fx-background-color: #F1828D");
        zebraButton.setStyle("-fx-background-color: #FEFAD4");
    }

    public void zebra(ActionEvent event) {
        imageSelected = "zebra";
        falconButton.setStyle("-fx-background-color: #FEFAD4");
        orangutanButton.setStyle("-fx-background-color: #FEFAD4");
        owlButton.setStyle("-fx-background-color: #FEFAD4");
        penguinButton.setStyle("-fx-background-color: #FEFAD4");
        storkButton.setStyle("-fx-background-color: #FEFAD4");
        zebraButton.setStyle("-fx-background-color: #F1828D");
    }

}
