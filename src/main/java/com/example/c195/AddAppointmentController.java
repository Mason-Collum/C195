package com.example.c195;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AddAppointmentController {
    public TextField AddAppID;
    public TextField AddTitle;
    public TextField AddDes;
    public TextField AddLocation;
    public TextField AddContact;
    public TextField AddStart;
    public TextField AddEnd;
    public TextField AddCustID;
    public TextField AddUserID;

    public void OnSave(ActionEvent actionEvent) {
    }

    public void OnCancel(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(AddAppointmentController.class.getResource("Appointments.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1000, 625);
        stage.setTitle("Appointments");
        stage.setScene(scene);
        stage.show();
    }
}
