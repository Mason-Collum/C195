package com.example.c195.DBaccess;

import Helper.JDBC;
import com.example.c195.Model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

public class DBuser {

    public static ObservableList<User> getAllUsers(){

        ObservableList<User> Ulist = FXCollections.observableArrayList();

        try {
            String sql = "SELECT * FROM users";

            PreparedStatement ps = JDBC.getConnection().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                int userId = rs.getInt("User_ID");
                String username = rs.getString("User_Name");
                String password = rs.getString("Password");
                User u = new User(userId, username, password);
                Ulist.add(u);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return Ulist;
    }

    public static Boolean verifyLogin(String username, String password){
        String sql = "SELECT * FROM users WHERE User_Name = '" + username + "' AND Password = '" + password + "'";
        try{
            PreparedStatement ps = JDBC.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();
            if (rs.getString("User_Name").equals(username) && rs.getString("Password").equals(password)){
                return true;
            }

        } catch (SQLException e) {
            ResourceBundle resourceBundle = ResourceBundle.getBundle("com/example/c195/Nat_"+ Locale.getDefault());
            Alert popup = new Alert(Alert.AlertType.ERROR, "Invalid Username and/or Password");
            popup.setContentText(resourceBundle.getString("Errorcontent"));
            popup.setHeaderText(resourceBundle.getString("ErrorTitle"));
            popup.showAndWait();

        }
        return false;

    }


}
