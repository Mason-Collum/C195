package com.example.c195;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AddCustomerController {
    public TextField CustID;
    public TextField CustName;
    public TextField CustAddress;
    public TextField CustFLD;
    public TextField CustCountry;
    public TextField CustPostalCode;
    public TextField CustPhone;

    public void OnSave(ActionEvent actionEvent) {
    }

    public void OnCancel(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(AddCustomerController.class.getResource("MainScreen.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1000, 625);
        stage.setTitle("MainScreen");
        stage.setScene(scene);
        stage.show();
    }
}
