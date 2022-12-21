package com.example.c195.Model;

/** This is the Division class created for this project.
 */
public class Division {

    /** This integer represents the Division ID column in the SQL Database.*/
    private final int fldid;

    /** This string represents the Division column in the SQL database.*/
    private final String FLD;

    /** This integer represents the country ID column in the SQL database.*/
    private final int countryid;

    /** This is the constructor.
     *
     * @param fldid
     * @param FLD
     * @param countryid
     */
    public Division(int fldid, String FLD, int countryid) {
        this.fldid = fldid;
        this.FLD = FLD;
        this.countryid = countryid;
    }

    /** This is the getter for the Division ID.
     *
     * @return
     */
    public int getFldid() {
        return fldid;
    }


    /** This is the getter for the Division.
     *
     * @return
     */
    public  String getFLD() {
        return FLD;
    }


    /** This is the getter for the Country ID.
     *
     * @return
     */
    public Integer getCountryid() {
        return countryid;
    }


    /** This translates the memory location displayed in the combo boxes, into a legible form.
     *
     * @return
     */
    public String toString() {
        return (" DivisionID: " + Integer.toString(fldid) +" Division: " + FLD + " CountryID: " + Integer.toString(countryid));
    }
}
