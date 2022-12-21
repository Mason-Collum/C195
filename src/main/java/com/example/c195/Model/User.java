package com.example.c195.Model;

/** This the User class that was developed for this project.
 */
public class User {

    /** This integer represents the User ID column in the SQL database.*/
    private int id;

    /** This string represents the Username column in the SQL database.*/
    private String username;

    /** This string represents the Password column in the SQL database.*/
    private String password;

    /** This is the constructor.
     *
     * @param id
     * @param username
     * @param password
     */
    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    /** This is the getter for the User ID.
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /** This is the setter for the User ID.
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /** This is the getter for the Username.
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /** This the setter for the Username.
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /** This is the getter for the Password.
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /** This is the setter for the Password.
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
