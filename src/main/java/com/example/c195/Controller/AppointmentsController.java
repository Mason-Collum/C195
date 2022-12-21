package com.example.c195.Controller;

import com.example.c195.DBaccess.DBAppointments;
import com.example.c195.Model.Appointments;
import javafx.collections.FXCollections;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class AppointmentsController implements Initializable {

    /** This object represents the appointment chosen for modification.*/
    private static Appointments modifyappointment;

    /** This toggle group sorts the Table view based on the month or the week.*/
    public ToggleGroup Appointment;

    /** This table view hold all of the appointment information.*/
    public TableView AppointmentTable;

    /** This column hold the appointment ID.*/
    public TableColumn AppointmentID;

    /** This column hold the appointment title.*/
    public TableColumn Titlecolumn;

    /** This column hold the appointment description.*/
    public TableColumn DescriptionColumn;

    /** This column hold the appointment location.*/
    public TableColumn Locationcolumn;

    /** This column hold the appointment contact.*/
    public TableColumn Contactcolumn;

    /** This column hold the appointment type.*/
    public TableColumn TypeColumn;

    /** This column hold the appointment Start time and date.*/
    public TableColumn Startcolumn;

    /** This column hold the appointment end time and date.*/
    public TableColumn Endcolumn;

    /** This column hold the appointment's corresponding customer.*/
    public TableColumn CustomerColumn;

    /** This column hold the appointment's corresponding user.*/
    public TableColumn Usercolumn;

    /** This function redirects the user to the customer screen.
     *
     * @param actionEvent
     * @throws IOException
     */
    public void OnToCustomers(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(AppointmentsController.class.getResource("/com/example/C195/view/MainScreen.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1000, 625);
        stage.setTitle("MainScreen");
        stage.setScene(scene);
        stage.show();
    }

    /** This function reidrects the user to the add appointment screen.
     *
     * @param actionEvent
     * @throws IOException
     */
    public void OnAddAppointment(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(AppointmentsController.class.getResource("/com/example/C195/view/AddAppointment.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1000, 625);
        stage.setTitle("Add Appointment");
        stage.setScene(scene);
        stage.show();
    }

    /** This function reidrects the user to the modify appointment screen.
     * It also transfers the information from the selected appointment to the new screen.
     * It throws an error if no appointment is chosen.
     * @param actionEvent
     * @throws IOException
     */
    public void OnModifyAppointment(ActionEvent actionEvent) throws IOException {
        modifyappointment = (Appointments) AppointmentTable.getSelectionModel().getSelectedItem();
        ModifyAppointmentsController.passAppointmentdata(modifyappointment);

        if(modifyappointment == null){
            Alert popup = new Alert(Alert.AlertType.ERROR, "Must Select an Appointment.");
            popup.showAndWait();
            return;
        } else if (modifyappointment != null) {

            Parent root = FXMLLoader.load(AppointmentsController.class.getResource("/com/example/C195/view/Modify Appointments.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 1000, 625);
            stage.setTitle("Modify Appointment");
            stage.setScene(scene);
            stage.show();
        }
    }

    /** This funtion intializes the appointment screen.
     *
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        AppointmentTable.setItems(DBAppointments.getAllAppointments());


        AppointmentID.setCellValueFactory(new PropertyValueFactory<>("appointmentid"));
        Titlecolumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        DescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        Locationcolumn.setCellValueFactory(new PropertyValueFactory<>("location"));
        Contactcolumn.setCellValueFactory(new PropertyValueFactory<>("contact"));
        TypeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        Startcolumn.setCellValueFactory(new PropertyValueFactory<>("Start"));
        Endcolumn.setCellValueFactory(new PropertyValueFactory<>("End"));
        CustomerColumn.setCellValueFactory(new PropertyValueFactory<>("customerid"));
        Usercolumn.setCellValueFactory(new PropertyValueFactory<>("userid"));

        
    }

    /** This function deletes an appointment that is chosen.
     *
     * @param actionEvent
     * @throws SQLException
     * @throws IOException
     */
    public void onDelete(ActionEvent actionEvent) throws SQLException, IOException {
        Alert popup = new Alert(Alert.AlertType.CONFIRMATION, "Do you wish to delete?");
        Optional<ButtonType> confirm = popup.showAndWait();

        Appointments chosen = (Appointments) AppointmentTable.getSelectionModel().getSelectedItem();

        if(confirm.isPresent() && confirm.get() == ButtonType.OK){
            DBAppointments.deleteAppointment(chosen.getAppointmentid());
            Parent root = FXMLLoader.load(AddAppointmentController.class.getResource("/com/example/C195/view/Appointments.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 1000, 625);
            stage.setTitle("Appointments");
            stage.setScene(scene);
            stage.show();
        }
    }

    /** This method displays all appointments within the next month only.
     *
     * @param actionEvent
     */
    public void onMonthSelected(ActionEvent actionEvent) {
        DBAppointments.getAllAppointments().clear();

       AppointmentTable.setItems(DBAppointments.getAllAppointments().stream().filter((Appointments)->
                Appointments.getStart().isAfter(LocalDateTime.of(LocalDate.now(), LocalTime.of(0,00).plusHours(730))))
                .collect(Collectors.toCollection(FXCollections::observableArrayList)));

        AppointmentID.setCellValueFactory(new PropertyValueFactory<>("appointmentid"));
        Titlecolumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        DescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        Locationcolumn.setCellValueFactory(new PropertyValueFactory<>("location"));
        Contactcolumn.setCellValueFactory(new PropertyValueFactory<>("contact"));
        TypeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        Startcolumn.setCellValueFactory(new PropertyValueFactory<>("Start"));
        Endcolumn.setCellValueFactory(new PropertyValueFactory<>("End"));
        CustomerColumn.setCellValueFactory(new PropertyValueFactory<>("customerid"));
        Usercolumn.setCellValueFactory(new PropertyValueFactory<>("userid"));
    }


    /** This funtion corresponds to the Week Radio button.
     * When this button is pressed, it organizes the Table to display only appointments within the week.
     * @param actionEvent
     */
    public void onWeekSelected(ActionEvent actionEvent) {

        DBAppointments.getAllAppointments().clear();

        AppointmentTable.setItems(DBAppointments.getAllAppointments().stream().filter((Appointments)->
                Appointments.getStart().isAfter(LocalDateTime.of(LocalDate.now(), LocalTime.of(0,00).plusHours(168))))
                .collect(Collectors.toCollection(FXCollections::observableArrayList)));

        AppointmentID.setCellValueFactory(new PropertyValueFactory<>("appointmentid"));
        Titlecolumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        DescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        Locationcolumn.setCellValueFactory(new PropertyValueFactory<>("location"));
        Contactcolumn.setCellValueFactory(new PropertyValueFactory<>("contact"));
        TypeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        Startcolumn.setCellValueFactory(new PropertyValueFactory<>("Start"));
        Endcolumn.setCellValueFactory(new PropertyValueFactory<>("End"));
        CustomerColumn.setCellValueFactory(new PropertyValueFactory<>("customerid"));
        Usercolumn.setCellValueFactory(new PropertyValueFactory<>("userid"));
    }
}
