package com.example.c195.Controller;

import com.example.c195.DBaccess.DBAppointments;
import com.example.c195.DBaccess.DBCustomer;
import com.example.c195.Model.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class Report3Controller {

    /** This table hold appointment information once generated.*/
    public TableView infoTable;

    /** This column holds the appointment ID.*/
    public TableColumn appID;

/** This column holds the appointment title.*/
    public TableColumn title;

/** This column holds the appointment description.*/
    public TableColumn description;

/** This column holds the appointment location.*/
    public TableColumn location;

/** This column holds the appointment type.*/
    public TableColumn type;

/** This column holds the appointment Start.*/
    public TableColumn start;

/** This column holds the appointment End.*/
    public TableColumn end;

/** This column holds the customer ID.*/
    public TableColumn customerID;

/** This column holds the user ID.*/
    public TableColumn userID;

    /** This column hold the contact ID.*/
    public TableColumn contactID;

    /** This text field is where the customer ID is entered.*/
    public TextField idField;


    /** This method will populate the table with appointment information, once a proper customer ID has been entered.
     *
     * @param actionEvent
     */
    public void onSubmit(ActionEvent actionEvent) {
        String custid = idField.getText();
        int cid = Integer.parseInt(custid);

        infoTable.setItems(DBAppointments.sortByCustID(cid));

        appID.setCellValueFactory(new PropertyValueFactory<>("appointmentid"));
        title.setCellValueFactory(new PropertyValueFactory<>("title"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        location.setCellValueFactory(new PropertyValueFactory<>("location"));
        contactID.setCellValueFactory(new PropertyValueFactory<>("contact"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        start.setCellValueFactory(new PropertyValueFactory<>("Start"));
        end.setCellValueFactory(new PropertyValueFactory<>("End"));
        customerID.setCellValueFactory(new PropertyValueFactory<>("customerid"));
        userID.setCellValueFactory(new PropertyValueFactory<>("userid"));
    }

    /** This method will redirect to the main screen upon activation.
     *
     * @param actionEvent
     * @throws IOException
     */
    public void toMainScreen(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("/com/example/C195/view/MainScreen.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 715, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}
