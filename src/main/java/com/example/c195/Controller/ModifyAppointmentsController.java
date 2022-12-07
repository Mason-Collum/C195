package com.example.c195.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ModifyAppointmentsController {
    public TextField ModifyAppID;
    public TextField ModifyTitle;
    public TextField ModifyDes;
    public TextField ModifyLocation;
    public TextField ModifyContact;
    public TextField ModifyType;
    public TextField ModifyStart;
    public TextField ModifyEnd;
    public TextField ModifyCustID;
    public TextField ModifyUserID;

    public void OnSave(ActionEvent actionEvent) {
    }

    public void OnCancel(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(ModifyAppointmentsController.class.getResource("Appointments.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1000, 625);
        stage.setTitle("Appointments");
        stage.setScene(scene);
        stage.show();
    }
}
