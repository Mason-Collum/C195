package com.example.c195;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class MainScreenController {
    
    public TableView CustomerInfo;
    public TableColumn CustomerID;
    public TableColumn CustomerName;
    public TableColumn CustomerAddress;
    public TableColumn Country;
    public TableColumn PostalCode;
    public TableColumn FirstLevelDivison;
    public TableColumn Phone;
    public Button ToAppointment;
    public Button ToAddCustomer;
    public Button ToModifyCustomer;
    public Button DeleteCustomer;

    public void OnAddCustomer(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(MainScreenController.class.getResource("AddCustomer.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1000, 625);
        stage.setTitle("Add Customer");
        stage.setScene(scene);
        stage.show();
    }

    public void OnCustomerAppointments(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(MainScreenController.class.getResource("Appointments.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1000, 625);
        stage.setTitle("Appointments");
        stage.setScene(scene);
        stage.show();
    }

    public void OnModifyCustomer(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(MainScreenController.class.getResource("ModifyCustomer.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1000, 625);
        stage.setTitle("Modify Customer");
        stage.setScene(scene);
        stage.show();
    }

    public void OnDeleteCustomer(ActionEvent actionEvent) {
    }
}
