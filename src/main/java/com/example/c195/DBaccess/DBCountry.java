package com.example.c195.DBaccess;

import Helper.JDBC;
import com.example.c195.Model.Country;
import com.example.c195.Model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/** This class handles all of the interactions between the country table in the database, and the program.*/
public class DBCountry {

    /** This funtion grabs all of the countries from the database and puts them in an observable list.
     *
     * @return
     */
    public static ObservableList<Country> getAllCountry(){

        ObservableList<Country> Colist = FXCollections.observableArrayList();

        try {
            String sql = "SELECT * FROM countries";

            PreparedStatement ps = JDBC.getConnection().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                int countryId = rs.getInt("Country_ID");
                String countryname = rs.getString("Country");
                Country co = new Country(countryId, countryname);
                Colist.add(co);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return Colist;
    }


}
