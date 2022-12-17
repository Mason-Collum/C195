package com.example.c195.Model;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Appointments {
    private int appointmentid;

    private String title;

    private String description;

    private String location;

    private String type;

    private LocalDateTime Start;

    private LocalDateTime end;

    private int customerid;

    private int userid;

    private int contactid;

    private String contact;

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getAppointmentid() {
        return appointmentid;
    }

    public void setAppointmentid(int appointmentid) {
        this.appointmentid = appointmentid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getStart() {
        return Start;
    }

    public void setStart(LocalDateTime start) {
        Start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getContactid() {
        return contactid;
    }

    public void setContactid(int contactid) {
        this.contactid = contactid;
    }

    public Appointments(int appointmentid, String title, String description, String location, String type, LocalDateTime start, LocalDateTime end, int customerid, int userid, int contactid, String contact) {
        this.appointmentid = appointmentid;
        this.title = title;
        this.description = description;
        this.location = location;
        this.type = type;
        Start = start;
        this.end = end;
        this.customerid = customerid;
        this.userid = userid;
        this.contactid = contactid;
        this.contact = contact;
    }
}
