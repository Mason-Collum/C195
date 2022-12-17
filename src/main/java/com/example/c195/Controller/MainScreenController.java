package com.example.c195.Controller;

import com.example.c195.DBaccess.DBCustomer;
import com.example.c195.DBaccess.DBDivision;
import com.example.c195.Model.Customer;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

public class MainScreenController implements Initializable {
    private static Customer modifycustomer;
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
        Parent root = FXMLLoader.load(MainScreenController.class.getResource("/com/example/C195/view/AddCustomer.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1000, 625);
        stage.setTitle("Add Customer");
        stage.setScene(scene);
        stage.show();
    }

    public void OnCustomerAppointments(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(MainScreenController.class.getResource("/com/example/C195/view/Appointments.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1000, 625);
        stage.setTitle("Appointments");
        stage.setScene(scene);
        stage.show();
    }

    public void OnModifyCustomer(ActionEvent actionEvent) throws IOException {
        modifycustomer = (Customer) CustomerInfo.getSelectionModel().getSelectedItem();
        ModifyCustomerController.passCustomerdata(modifycustomer);

        if(modifycustomer == null){
            Alert popup = new Alert(Alert.AlertType.ERROR, "Must Select a Customer.");
            popup.showAndWait();
            return;
        }
        else if (modifycustomer != null) {
            Parent root = FXMLLoader.load(MainScreenController.class.getResource("/com/example/C195/view/ModifyCustomer.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 1000, 625);
            stage.setTitle("Modify Customer");
            stage.setScene(scene);
            stage.show();
        }
    }

    public void OnDeleteCustomer(ActionEvent actionEvent) throws SQLException, IOException {
        Alert popup = new Alert(Alert.AlertType.CONFIRMATION, "Do you wish to delete?");
        Optional<ButtonType> confirm = popup.showAndWait();

        Customer chosen = (Customer) CustomerInfo.getSelectionModel().getSelectedItem();

        if (confirm.isPresent() && confirm.get() == ButtonType.OK) {

            DBCustomer.deleteCustomer(chosen.getId());
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

        CustomerInfo.setItems(DBCustomer.getAllCustomers());

        CustomerID.setCellValueFactory(new PropertyValueFactory<>("id"));
        CustomerName.setCellValueFactory(new PropertyValueFactory<>("name"));
        CustomerAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        PostalCode.setCellValueFactory(new PropertyValueFactory<>("postalcode"));
        Phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        FirstLevelDivison.setCellValueFactory(new PropertyValueFactory<>("Division"));





    }
}
