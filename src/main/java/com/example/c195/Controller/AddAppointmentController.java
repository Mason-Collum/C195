package com.example.c195.Controller;

import com.example.c195.DBaccess.DBAppointments;
import com.example.c195.DBaccess.DBContact;
import com.example.c195.Model.Appointments;
import com.example.c195.Model.Contacts;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.ResourceBundle;

/** This class allows the user to add an appointment.
 */
public class AddAppointmentController implements Initializable {
    /** This text field is where the appointment ID is entered.*/
    public TextField AddAppID;

    /** This text field is where the appointment title is entered.*/
    public TextField AddTitle;

    /** This text field is where the appointment description is entered.*/
    public TextField AddDes;

    /** This text field is where the appointment location is entered.*/
    public TextField AddLocation;

    /** This text field is where the appointment start time is entered.*/
    public TextField AddStart;

    /** This text field is where the appointment end time is entered.*/
    public TextField AddEnd;

    /** This text field is where the customer ID is entered.*/
    public TextField AddCustID;

    /** This text field is where the user ID is entered.*/
    public TextField AddUserID;

    /** This combo box houses all of the options for contacts.*/
    public ComboBox <Contacts> ContactBox;

    /** This text field is where the appointment type is entered.*/
    public TextField Addtype;

    /** This text field is where the appointment start date is entered.*/
    public TextField startdate;

    /** This text field is where the appointment end date is entered.*/
    public TextField enddate;

    /** This function saves the new appointment created in this file.
     * It then switches the scene back to the appointments screen.
     *
     * @param actionEvent
     */

    public void OnSave(ActionEvent actionEvent) {
        try{
            int appointmentid = 0;
            String title = AddTitle.getText();
            String description = AddDes.getText();
            String location = AddLocation.getText();
            String type = Addtype.getText();
            String contact = ContactBox.getSelectionModel().getSelectedItem().toString();
            int contactid = ContactBox.getValue().getContactid();
            String customerid = AddCustID.getText();
            String userid = AddUserID.getText();

            int custid = Integer.parseInt(customerid);
            int uid = Integer.parseInt(userid);


            LocalDate stardate = LocalDate.parse(startdate.getText());
            LocalDate endate = LocalDate.parse(enddate.getText());
            LocalTime timestart = LocalTime.parse(AddStart.getText());
            LocalTime timeend = LocalTime.parse(AddEnd.getText());
            LocalDateTime start = LocalDateTime.of(stardate, timestart);
            LocalDateTime end = LocalDateTime.of(endate, timeend);


            ZonedDateTime opening = ZonedDateTime.of(stardate, LocalTime.of(8, 00, 00), ZoneId.of("America/New_York"));
            ZonedDateTime closing = ZonedDateTime.of(endate, LocalTime.of(22, 00, 00), ZoneId.of("America/New_York"));
            ZonedDateTime utcopen = opening.withZoneSameInstant(ZoneId.of("UTC"));
            ZonedDateTime utcclose = closing.withZoneSameInstant(ZoneId.of("UTC"));
            LocalDateTime convertedopen = utcopen.toLocalDateTime();
            LocalDateTime convertedclose = utcclose.toLocalDateTime();


            ZoneId myzoneid = ZoneId.systemDefault();
            ZonedDateTime startmyzone = ZonedDateTime.of(start, myzoneid);
            ZonedDateTime endmyzone = ZonedDateTime.of(end, myzoneid);
            ZonedDateTime utcstart = startmyzone.withZoneSameInstant(ZoneId.of("UTC"));
            ZonedDateTime utcend = endmyzone.withZoneSameInstant(ZoneId.of("UTC"));
            LocalDateTime convertedstart = utcstart.toLocalDateTime();
            LocalDateTime convertedend = utcend.toLocalDateTime();


            ObservableList<Appointments> overlapcheck = DBAppointments.sortByCustID(custid);
            for (Appointments a : overlapcheck) {
                if(convertedstart.isBefore(a.getStart()) && convertedend.isAfter(a.getStart())){
                    Alert popup = new Alert(Alert.AlertType.ERROR, "Invalid Entry, Customer already has appointment during time slot.");
                    popup.showAndWait();
                    return;
                }
                else if(convertedstart.isBefore(a.getStart()) && convertedend.isBefore(a.getEnd())){
                    Alert popup = new Alert(Alert.AlertType.ERROR, "Invalid Entry, Customer already has appointment during time slot.");
                    popup.showAndWait();
                    return;
                }
                else if(convertedstart.isAfter(a.getStart()) && convertedend.isBefore(a.getEnd())){
                    Alert popup = new Alert(Alert.AlertType.ERROR, "Invalid Entry, Customer already has appointment during time slot.");
                    popup.showAndWait();
                    return;
                }
                else if(convertedstart.isEqual(a.getStart()) && convertedend.isEqual(a.getEnd())){
                    Alert popup = new Alert(Alert.AlertType.ERROR, "Invalid Entry, Customer already has appointment during time slot.");
                    popup.showAndWait();
                    return;
                }
            }


            if(convertedstart.isAfter(convertedopen) && convertedend.isBefore(convertedclose)) {
                DBAppointments.addAppointment(appointmentid, title, description, location, type, convertedstart, convertedend, custid, uid, contactid);

                Parent root = FXMLLoader.load(AddAppointmentController.class.getResource("/com/example/C195/view/Appointments.fxml"));
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                Scene scene = new Scene(root, 1000, 625);
                stage.setTitle("Appointments");
                stage.setScene(scene);
                stage.show();
            }
            else if (convertedstart.isBefore(convertedopen) || convertedend.isAfter(convertedclose)) {
                Alert popup = new Alert(Alert.AlertType.ERROR, "Invalid Entry, times must be during business hours");
                popup.showAndWait();
                return;

            }
            else if(title == null){
                Alert popup = new Alert(Alert.AlertType.ERROR, "Invalid Entry, must fill out all fields");
                popup.showAndWait();
                return;
            }
            else if(description == null){
                Alert popup = new Alert(Alert.AlertType.ERROR, "Invalid Entry, must fill out all fields");
                popup.showAndWait();
                return;
            }
            else if(location == null){
                Alert popup = new Alert(Alert.AlertType.ERROR, "Invalid Entry, must fill out all fields");
                popup.showAndWait();
                return;
            }
            else if(contact == null){
                Alert popup = new Alert(Alert.AlertType.ERROR, "Invalid Entry, must fill out all fields");
                popup.showAndWait();
                return;
            }
            else if(customerid == null){
                Alert popup = new Alert(Alert.AlertType.ERROR, "Invalid Entry, must fill out all fields");
                popup.showAndWait();
                return;
            }
            else if(userid == null){
                Alert popup = new Alert(Alert.AlertType.ERROR, "Invalid Entry, must fill out all fields");
                popup.showAndWait();
                return;
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @param actionEvent
     * @throws IOException
     */
    public void OnCancel(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(AddAppointmentController.class.getResource("/com/example/C195/view/Appointments.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1000, 625);
        stage.setTitle("Appointments");
        stage.setScene(scene);
        stage.show();
    }

    /** This function initializes the add appointment screen.
     *
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ContactBox.setItems(DBContact.getAllContacts());

    }
}
