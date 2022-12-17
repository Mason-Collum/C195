package com.example.c195.Model;

public class Country {
    private int countryid;

    private String countryname;

    public int getCountryid() {
        return countryid;
    }

    public void setCountryid(int countryid) {
        this.countryid = countryid;
    }

    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public Country(int countryid, String countryname) {
        this.countryid = countryid;
        this.countryname = countryname;
    }

    public String toString(){
        return ("#" + Integer.toString(countryid)+ " " +countryname+ "");
    }
}
