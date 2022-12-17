package com.example.c195.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Customer {

    private int id;

    private String name;

    private String address;

    private String postalcode;

    private String phone;

    private int FLDid;

    private String Division;

    public String getDivision() {
        return Division;
    }

    public void setDivision(String division) {
        Division = division;
    }

    private static ObservableList<Customer> AllCustomers = FXCollections.observableArrayList();

    public static ObservableList<Customer> getAllCustomers() {
        return AllCustomers;
    }

    public static void setAllCustomers(ObservableList<Customer> allCustomers) {
        AllCustomers = allCustomers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getFLDid() {
        return FLDid;
    }

    public void setFLDid(int FLDid) {
        this.FLDid = FLDid;
    }

    public Customer(int id, String name, String address, String postalcode, String phone, int FLDid, String Division) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.postalcode = postalcode;
        this.phone = phone;
        this.FLDid = FLDid;
        this.Division = Division;

    }
    public  int newCustomerid(){
        return id++;
    }
}


