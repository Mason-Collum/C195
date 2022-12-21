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

    /** This text field is where the customer id is generated.*/
    public TextField CustID;

    /** This text field is where the customer name is entered.*/
    public TextField CustName;

    /** This text field is where the customer address is entered.*/
    public TextField CustAddress;

    /** This text field is where the customer postal code is entered.*/
    public TextField CustPostalCode;

    /** This text field is where the customer phone number is entered.*/
    public TextField CustPhone;

    /** This combo box is where the customer country is chosen.*/
    public ComboBox<Country> CountryBox;

    /** This combo box is where the customer division is chosen.
     * It's options change based on the country chosen.
     */
    public ComboBox<Division> FLDBox;


    /** This function saves the customer information.
     * This information is then transferred to the customer info table and the scene is changed back to the main screen.
     * @param actionEvent
     * @throws IOException
     */
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

    /** This function cancels any information entered into the fields.
     * It then redirects to the main page.
     * @param actionEvent
     * @throws IOException
     */
    public void OnCancel (ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(AddCustomerController.class.getResource("/com/example/C195/view/MainScreen.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1000, 625);
        stage.setTitle("MainScreen");
        stage.setScene(scene);
        stage.show();
    }

    /** This function initializes the add customer page.
     * It sets both combo boxes.
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        CountryBox.setItems(DBCountry.getAllCountry());



        FLDBox.setItems(DBDivision.getAllDivisions());

    }



    /** This function changes the option in the division combo box base on the country selected.
     *
     * @param actionEvent
     */
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


    public void OnFLDSelect(ActionEvent actionEvent) {
    }
}
