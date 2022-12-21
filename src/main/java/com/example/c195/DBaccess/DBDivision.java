package com.example.c195.DBaccess;

import Helper.JDBC;
import com.example.c195.Model.Country;
import com.example.c195.Model.Division;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/** This class handles all of the interaction between the first_level_divisions table in the database and the program.*/
public class DBDivision {

    /** This function grabs all of the divisions and puts them into an observable list.
     *
     * @return
     */
    public static ObservableList<Division> getAllDivisions() {

        ObservableList<Division> Dlist = FXCollections.observableArrayList();

        try {
            String sql = "SELECT * FROM first_level_divisions";

            PreparedStatement ps = JDBC.getConnection().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int divisionid = rs.getInt("Division_ID");
                String division = rs.getString("Division");
                int countryid = rs.getInt("Country_ID");
                Division d = new Division(divisionid, division, countryid);
                Dlist.add(d);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return Dlist;
    }

    /** This function grabs divisions that share the same country id as the US in the countries table.
     *
     * @return
     */
    public static ObservableList<Division> GetUS() {
        ObservableList<Division> uslist = FXCollections.observableArrayList();
        try {
            String sql = "SELECT * FROM first_level_divisions WHERE Country_ID = 1";
            PreparedStatement ps = JDBC.getConnection().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int divisionid = rs.getInt("Division_ID");
                String division = rs.getString("Division");
                int countryid = rs.getInt("Country_ID");
                Division d = new Division(divisionid, division, countryid);
                uslist.add(d);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return uslist;
    }

    /** This function grabs divisions that share the same country id as the UK in the countries table.
     *
     * @return
     */
    public static ObservableList <Division> GetUK() {
        ObservableList<Division> UKlist = FXCollections.observableArrayList();

        try {
            String sql = "SELECT * FROM first_level_divisions WHERE Country_ID = 2";
            PreparedStatement ps = JDBC.getConnection().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int divisionid = rs.getInt("Division_ID");
                String division = rs.getString("Division");
                int countryid = rs.getInt("Country_ID");
                Division d = new Division(divisionid, division, countryid);
                UKlist.add(d);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return UKlist;
    }

    /** This function grabs divisions that share the same country id as Canada in the countries table.
     *
     * @return
     */
    public static ObservableList<Division> GetCanada () {
        ObservableList<Division> canlist = FXCollections.observableArrayList();
        try {
            String sql = "SELECT * FROM first_level_divisions WHERE Country_ID = 3";
            PreparedStatement ps = JDBC.getConnection().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int divisionid = rs.getInt("Division_ID");
                String division = rs.getString("Division");
                int countryid = rs.getInt("Country_ID");
                Division d = new Division(divisionid, division, countryid);
                canlist.add(d);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return canlist;
    }
    }


