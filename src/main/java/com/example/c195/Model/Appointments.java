package com.example.c195.Model;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/** This is the Appointments class, which was created for this project.
 */
public class Appointments {

    /** This integer represents the Appointment_ID column in the SQL database.*/
    private int appointmentid;

    /** This string represents the Title column in the SQL database.*/
    private String title;

    /** This string represents the Description column in the SQL database.*/
    private String description;

    /** This string represents the Location column in the SQL database.*/
    private String location;

    /** This string represents the type column in the SQL database.*/
    private String type;

    /** This localdatetime represents the Start date/time column in the SQL database.*/
    private LocalDateTime Start;

    /** This localdatetime represents the End date/time column in the SQL database.*/
    private LocalDateTime end;

    /** This integer represents the Customer_ID column in the SQL database.*/
    private int customerid;

    /** This integer represents the User_ID column in the SQL database.*/
    private int userid;

    /** This integer represents the Contact_ID column in the SQL database.*/
    private int contactid;

    /** This string represents the contact name, which is a column in another table, linked throught he contactid.*/
    private String contact;

    /** This is the getter for the contact name.
     *
     * @return
     */
    public String getContact() {
        return contact;
    }

    /** This is the setter for the contact name.
     *
     * @param contact
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /** This is the getter for the appointment ID.
     *
     * @return
     */
    public int getAppointmentid() {
        return appointmentid;
    }

    /** This is the setter for the appointment ID.
     *
     * @param appointmentid
     */
    public void setAppointmentid(int appointmentid) {
        this.appointmentid = appointmentid;
    }

    /** This is the getter for the title.
     *
     * @return
     */
    public String getTitle() {
        return title;
    }

    /** This is the setter for the title.
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /** This is the getter for the description.
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /** This is the setter for the description
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /** This is the getter for the location.
     *
     * @return
     */
    public String getLocation() {
        return location;
    }

    /** This is the setter for the location.
     *
     * @param location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /** This is the getter for the type.
     *
     * @return
     */
    public String getType() {
        return type;
    }

    /** This is the setter for the type.
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /** This is the getter for the Start.
     *
     * @return
     */
    public LocalDateTime getStart() {
        return Start;
    }

    /** This is the settter for the Start.
     *
     * @param start
     */
    public void setStart(LocalDateTime start) {
        Start = start;
    }

    /** This is the getter for the End.
     *
     * @return
     */
    public LocalDateTime getEnd() {
        return end;
    }

    /** This is the setter for the End.
     *
     * @param end
     */
    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    /** This is the getter for the Customer ID.
     *
     * @return
     */
    public int getCustomerid() {
        return customerid;
    }

    /** This is the setter for the Customer ID.
     *
     * @param customerid
     */
    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    /** This is the getter for the User ID.
     *
     * @return
     */
    public int getUserid() {
        return userid;
    }

    /** This is setter for the User ID.
     *
     * @param userid
     */
    public void setUserid(int userid) {
        this.userid = userid;
    }

    /** This is the contact for the Contact ID.
     *
     * @return
     */
    public int getContactid() {
        return contactid;
    }

    /** This is the setter for the Contact ID.
     *
     * @param contactid
     */
    public void setContactid(int contactid) {
        this.contactid = contactid;
    }

    /** This is the constructor for this class.
     *
     * @param appointmentid
     * @param title
     * @param description
     * @param location
     * @param type
     * @param start
     * @param end
     * @param customerid
     * @param userid
     * @param contactid
     * @param contact
     */
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

    public String toString(){return ("Type :" +type+ "");}


}
