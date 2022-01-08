package com.example.glowcards.view;

import com.example.glowcards.control.UserController;
import com.example.glowcards.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Start {
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passwordTextField;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void login(ActionEvent event) throws IOException {
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();

        URL fxmlLocation = getClass().getResource("/fxml/Home.fxml");
        FXMLLoader loader = new FXMLLoader(fxmlLocation);
        root = loader.load();

        Home homeController = loader.getController();
        User user = UserController.getINSTANCE().findUser(username, password);
        if (user == null){
            Alert passwordAlert = new Alert(Alert.AlertType.ERROR);
            passwordAlert.setContentText("Your username or password do not match any user.");
            passwordAlert.showAndWait();
        }
        else {
            homeController.setUser(user);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    public void signUp(ActionEvent event) throws IOException {
        URL fxmlLocation = getClass().getResource("/fxml/SignUp.fxml");
        FXMLLoader loader = new FXMLLoader(fxmlLocation);
        root = loader.load();

        SignUp signUpController = loader.getController();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
