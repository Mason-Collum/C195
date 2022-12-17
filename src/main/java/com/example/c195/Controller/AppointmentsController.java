package com.example.c195.Controller;

import com.example.c195.DBaccess.DBAppointments;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AppointmentsController implements Initializable {
    public ToggleGroup Appointment;
    public TableView AppointmentTable;
    public TableColumn AppointmentID;
    public TableColumn Titlecolumn;
    public TableColumn DescriptionColumn;
    public TableColumn Locationcolumn;
    public TableColumn Contactcolumn;
    public TableColumn TypeColumn;
    public TableColumn Startcolumn;
    public TableColumn Endcolumn;
    public TableColumn CustomerColumn;
    public TableColumn Usercolumn;

    public void OnToCustomers(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(AppointmentsController.class.getResource("/com/example/C195/view/MainScreen.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1000, 625);
        stage.setTitle("MainScreen");
        stage.setScene(scene);
        stage.show();
    }

    public void OnAddAppointment(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(AppointmentsController.class.getResource("/com/example/C195/view/AddAppointment.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1000, 625);
        stage.setTitle("Add Appointment");
        stage.setScene(scene);
        stage.show();
    }

    public void OnModifyAppointment(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(AppointmentsController.class.getResource("/com/example/C195/view/Modify Appointments.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1000, 625);
        stage.setTitle("Modify Appointment");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AppointmentTable.setItems(DBAppointments.getAllAppointments());

        AppointmentID.setCellValueFactory(new PropertyValueFactory<>("appointmentid"));
        Titlecolumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        DescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        Locationcolumn.setCellValueFactory(new PropertyValueFactory<>("location"));
        Contactcolumn.setCellValueFactory(new PropertyValueFactory<>("contact"));
        TypeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        Startcolumn.setCellValueFactory(new PropertyValueFactory<>("Start"));
        Endcolumn.setCellValueFactory(new PropertyValueFactory<>("End"));
        CustomerColumn.setCellValueFactory(new PropertyValueFactory<>("customerid"));
        Usercolumn.setCellValueFactory(new PropertyValueFactory<>("userid"));

        
    }
}
