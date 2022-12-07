package com.example.c195;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AppointmentsController {
    public void OnToCustomers(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(AppointmentsController.class.getResource("MainScreen.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1000, 625);
        stage.setTitle("MainScreen");
        stage.setScene(scene);
        stage.show();
    }

    public void OnAddAppointment(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(AppointmentsController.class.getResource("AddAppointment.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1000, 625);
        stage.setTitle("Add Appointment");
        stage.setScene(scene);
        stage.show();
    }

    public void OnModifyAppointment(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(AppointmentsController.class.getResource("Modify Appointments.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1000, 625);
        stage.setTitle("Modify Appointment");
        stage.setScene(scene);
        stage.show();
    }
}
