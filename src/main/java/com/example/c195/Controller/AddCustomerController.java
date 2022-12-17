package com.example.c195.Controller;

import com.example.c195.DBaccess.DBCountry;
import com.example.c195.DBaccess.DBCustomer;
import com.example.c195.DBaccess.DBDivision;
import com.example.c195.Model.Country;
import com.example.c195.Model.Customer;
import com.example.c195.Model.Division;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

public class AddCustomerController implements Initializable {
    public TextField CustID;
    public TextField CustName;
    public TextField CustAddress;
    public TextField CustPostalCode;
    public TextField CustPhone;
    public ComboBox<Country> CountryBox;
    public ComboBox<Division> FLDBox;



    public void OnSave(ActionEvent actionEvent) throws IOException{
       try{
            String custname = CustName.getText();
            String address = CustAddress.getText();
            String PostalCode = CustPostalCode.getText();
            String Phone = CustPhone.getText();
            String Country = CountryBox.getSelectionModel().getSelectedItem().toString();
            int fldid = FLDBox.getValue().getFldid();
            String fld = FLDBox.getValue().getFLD();


            System.out.println((custname + "" + address + "" + PostalCode + "" + Phone + "" + Country + "" + fldid + ""));

            int custid = 4;



            


            DBCustomer.addCustomer(custid, custname, address, PostalCode, Phone, fldid);

           Parent root = FXMLLoader.load(AddCustomerController.class.getResource("/com/example/C195/view/MainScreen.fxml"));
           Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
           Scene scene = new Scene(root, 1000, 625);
           stage.setTitle("MainScreen");
           stage.setScene(scene);
           stage.show();




        } catch (Exception e) {
           throw new RuntimeException(e);
       }


    }


    public void OnCancel (ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(AddCustomerController.class.getResource("/com/example/C195/view/MainScreen.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1000, 625);
        stage.setTitle("MainScreen");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        CountryBox.setItems(DBCountry.getAllCountry());



        FLDBox.setItems(DBDivision.getAllDivisions());

    }




    public void OnFLDSelect(ActionEvent actionEvent) {
    }

    public void OnCountrySelect(ActionEvent actionEvent) throws SQLException {
        if(CountryBox.getSelectionModel().getSelectedItem().getCountryid() == 1){
            FLDBox.setItems(DBDivision.GetUS());

                    }
        else if (CountryBox.getSelectionModel().getSelectedItem().getCountryid() == 2) {
            FLDBox.setItems(DBDivision.GetUK());
        }
        else if (CountryBox.getSelectionModel().getSelectedItem().getCountryid() == 3){
            FLDBox.setItems(DBDivision.GetCanada());
    }


       }


}
