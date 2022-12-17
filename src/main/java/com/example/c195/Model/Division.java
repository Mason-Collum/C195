package com.example.c195.Model;

public class Division {
    private final int fldid;
    private final String FLD;
    private final int countryid;

    public Division(int fldid, String FLD, int countryid) {
        this.fldid = fldid;
        this.FLD = FLD;
        this.countryid = countryid;
    }

    public int getFldid() {
        return fldid;
    }



    public  String getFLD() {
        return FLD;
    }



    public Integer getCountryid() {
        return countryid;
    }



    public String toString() {
        return (" DivisionID: " + Integer.toString(fldid) +" Division: " + FLD + " CountryID: " + Integer.toString(countryid));
    }
}
