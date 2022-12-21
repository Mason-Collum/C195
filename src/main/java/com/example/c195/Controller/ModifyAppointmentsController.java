package com.example.c195.Controller;

import com.example.c195.DBaccess.DBAppointments;
import com.example.c195.DBaccess.DBContact;
import com.example.c195.Main;
import com.example.c195.Model.Appointments;
import com.example.c195.Model.Contacts;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.*;
import java.util.List;
import java.util.ResourceBundle;

public class ModifyAppointmentsController implements Initializable {

    /** This object represents the appointment chosen for modification.*/
    private static Appointments chosen = null;

    /** This field generates the appointment id.*/
    public TextField ModifyAppID;

    /** This text field is where the appointment title can be modified.*/
    public TextField ModifyTitle;

    /** This text field is where the appointment description can be modified.*/
    public TextField ModifyDes;

    /** This text field is where the appointment location can be modified.*/
    public TextField ModifyLocation;

    /** This text field is where the appointment type can be modified.*/
    public TextField ModifyType;

    /** This text field is where the appointment start date can be modified.*/
    public TextField ModifyStart;

    /** This text field is where the appointment end date can be modified.*/
    public TextField ModifyEnd;

    /** This text field is where the customer associated with the chosen appointment can be changed.*/
    public TextField ModifyCustID;

    /** This text field is where the user associated with the chosen appointment can be changed.*/
    public TextField ModifyUserID;

    /** This combo box is where the contact can be chosen.*/
    public ComboBox <Contacts>ContactBox;

    /** This text field is where the appointment start tim can be modified.*/
    public TextField Starttime;

    /** This text field is where the appointment end time can be modified.*/
    public TextField Endtime;

    /** This function is where the chosen appointment's information is passed to this scene.
     *
     * @param appointments
     */
    public static void passAppointmentdata(Appointments appointments){
        chosen = appointments;
    }

    /** This function is where the modifications to the appointment are changed.
     *
     * @param actionEvent
     */
    public void OnSave(ActionEvent actionEvent) throws IOException {
        try {

            String appointmentid = ModifyAppID.getText();
            String title = ModifyTitle.getText();
            String description = ModifyDes.getText();
            String location = ModifyLocation.getText();
            String type = ModifyType.getText();
            String customerid = ModifyCustID.getText();
            String userid = ModifyUserID.getText();
            String contact = ContactBox.getSelectionModel().getSelectedItem().toString();
            int contactid = ContactBox.getValue().getContactid();

            int appid = Integer.parseInt(appointmentid);
            int custid = Integer.parseInt(customerid);
            int uid = Integer.parseInt(userid);

            LocalDate startdate = LocalDate.parse(ModifyStart.getText());
            LocalDate enddate = LocalDate.parse(ModifyEnd.getText());
            LocalTime starttime = LocalTime.parse(Starttime.getText());
            LocalTime endtime = LocalTime.parse(Endtime.getText());
            LocalDateTime start = LocalDateTime.of(startdate, starttime);
            LocalDateTime end = LocalDateTime.of(enddate, endtime);

            ZonedDateTime opening = ZonedDateTime.of(startdate, LocalTime.of(8, 00, 00), ZoneId.of("America/New_York"));
            ZonedDateTime closing = ZonedDateTime.of(enddate, LocalTime.of(22, 00, 00), ZoneId.of("America/New_York"));
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



            if((convertedstart.isAfter(convertedopen) || convertedstart.isEqual(convertedopen) )&& (convertedend.isBefore(convertedclose) || convertedend.isEqual(convertedclose))) {
                DBAppointments.modifyAppointment(appid, ModifyTitle.getText(), ModifyDes.getText(), ModifyLocation.getText(), ModifyType.getText(), convertedstart, convertedend, Integer.parseInt(ModifyCustID.getText()), Integer.parseInt(ModifyUserID.getText()), ContactBox.getValue().getContactid());

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
            else if(ContactBox.getSelectionModel().getSelectedItem().toString() == null){
                Alert popup = new Alert(Alert.AlertType.ERROR, "Invalid Entry, must fill out all fields");
                popup.showAndWait();
                return;
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /** This function cancels the changes made to the appointment.
     *
     * @param actionEvent
     * @throws IOException
     */
    public void OnCancel(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(ModifyAppointmentsController.class.getResource("/com/example/C195/view/Appointments.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1000, 625);
        stage.setTitle("Appointments");
        stage.setScene(scene);
        stage.show();
    }

    /** This function intializes the page and assigns the corresponding information to their text fields or combo boxes.
     *
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ModifyAppID.setText(String.valueOf(chosen.getAppointmentid()));
        ContactBox.setItems(DBContact.getAllContacts());
        ModifyTitle.setText(String.valueOf(chosen.getTitle()));
        ModifyDes.setText(String.valueOf(chosen.getDescription()));
        ModifyLocation.setText(String.valueOf(chosen.getLocation()));
        ModifyType.setText(String.valueOf(chosen.getType()));
        ModifyStart.setText(String.valueOf(LocalDate.from(chosen.getStart())));
        Starttime.setText(String.valueOf(LocalTime.from(chosen.getStart())));
        ModifyEnd.setText(String.valueOf(LocalDate.from(chosen.getEnd())));
        Endtime.setText(String.valueOf(LocalTime.from(chosen.getEnd())));
        ModifyCustID.setText(String.valueOf(chosen.getCustomerid()));
        ModifyUserID.setText(String.valueOf(chosen.getUserid()));
    }
}
