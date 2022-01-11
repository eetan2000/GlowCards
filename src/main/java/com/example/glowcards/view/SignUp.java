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

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void createAcc(ActionEvent event) throws IOException {
        String name = nameTextField.getText();
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();
        if (!password.equals(confirmPasswordTextField.getText())){
            Alert passwordAlert = new Alert(Alert.AlertType.ERROR);
            passwordAlert.setContentText("Your password does not match.");
            passwordAlert.showAndWait();
        }
        if (!UserController.getINSTANCE().uniqueUsername(username)){
            Alert passwordAlert = new Alert(Alert.AlertType.ERROR);
            passwordAlert.setContentText("There is already a user with the same username.");
            passwordAlert.showAndWait();
        }
        else {
            User newUser = UserFactory.getINSTANCE().createUser(name,username,password);
            UserController.getINSTANCE().addUser(newUser);

            URL fxmlLocation = getClass().getResource("/fxml/Home.fxml");
            FXMLLoader loader = new FXMLLoader(fxmlLocation);
            root = loader.load();

            Home homeController = loader.getController();
            homeController.setUser(newUser);

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
}
