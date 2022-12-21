package com.example.c195.Model;

/** This is the Country class that was created for this project.
 */
public class Country {

    /** This integer represents the Country ID column in the SQL database.*/
    private int countryid;

    /** This string represents the Country name column in the SQL database.*/
    private String countryname;

    /** This is the getter for the Country ID.
     *
     * @return
     */
    public int getCountryid() {
        return countryid;
    }

    /** This is the setter for the Country ID.
     *
     * @param countryid
     */
    public void setCountryid(int countryid) {
        this.countryid = countryid;
    }

    /** This is the getter for the country name.
     *
     * @return
     */
    public String getCountryname() {
        return countryname;
    }

    /** This is the setter for the country name.
     *
     * @param countryname
     */
    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    /** This is the constructor for the country class.
     *
     * @param countryid
     * @param countryname
     */
    public Country(int countryid, String countryname) {
        this.countryid = countryid;
        this.countryname = countryname;
    }

    /** This translates the memory location displayed in the combo boxes, into a legible form.
     *
     * @return
     */
    public String toString(){
        return ("#" + Integer.toString(countryid)+ " " +countryname+ "");
    }
}
