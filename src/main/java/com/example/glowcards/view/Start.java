package com.example.glowcards.view;

import com.example.glowcards.control.User;
import com.example.glowcards.control.UserController;
import com.example.glowcards.control.UserFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

        User newUser = UserFactory.getINSTANCE().createUser(username,password);
        UserController.getINSTANCE().addUser(newUser);

        URL fxmlLocation = getClass().getResource("/fxml/Home.fxml");
        FXMLLoader loader = new FXMLLoader(fxmlLocation);
        root = loader.load();

        Home homeController = loader.getController();
        homeController.setUsername(username);
        homeController.display();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
