package com.example.c195.Model;

/** This is the Contacts class that was created for this project.*/
public class Contacts {

    /** This integer represents the Contact_ID column in the database.*/
    private int contactid;

    /** This string represents the Contact_Name column in the Database.*/
    private String contactname;

    /** This string represents the Email column in the Database.*/
    private String email;

    /** This is the getter for the Contact ID.
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

    /** This is the getter for the Contact Name.
     *
     * @return
     */
    public String getContactname() {
        return contactname;
    }

    /** This is the setter for the Contact Name.
     *
     * @param contactname
     */
    public void setContactname(String contactname) {
        this.contactname = contactname;
    }

    /** This is the getter for the Email.
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /** This is the setter for the Email.
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /** This is the constructor.
     *
     * @param contactid
     * @param contactname
     * @param email
     */
    public Contacts(int contactid, String contactname, String email) {
        this.contactid = contactid;
        this.contactname = contactname;
        this.email = email;
    }

    /** This translates the memory location in the combo boxes into a readable form.
     *
     * @return
     */
    public String toString(){
        return ("ID: " + Integer.toString(contactid) + "Name: " + contactname + "email: " + email + "" );
    }
}
