package com.example.c195.DBaccess;

import Helper.JDBC;
import com.example.c195.Model.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBCustomer {

    public static ObservableList<Customer> getAllCustomers(){

        ObservableList<Customer> Clist = FXCollections.observableArrayList();

        try {
            String sql = "SELECT a.*, b.Division FROM customers AS a JOIN first_level_divisions AS b ON a.Division_ID = b.Division_ID";

            PreparedStatement ps = JDBC.getConnection().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                int customerid = rs.getInt("Customer_ID");
                String customername = rs.getString("Customer_Name");
                String address = rs.getString("Address");
                String postalCode = rs.getString("Postal_Code");
                String phone = rs.getString("Phone");
                int divId = rs.getInt("Division_ID");
                String division = rs.getString("Division");
                Customer c = new Customer(customerid, customername, address, postalCode, phone, divId, division);
                Clist.add(c);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return Clist;
    }

    public static int addCustomer(int custid, String custname, String address, String postalcode, String phone, int divId) throws SQLException {
        String sql = "INSERT INTO customers (Customer_ID, Customer_Name, Address, Postal_Code, Phone, Division_ID) VALUES(?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ps.setInt(1, custid);
        ps.setString(2, custname);
        ps.setString(3, address);
        ps.setString(4, postalcode);
        ps.setString(5, phone);
        ps.setInt(6, divId);
        //ps.setString(7, division);
        int rowsaffected = ps.executeUpdate();
        return rowsaffected;

    }

    public static void modifyCustomer(int custid, String custname, String address, String postalcode, String phone, int divID) throws SQLException{
        String sql = "UPDATE customers SET Customer_Name = ?, Address = ?, Postal_Code = ?, Phone = ?, Division_ID = ? WHERE Customer_ID = ?";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ps.setString(1, custname);
        ps.setString(2, address);
        ps.setString(3, postalcode);
        ps.setString(4, phone);
        ps.setInt(5, divID);
        ps.setInt(6, custid);
        //ps.setString(7, division);
        ps.executeUpdate();

    }

    public static int deleteCustomer(int custid) throws SQLException{
        String sql = "DELETE FROM customers WHERE Customer_ID = ?";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ps.setInt(1, custid);
        int rowsaffected = ps.executeUpdate();
        return rowsaffected;
    }



}

