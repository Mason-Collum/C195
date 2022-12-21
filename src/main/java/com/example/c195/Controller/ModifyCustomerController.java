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

    /** This object represents the customer selected for modification.*/
    private static Customer chosen = null;

    /** This text field is where the modification is made to the customer ID.*/
    public TextField ModifyCustID;

    /** This text field is where the modification is made to the customer name.*/
    public TextField ModifyCustName;

    /** This text field is where the modification is made to the customer address.*/
    public TextField ModifyCustAddress;

    /** This text field is where the modification is made to the customer postal code.*/
    public TextField ModifyPostalCode;

    /** This text field is where the modification is made to the customer phone number.*/
    public TextField ModifyCustPhone;

    /** This combo box holds all of the available Divisions options.
     * The options will change depending on which country is selected.
     */
    public ComboBox<Division> FLDBox;

    /** This combo box holds all of the available country options.*/
    public ComboBox<Country> CountryBox;

    /** This function passes customer data from the table view.
     * The customer that was selected is set to chosen, and chosen is initialized.
     * @param customer
     */
    public static void passCustomerdata(Customer customer){
        chosen = customer;
    }

    /** This function saves the changes made to the customer.
     * It then redirects to the main screen.
     * @param actionEvent
     */
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

    /** This function cancels the changes made to the customer.
     * It then redirects to the main screen.
     * @param actionEvent
     * @throws IOException
     */
    public void OnCancelModify(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(ModifyCustomerController.class.getResource("/com/example/C195/view/MainScreen.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1000, 625);
        stage.setTitle("MainScreen");
        stage.setScene(scene);
        stage.show();
    }

    /** This function populates the Division box based off the country selected.
     *
     * @param actionEvent
     */
    public void OnSelectCountry(ActionEvent actionEvent) {
        if (CountryBox.getSelectionModel().getSelectedItem().getCountryid() == 1) {
            FLDBox.setItems(DBDivision.GetUS());

        } else if (CountryBox.getSelectionModel().getSelectedItem().getCountryid() == 2) {
            FLDBox.setItems(DBDivision.GetUK());
        } else if (CountryBox.getSelectionModel().getSelectedItem().getCountryid() == 3) {
            FLDBox.setItems(DBDivision.GetCanada());
        }
    }

    /** This function initializes the modify customer screen.
     *
     * @param url
     * @param resourceBundle
     */
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
