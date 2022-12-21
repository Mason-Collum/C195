package com.example.c195;

import Helper.JDBC;
import com.example.c195.DBaccess.DBAppointments;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Locale;
import java.util.ResourceBundle;

/** This is the main class of this program.*/
public class Main extends Application {

    /** This function chooses the scene to open when the program is started.
     *
     * @param stage
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/com/example/C195/view/Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    /** This function connects program to the database, and then launches the program.
     * It also closes the connection when the program is closed.
     * @param args
     */
    public static void main(String[] args) throws SQLException {
       // Locale.setDefault(new Locale("fr"));
        JDBC.openConnection();
        launch();
        JDBC.closeConnection();


    }
}