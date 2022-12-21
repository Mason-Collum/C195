package com.example.c195.Controller;

import com.example.c195.DBaccess.DBAppointments;
import com.example.c195.Model.Appointments;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.Month;
import java.util.Enumeration;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class CustomerAppointmentsReportController implements Initializable {
    public Label totalNumber;
    public TextArea textArea;
    public ComboBox <Appointments> TypeBox;
    public ComboBox MonthBox;

    ObservableList<Appointments> Typelist = FXCollections.observableArrayList();

    ObservableList<Enum> MonthList = FXCollections.observableArrayList();




    public void onTypeSelect(ActionEvent actionEvent) {





    }

    public void onMonthSelect(ActionEvent actionEvent){




    }

    /** This function intializes and populates the Type box combo box.
     *
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TypeBox.setItems(DBAppointments.getAllAppointments());

        enum Month {
            January,
            February,
            March,
            April,
            May,
            June,
            July,
            August,
            September,
            October,
            November,
            December

        }

        MonthBox.getItems().setAll(Month.values());


    }

    /** This function redirects the user back to the main screen.
     *
     * @param actionEvent
     * @throws IOException
     */
    public void onButtonPress(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("/com/example/C195/view/MainScreen.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 715, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public void onGetTotal(ActionEvent actionEvent) {
        if(MonthBox.getSelectionModel().getSelectedItem() != null && TypeBox.getSelectionModel().getSelectedItem().getType() != null){
            int total = (DBAppointments.sortByMonth(TypeBox.getSelectionModel().getSelectedItem().getType(), MonthBox.getSelectionModel().getSelectedItem().toString()));
            String tostring = Integer.toString(total);
            textArea.setText(tostring);
        }
        else{
            Alert popup = new Alert(Alert.AlertType.ERROR, "Please select an option from both fields");
            popup.showAndWait();
        }
    }
}
