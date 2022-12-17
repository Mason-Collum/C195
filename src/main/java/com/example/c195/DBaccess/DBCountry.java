package com.example.c195.DBaccess;

import Helper.JDBC;
import com.example.c195.Model.Country;
import com.example.c195.Model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBCountry {

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

    public static Country GetCountryID(String countryname) throws SQLException {
        String sql = "SELECT * FROM countries WHERE Country = ?";
        try {


            PreparedStatement ps = JDBC.getConnection().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int countryid = rs.getInt("Country_ID");
                String country = rs.getString("Country");
                Country co = new Country(countryid, country);

                return co;
            }
        }
        catch (SQLException throwables){
            throwables.printStackTrace();
        }

        return null;
    }

    public static ObservableList<String> getCountryName(){
        ObservableList<String> CoNamelist = FXCollections.observableArrayList();
        try {
            String sql = "SELECT Country FROM countries";
            PreparedStatement ps = JDBC.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String countryname = rs.getString("Country");
                CoNamelist.add(countryname);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return CoNamelist;
    }
}
