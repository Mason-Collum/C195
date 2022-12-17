package com.example.c195.DBaccess;

import Helper.JDBC;
import com.example.c195.Model.Country;
import com.example.c195.Model.Division;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBDivision {
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


    public static ObservableList<Division> GetSortedDivision(Country country) {

        ObservableList<Division> fdlist = FXCollections.observableArrayList();
        for (Division list : getAllDivisions()) {
            if (list.getCountryid() == country.getCountryid()) {
                fdlist.add(list);
            }
            return fdlist;
        }
       /* Country co = DBCountry.GetCountryID(country);
        ObservableList<Division> dlist = FXCollections.observableArrayList();

        String sql = "SELECT * FROM first_level_divisions WHERE Country_ID = ?";
        try {


            PreparedStatement ps = JDBC.getConnection().prepareStatement(sql);
            ps.setInt(1, co.getCountryid());

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int divisionid = rs.getInt("Division_ID");
                String divisionname = rs.getString("Division");
                int countryid = rs.getInt("Country_ID");
                Division d = new Division(divisionid, divisionname, countryid);
                dlist.add(d);
                return dlist;
            }
        }
        catch (SQLException throwables){
            throwables.printStackTrace();
        }

        return dlist;
    }*/
        return fdlist;
    }

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


