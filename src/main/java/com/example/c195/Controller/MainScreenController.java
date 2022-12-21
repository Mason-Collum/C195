package com.example.c195.Controller;

import com.example.c195.DBaccess.DBAppointments;
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

    /** This represents the customer chosen for modification.*/
    private static Customer modifycustomer;

    /** This represents the customer table view.*/
    public TableView CustomerInfo;

    /** This represents the Customer ID column of the customer table view.*/
    public TableColumn CustomerID;

    /** This represents the customer name column of the customer table view.*/
    public TableColumn CustomerName;

    /** This represents the customer Address column of the customer table view.*/
    public TableColumn CustomerAddress;

    /** This represents the customer country column of the customer table view.*/
    public TableColumn Country;

    /** This represents the customer postal code column of the customer table view.*/
    public TableColumn PostalCode;

    /** This represents the customer division column of the customer table view.*/
    public TableColumn FirstLevelDivison;

    /** This represents the customer phone number column of the customer table view.*/
    public TableColumn Phone;

    /** This button redirects to the appointment page.*/
    public Button ToAppointment;

    /** This button redirects to the add customer page.*/
    public Button ToAddCustomer;

    /** This button redirects to the modify customer page.*/
    public Button ToModifyCustomer;

    /** This button deletes selected customer.*/
    public Button DeleteCustomer;

    /** This function redirects the user to the add customer screen.
     *
     * @param actionEvent
     * @throws IOException
     */
    public void OnAddCustomer(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(MainScreenController.class.getResource("/com/example/C195/view/AddCustomer.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1000, 625);
        stage.setTitle("Add Customer");
        stage.setScene(scene);
        stage.show();
    }

    /** This function redirects to the Appointments screen.
     *
     * @param actionEvent
     * @throws IOException
     */
    public void OnCustomerAppointments(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(MainScreenController.class.getResource("/com/example/C195/view/Appointments.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1000, 625);
        stage.setTitle("Appointments");
        stage.setScene(scene);
        stage.show();
    }

    /** This function redirects to the modify customer screen.
     * It also transfers the selected customers information to the modify customer screen.
     * @param actionEvent
     * @throws IOException
     */
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

    /** This function deletes the selected Customer.
     * It first confirms whether that customer is deleted, and then if so, it deletes said customer.
     * It throws a warning when a customer is listed in appointments, and will not allow them to be deleted.
     * @param actionEvent
     * @throws SQLException
     * @throws IOException
     */
    public void OnDeleteCustomer(ActionEvent actionEvent) throws SQLException, IOException {
        Alert popup = new Alert(Alert.AlertType.CONFIRMATION, "Do you wish to delete?");
        Optional<ButtonType> confirm = popup.showAndWait();

        Customer chosen = (Customer) CustomerInfo.getSelectionModel().getSelectedItem();

        if (confirm.isPresent() && confirm.get() == ButtonType.OK) {
            DBAppointments.deleteFromCustomer(chosen.getId());
            DBCustomer.deleteCustomer(chosen.getId());
            FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("/com/example/C195/view/MainScreen.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(fxmlLoader.load(), 715, 400);
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();

        }
    }

    /** This function initializes the main screen.
     * It populates the Customer tableview.
     * @param url
     * @param resourceBundle
     */
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
    
    

    public void onReport2(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("/com/example/C195/view/ContactReport.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 715, 700);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public void onReport1(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("/com/example/C195/view/CustomerAppointmentsReport.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 715, 700);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public void onReport3(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("/com/example/C195/view/Report3.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 800, 700);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}
