package com.example.c195.Controller;

import com.example.c195.DBaccess.DBCountry;
import com.example.c195.DBaccess.DBCustomer;
import com.example.c195.DBaccess.DBDivision;
import com.example.c195.Model.Country;
import com.example.c195.Model.Customer;
import com.example.c195.Model.Division;
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
import java.util.ResourceBundle;

public class ModifyCustomerController implements Initializable {

    private static Customer chosen = null;
    public TextField ModifyCustID;
    public TextField ModifyCustName;
    public TextField ModifyCustAddress;
    public TextField ModifyPostalCode;
    public TextField ModifyCustPhone;
    public ComboBox<Division> FLDBox;
    public ComboBox<Country> CountryBox;

    public static void passCustomerdata(Customer customer){
        chosen = customer;
    }

    public void OnSaveModify(ActionEvent actionEvent) {
        try{
            String custname = ModifyCustName.getText();
            String address = ModifyCustAddress.getText();
            String PostalCode = ModifyPostalCode.getText();
            String Phone = ModifyCustPhone.getText();
            String Country = CountryBox.getSelectionModel().getSelectedItem().toString();
            int fldid = FLDBox.getValue().getFldid();
            String fld = FLDBox.getValue().getFLD();


            System.out.println((custname + "" + address + "" + PostalCode + "" + Phone + "" + Country + "" + fldid + ""));

            int custid = 4;






            DBCustomer.modifyCustomer(custid, custname, address, PostalCode, Phone, fldid);

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

    public void OnCancelModify(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(ModifyCustomerController.class.getResource("/com/example/C195/view/MainScreen.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1000, 625);
        stage.setTitle("MainScreen");
        stage.setScene(scene);
        stage.show();
    }

    public void OnSelectCountry(ActionEvent actionEvent) {
        if (CountryBox.getSelectionModel().getSelectedItem().getCountryid() == 1) {
            FLDBox.setItems(DBDivision.GetUS());

        } else if (CountryBox.getSelectionModel().getSelectedItem().getCountryid() == 2) {
            FLDBox.setItems(DBDivision.GetUK());
        } else if (CountryBox.getSelectionModel().getSelectedItem().getCountryid() == 3) {
            FLDBox.setItems(DBDivision.GetCanada());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ModifyCustID.setText(String.valueOf(chosen.getId()));
        ModifyCustName.setText(String.valueOf(chosen.getName()));
        ModifyCustAddress.setText(String.valueOf(chosen.getAddress()));
        ModifyPostalCode.setText(String.valueOf(chosen.getPostalcode()));
        ModifyCustPhone.setText(String.valueOf(chosen.getPhone()));
        CountryBox.setItems(DBCountry.getAllCountry());
        FLDBox.setItems(DBDivision.getAllDivisions());

    }
}
