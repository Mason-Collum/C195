package com.example.c195.Controller;

import com.example.c195.DBaccess.DBAppointments;
import com.example.c195.DBaccess.DBuser;
import com.example.c195.Model.Appointments;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.stream.Collectors;

public class LoginController implements Initializable {

    /** This text field is where the user enters their username.*/
    public TextField usernamefield;

    /** This text field is where the user enters their password.*/
    public TextField passwordfield;

    /** This label states the title of the page. It changes based on the users language settings.*/
    public Label PageLabel;

    /** This label states where to enter the username. It changes based on the users language settings.*/
    public Label UsernameLabel;

    /** This label states where to enter the password. It changes based on the users language settings.*/
    public Label PasswordLabel;

    /** This button submits the username and password to be checked.*/
    public Button SubmitButton;

    /** This label shows the users current Zone ID.*/
    public Label userzoneid;

    /** This function submits the username and password, and checks if they are correct.
     * If they are correct, it redirects the user to the main screen, otherwise, it throws an error.
     * @param actionEvent
     * @throws IOException
     */
    @FXML
    public void OnSubmit(ActionEvent actionEvent) throws IOException {
        String username = usernamefield.getText();
        String password = passwordfield.getText();


        if (DBuser.verifyLogin(username, password)) {

            Logger log = Logger.getLogger("Log.txt");
            log.info("User Log in attempt successful.");
            try {
                FileHandler handler = new FileHandler("Log.txt", true);
                SimpleFormatter formatter = new SimpleFormatter();
                handler.setFormatter(formatter);
                log.addHandler(handler);


            }
            catch(IOException ex){
                Logger.getLogger(LoginController.class.getName()).log(Level.INFO, null, ex);
            }


            ArrayList<Appointments> checklist = DBAppointments.getAllAppointments().stream().filter(
                    (Appointments) -> (Appointments.getStart().isBefore(LocalDateTime.now().plusMinutes(15))
                            && Appointments.getStart().isAfter(LocalDateTime.now()))).collect(Collectors.toCollection(ArrayList::new));

            if(checklist.isEmpty()){
                Alert popup = new Alert(Alert.AlertType.INFORMATION, "No upcoming appointments");
                popup.showAndWait();
            }
            else{
                for(Appointments appointments : checklist) {


                    Alert popup = new Alert(Alert.AlertType.INFORMATION, "Appointment starts soon. Appointment ID:" + appointments.getAppointmentid()+ "Start: " +appointments.getStart().toLocalTime()+ "");
                    popup.showAndWait();
                }
            }




            FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("/com/example/C195/view/MainScreen.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(fxmlLoader.load(), 715, 400);
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();


        }
        else {
            try {
                Logger log = Logger.getLogger("Log.txt");
                log.warning("Unknown user! Unsuccessful Log in attempt");

                FileHandler handler = new FileHandler("Log.txt", true);
                SimpleFormatter formatter = new SimpleFormatter();
                handler.setFormatter(formatter);
                log.addHandler(handler);
            }

            catch (SecurityException exception){
                Logger.getLogger(LoginController.class.getName()).log(Level.WARNING, null, exception);
            }
        }



    }

    /** This function initializes the login screen.
     * It detects the users zone id and language settings.
     * It changes the login page based on the language settings.
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        userzoneid.setText(ZoneId.systemDefault().toString());
        
        resourceBundle = ResourceBundle.getBundle("com/example/c195/Nat_"+ Locale.getDefault());

        

        usernamefield.setPromptText(resourceBundle.getString("Usernameprompt"));
        passwordfield.setPromptText(resourceBundle.getString("Passwordprompt"));
        PageLabel.setText(resourceBundle.getString("Login"));
        UsernameLabel.setText(resourceBundle.getString("Username"));
        PasswordLabel.setText(resourceBundle.getString("Password"));
        SubmitButton.setText(resourceBundle.getString("Submit"));



    }
}