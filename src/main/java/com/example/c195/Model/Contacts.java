package com.example.c195.Model;

public class Contacts {
    private int contactid;

    private String contactname;

    private String email;

    public int getContactid() {
        return contactid;
    }

    public void setContactid(int contactid) {
        this.contactid = contactid;
    }

    public String getContactname() {
        return contactname;
    }

    public void setContactname(String contactname) {
        this.contactname = contactname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Contacts(int contactid, String contactname, String email) {
        this.contactid = contactid;
        this.contactname = contactname;
        this.email = email;
    }
}
