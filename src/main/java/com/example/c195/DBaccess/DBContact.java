package com.example.c195.DBaccess;

import Helper.JDBC;
import com.example.c195.Model.Contacts;
import com.example.c195.Model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/** This class handles all of the interactions between the contacts table in the database, and the program.*/
public class DBContact {

    /** This function grabs all of the contacts from the SQL database.
     *
     * @return
     */
    public static ObservableList<Contacts> getAllContacts(){

        ObservableList<Contacts> Conlist = FXCollections.observableArrayList();

        try {
            String sql = "SELECT * FROM contacts";

            PreparedStatement ps = JDBC.getConnection().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                int contactId = rs.getInt("Contact_ID");
                String contactname = rs.getString("Contact_Name");
                String email = rs.getString("Email");
                Contacts con = new Contacts(contactId, contactname, email);
                Conlist.add(con);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return Conlist;
    }
}
