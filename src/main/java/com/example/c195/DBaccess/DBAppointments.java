package com.example.c195.DBaccess;

import Helper.JDBC;
import com.example.c195.Model.Appointments;
import com.example.c195.Model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class DBAppointments {

    public static ObservableList<Appointments> getAllAppointments() {

        ObservableList<Appointments> Alist = FXCollections.observableArrayList();

        try {
            String sql = "SELECT a.*, b.Contact_Name FROM appointments AS a JOIN contacts AS b on a.Contact_ID = b.Contact_ID";

            PreparedStatement ps = JDBC.getConnection().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                int appointmentId = rs.getInt("Appointment_ID");
                String title = rs.getString("Title");
                String description = rs.getString("Description");
                String location = rs.getString("Location");
                String type = rs.getString("Type");
                LocalDateTime start = rs.getTimestamp("Start").toLocalDateTime();
                LocalDateTime end = rs.getTimestamp("End").toLocalDateTime();
                int customerid = rs.getInt("Customer_ID");
                int userid = rs.getInt("User_ID");
                int contactid = rs.getInt("Contact_ID");
                String contact = rs.getString("Contact_Name");



                Appointments a = new Appointments(appointmentId, title, description, location, type, start, end, customerid, userid, contactid, contact);
                Alist.add(a);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return Alist;

    }}
