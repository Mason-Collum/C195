package com.example.c195.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/** This is the customer class created for this project.
 */
public class Customer {

    /** This integer represents the Customer ID column in the SQL database.*/
    private int id;

    /** This string represents the Customer Name column in the SQL database.*/
    private String name;

    /** This string represents the Customer Address column in the SQL database.*/
    private String address;

    /** This string represents the Customer Postal Code column in the SQL database.*/
    private String postalcode;

    /** This string represents the Customer Phone Number column in the SQL database.*/
    private String phone;

    /** This Integer represents the Customer DivisionID column in the SQL database.*/
    private int FLDid;

    /** This string represents the Division column in a separate table.
     * It is linked to this class throught the Division ID column.
     */
    private String Division;

    /** This is the getter for the Division.
     *
     * @return
     */
    public String getDivision() {
        return Division;
    }

    /** This is the setter for the Division.*/
    public void setDivision(String division) {
        Division = division;
    }

    /** This is the getter for the Customer ID.
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /** This is the setter for the Customer ID.
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /** This is the getter for the Customer name.
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /** This is the setter for the Customer name.
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /** This is the getter for the Customer Address.
     *
     * @return
     */
    public String getAddress() {
        return address;
    }

    /** This is the setter for the customer Address.
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /** This is the getter for the Postal Code.
     *
     * @return
     */
    public String getPostalcode() {
        return postalcode;
    }

    /** This is the setter for the Postal Code.
     *
     * @param postalcode
     */
    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    /** This is the getter for the Phone number
     *
     * @return
     */
    public String getPhone() {
        return phone;
    }

    /** This is the setter for the phone number.
     *
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /** This is the getter for the Division ID.
     *
     * @return
     */
    public int getFLDid() {
        return FLDid;
    }

    /** This is the setter for the Division ID.
     *
     * @param FLDid
     */
    public void setFLDid(int FLDid) {
        this.FLDid = FLDid;
    }

    /** This is the constructor.
     *
     * @param id
     * @param name
     * @param address
     * @param postalcode
     * @param phone
     * @param FLDid
     * @param Division
     */
    public Customer(int id, String name, String address, String postalcode, String phone, int FLDid, String Division) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.postalcode = postalcode;
        this.phone = phone;
        this.FLDid = FLDid;
        this.Division = Division;

    }

    public String toString(){ return ("ID: " +id+ "");}


}


