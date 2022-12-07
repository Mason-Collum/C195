package com.example.c195;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ModifyCustomerController {
    public TextField ModifyCustID;
    public TextField ModifyCustName;
    public TextField ModifyCustAddress;
    public TextField ModifyCustFLD;
    public TextField ModifyCountry;
    public TextField ModifyPostalCode;
    public TextField ModifyCustPhone;

    public void OnSaveModify(ActionEvent actionEvent) {
    }

    public void OnCancelModify(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(ModifyCustomerController.class.getResource("MainScreen.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1000, 625);
        stage.setTitle("MainScreen");
        stage.setScene(scene);
        stage.show();
    }
}
