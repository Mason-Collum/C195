package com.example.c195.Controller;

import com.example.c195.DBaccess.DBuser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.ZoneId;
import java.util.Locale;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public TextField usernamefield;
    public TextField passwordfield;
    public Label PageLabel;
    public Label UsernameLabel;
    public Label PasswordLabel;
    public Button SubmitButton;
    public Label userzoneid;

    @FXML


    public void OnSubmit(ActionEvent actionEvent) throws IOException {
        String username = usernamefield.getText();
        String password = passwordfield.getText();

        if (DBuser.verifyLogin(username, password)) {
            FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("/com/example/C195/view/MainScreen.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(fxmlLoader.load(), 715, 400);
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();


        }



    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        userzoneid.setText(ZoneId.systemDefault().toString());
        
        resourceBundle = ResourceBundle.getBundle("com/example/c195/Nat_"+ Locale.getDefault());

        

        usernamefield.setPromptText(resourceBundle.getString("Usernameprompt"));
        passwordfield.setPromptText(resourceBundle.getString("Passwordprompt"));
        PageLabel.setText(resourceBundle.getString("Login"));
        UsernameLabel.setText(resourceBundle.getString("Username"));
        PasswordLabel.setText(resourceBundle.getString("Password"));
        SubmitButton.setText(resourceBundle.getString("Submit"));



    }
}