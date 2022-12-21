package com.example.c195.Controller;

import com.example.c195.DBaccess.DBAppointments;
import com.example.c195.DBaccess.DBContact;
import com.example.c195.DBaccess.DBCustomer;
import com.example.c195.Model.Contacts;
import com.example.c195.Model.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ContactReportController implements Initializable {

    public TableColumn apptID;
    public TableView CustReport;
    public TableColumn Title;
    public TableColumn Description;
    public TableColumn Location;
    public TableColumn Type;
    public TableColumn Start;
    public TableColumn End;
    public TableColumn CustID;
    public ComboBox <Contacts> ContactBox;

    public void onCustomerChosen(ActionEvent actionEvent) {
        if(ContactBox.getSelectionModel().getSelectedItem().getContactid() == 1){
            CustReport.setItems(DBAppointments.getContID1());
            apptID.setCellValueFactory(new PropertyValueFactory<>("appointmentid"));
            Title.setCellValueFactory(new PropertyValueFactory<>("title"));
            Description.setCellValueFactory(new PropertyValueFactory<>("description"));
            Location.setCellValueFactory(new PropertyValueFactory<>("location"));
            Type.setCellValueFactory(new PropertyValueFactory<>("type"));
            Start.setCellValueFactory(new PropertyValueFactory<>("Start"));
            End.setCellValueFactory(new PropertyValueFactory<>("End"));
            CustID.setCellValueFactory(new PropertyValueFactory<>("customerid"));
        }
        else if(ContactBox.getSelectionModel().getSelectedItem().getContactid() == 2){
            CustReport.setItems(DBAppointments.getContID2());
            apptID.setCellValueFactory(new PropertyValueFactory<>("appointmentid"));
            Title.setCellValueFactory(new PropertyValueFactory<>("title"));
            Description.setCellValueFactory(new PropertyValueFactory<>("description"));
            Location.setCellValueFactory(new PropertyValueFactory<>("location"));
            Type.setCellValueFactory(new PropertyValueFactory<>("type"));
            Start.setCellValueFactory(new PropertyValueFactory<>("Start"));
            End.setCellValueFactory(new PropertyValueFactory<>("End"));
            CustID.setCellValueFactory(new PropertyValueFactory<>("customerid"));

        }
        else if(ContactBox.getSelectionModel().getSelectedItem().getContactid() == 3){
            CustReport.setItems(DBAppointments.getContID3());
            apptID.setCellValueFactory(new PropertyValueFactory<>("appointmentid"));
            Title.setCellValueFactory(new PropertyValueFactory<>("title"));
            Description.setCellValueFactory(new PropertyValueFactory<>("description"));
            Location.setCellValueFactory(new PropertyValueFactory<>("location"));
            Type.setCellValueFactory(new PropertyValueFactory<>("type"));
            Start.setCellValueFactory(new PropertyValueFactory<>("Start"));
            End.setCellValueFactory(new PropertyValueFactory<>("End"));
            CustID.setCellValueFactory(new PropertyValueFactory<>("customerid"));
        }
        else if(ContactBox.getSelectionModel().getSelectedItem().getContactid() == 4){
            CustReport.setItems(DBAppointments.getContID3());
            apptID.setCellValueFactory(new PropertyValueFactory<>("appointmentid"));
            Title.setCellValueFactory(new PropertyValueFactory<>("title"));
            Description.setCellValueFactory(new PropertyValueFactory<>("description"));
            Location.setCellValueFactory(new PropertyValueFactory<>("location"));
            Type.setCellValueFactory(new PropertyValueFactory<>("type"));
            Start.setCellValueFactory(new PropertyValueFactory<>("Start"));
            End.setCellValueFactory(new PropertyValueFactory<>("End"));
            CustID.setCellValueFactory(new PropertyValueFactory<>("customerid"));
        } else if (ContactBox.getSelectionModel().getSelectedItem().getContactid() == 5){
            CustReport.setItems(DBAppointments.getContID3());
            apptID.setCellValueFactory(new PropertyValueFactory<>("appointmentid"));
            Title.setCellValueFactory(new PropertyValueFactory<>("title"));
            Description.setCellValueFactory(new PropertyValueFactory<>("description"));
            Location.setCellValueFactory(new PropertyValueFactory<>("location"));
            Type.setCellValueFactory(new PropertyValueFactory<>("type"));
            Start.setCellValueFactory(new PropertyValueFactory<>("Start"));
            End.setCellValueFactory(new PropertyValueFactory<>("End"));
            CustID.setCellValueFactory(new PropertyValueFactory<>("customerid"));

            }
        }


    public void onButtonClicked(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("/com/example/C195/view/MainScreen.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 715, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ContactBox.setItems(DBContact.getAllContacts());

        apptID.setCellValueFactory(new PropertyValueFactory<>("appointmentid"));
        Title.setCellValueFactory(new PropertyValueFactory<>("title"));
        Description.setCellValueFactory(new PropertyValueFactory<>("description"));
        Location.setCellValueFactory(new PropertyValueFactory<>("location"));
        Type.setCellValueFactory(new PropertyValueFactory<>("type"));
        Start.setCellValueFactory(new PropertyValueFactory<>("Start"));
        End.setCellValueFactory(new PropertyValueFactory<>("End"));
        CustID.setCellValueFactory(new PropertyValueFactory<>("customerid"));
    }
}
