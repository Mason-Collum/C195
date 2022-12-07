package com.example.c195.Model;

public class Customer {

    private int id = 1;

    private String name;

    private String address;

    private String fld;

    private String country;

    private int postalcode;

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

    public String getFld() {
        return fld;
    }

    public void setFld(String fld) {
        this.fld = fld;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(int postalcode) {
        this.postalcode = postalcode;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    private int phone;


    public Customer(int id, String name, String address, String fld, String country, int postalcode, int phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.fld = fld;
        this.country = country;
        this.postalcode = postalcode;
        this.phone = phone;
    }
}
