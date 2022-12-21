package com.example.c195.DBaccess;

import Helper.JDBC;
import com.example.c195.Model.Appointments;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/** This class handles all of the interaction between the Appointments table in the database and the program.
 */
public class DBAppointments {

    /**
     * This function grabs all of the appointment information, as well as the contact name, and adds it to an observable list.
     *
     * @return
     */
    public static ObservableList<Appointments> getAllAppointments() {

        ObservableList<Appointments> Alist = FXCollections.observableArrayList();

        try {
            String sql = "SELECT a.*, b.Contact_Name FROM appointments AS a JOIN contacts AS b on a.Contact_ID = b.Contact_ID";

            PreparedStatement ps = JDBC.getConnection().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int appointmentId = rs.getInt("Appointment_ID");
                String title = rs.getString("Title");
                String description = rs.getString("Description");
                String location = rs.getString("Location");
                String type = rs.getString("Type");
                LocalDateTime start = rs.getTimestamp("Start").toLocalDateTime();
                ZonedDateTime utctolocal1 = start.atZone(ZoneId.of("UTC"));
                ZonedDateTime utctolocal2 = utctolocal1.withZoneSameInstant(ZoneId.of(ZoneId.systemDefault().toString()));
                LocalDateTime finalstart = utctolocal2.toLocalDateTime();
                LocalDateTime end = rs.getTimestamp("End").toLocalDateTime();
                ZonedDateTime utctolocal3 = end.atZone(ZoneId.of("UTC"));
                ZonedDateTime utctolocal4 = utctolocal3.withZoneSameInstant(ZoneId.of(ZoneId.systemDefault().toString()));
                LocalDateTime finalend = utctolocal4.toLocalDateTime();

                int customerid = rs.getInt("Customer_ID");
                int userid = rs.getInt("User_ID");
                int contactid = rs.getInt("Contact_ID");
                String contact = rs.getString("Contact_Name");


                Appointments a = new Appointments(appointmentId, title, description, location, type, finalstart, finalend, customerid, userid, contactid, contact);
                Alist.add(a);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return Alist;

    }

    /**
     * This function allows the user to add appointments to the database.
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
     * @return
     * @throws SQLException
     */
    public static int addAppointment(int appointmentid, String title, String description, String location, String type, LocalDateTime start, LocalDateTime end, int customerid, int userid, int contactid) throws SQLException {
        try {
            String sql = "INSERT INTO appointments (Appointment_ID, Title, Description, Location, Type, Start, End, Customer_ID, User_ID, Contact_ID) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = JDBC.connection.prepareStatement(sql);
            ps.setInt(1, appointmentid);
            ps.setString(2, title);
            ps.setString(3, description);
            ps.setString(4, location);
            ps.setString(5, type);
            ps.setTimestamp(6, Timestamp.valueOf(start));
            ps.setTimestamp(7, Timestamp.valueOf(end));
            ps.setInt(8, customerid);
            ps.setInt(9, userid);
            ps.setInt(10, contactid);

            int rowsaffected = ps.executeUpdate();
            return rowsaffected;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointmentid;
    }

    /**
     * This funtion allows the user to modify the chosen appointment, without creating a new appointment.
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
     * @throws SQLException
     */
    public static void modifyAppointment(int appointmentid, String title, String description, String location, String type, LocalDateTime start, LocalDateTime end, int customerid, int userid, int contactid) throws SQLException {
        String sql = "UPDATE appointments SET Title = ?, Description = ?, Location = ?, Type = ?, Start = ?, End = ?, Customer_ID = ?, User_ID= ?, Contact_ID = ? WHERE Appointment_ID = ?";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ps.setString(1, title);
        ps.setString(2, description);
        ps.setString(3, location);
        ps.setString(4, type);
        ps.setTimestamp(5, Timestamp.valueOf(start));
        ps.setTimestamp(6, Timestamp.valueOf(end));
        ps.setInt(7, customerid);
        ps.setInt(8, userid);
        ps.setInt(9, contactid);
        ps.setInt(10, appointmentid);
        ps.executeUpdate();

    }


    /**
     * This function allows the user to delete an appointment from the database.
     *
     * @param appointmentid
     * @return
     * @throws SQLException
     */
    public static int deleteAppointment(int appointmentid) throws SQLException {
        String sql = "DELETE FROM appointments WHERE Appointment_ID = ?";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ps.setInt(1, appointmentid);
        int rowsaffected = ps.executeUpdate();
        return rowsaffected;
    }

    /** This function prevents any Key conflicts, by deleting any appointments associated with a customer ID.
     *
     * @param custid
     * @return
     * @throws SQLException
     */
    public static int deleteFromCustomer(int custid) throws SQLException {
        String sql = "DELETE FROM appointments WHERE Customer_ID = ?";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ps.setInt(1, custid);
        int rowsaffected = ps.executeUpdate();
        return rowsaffected;
    }

    /** This method selects the appointments where contact ID = 1.
     *
     * @return
     */
    public static ObservableList<Appointments> getContID1() {
        ObservableList<Appointments> id1 = FXCollections.observableArrayList();
        try {

            String sql = "SELECT * FROM appointments WHERE Contact_ID = 1";
            PreparedStatement ps = JDBC.connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                int appointmentId = rs.getInt("Appointment_ID");
                String title = rs.getString("Title");
                String description = rs.getString("Description");
                String location = rs.getString("Location");
                String type = rs.getString("Type");
                LocalDateTime start = rs.getTimestamp("Start").toLocalDateTime();
                ZonedDateTime utctolocal1 = start.atZone(ZoneId.of("UTC"));
                ZonedDateTime utctolocal2 = utctolocal1.withZoneSameInstant(ZoneId.of(ZoneId.systemDefault().toString()));
                LocalDateTime finalstart = utctolocal2.toLocalDateTime();
                LocalDateTime end = rs.getTimestamp("End").toLocalDateTime();
                ZonedDateTime utctolocal3 = end.atZone(ZoneId.of("UTC"));
                ZonedDateTime utctolocal4 = utctolocal3.withZoneSameInstant(ZoneId.of(ZoneId.systemDefault().toString()));
                LocalDateTime finalend = utctolocal4.toLocalDateTime();

                int customerid = rs.getInt("Customer_ID");
                int userid = rs.getInt("User_ID");
                int contactid = rs.getInt("Contact_ID");
                String contact = null;

                Appointments a = new Appointments(appointmentId, title, description, location, type, finalstart, finalend, customerid, userid, contactid, contact);
                id1.add(a);


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return id1;
    }

    /** This method selects the appointments where contact ID = 2.
     *
     * @return
     */
    public static ObservableList<Appointments> getContID2() {
        ObservableList<Appointments> id2 = FXCollections.observableArrayList();
        try {

            String sql = "SELECT * FROM appointments WHERE Contact_ID = 2";
            PreparedStatement ps = JDBC.connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                int appointmentId = rs.getInt("Appointment_ID");
                String title = rs.getString("Title");
                String description = rs.getString("Description");
                String location = rs.getString("Location");
                String type = rs.getString("Type");
                LocalDateTime start = rs.getTimestamp("Start").toLocalDateTime();
                ZonedDateTime utctolocal1 = start.atZone(ZoneId.of("UTC"));
                ZonedDateTime utctolocal2 = utctolocal1.withZoneSameInstant(ZoneId.of(ZoneId.systemDefault().toString()));
                LocalDateTime finalstart = utctolocal2.toLocalDateTime();
                LocalDateTime end = rs.getTimestamp("End").toLocalDateTime();
                ZonedDateTime utctolocal3 = end.atZone(ZoneId.of("UTC"));
                ZonedDateTime utctolocal4 = utctolocal3.withZoneSameInstant(ZoneId.of(ZoneId.systemDefault().toString()));
                LocalDateTime finalend = utctolocal4.toLocalDateTime();

                int customerid = rs.getInt("Customer_ID");
                int userid = rs.getInt("User_ID");
                int contactid = rs.getInt("Contact_ID");
                String contact = null;

                Appointments a = new Appointments(appointmentId, title, description, location, type, finalstart, finalend, customerid, userid, contactid, contact);
                id2.add(a);


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return id2;
    }

    /**This method selects the appointments where contact ID = 3.
     *
     * @return
     */
    public static ObservableList<Appointments> getContID3() {
        ObservableList<Appointments> id3 = FXCollections.observableArrayList();
        try {

            String sql = "SELECT * FROM appointments WHERE Contact_ID = 3";
            PreparedStatement ps = JDBC.connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                int appointmentId = rs.getInt("Appointment_ID");
                String title = rs.getString("Title");
                String description = rs.getString("Description");
                String location = rs.getString("Location");
                String type = rs.getString("Type");
                LocalDateTime start = rs.getTimestamp("Start").toLocalDateTime();
                ZonedDateTime utctolocal1 = start.atZone(ZoneId.of("UTC"));
                ZonedDateTime utctolocal2 = utctolocal1.withZoneSameInstant(ZoneId.of(ZoneId.systemDefault().toString()));
                LocalDateTime finalstart = utctolocal2.toLocalDateTime();
                LocalDateTime end = rs.getTimestamp("End").toLocalDateTime();
                ZonedDateTime utctolocal3 = end.atZone(ZoneId.of("UTC"));
                ZonedDateTime utctolocal4 = utctolocal3.withZoneSameInstant(ZoneId.of(ZoneId.systemDefault().toString()));
                LocalDateTime finalend = utctolocal4.toLocalDateTime();

                int customerid = rs.getInt("Customer_ID");
                int userid = rs.getInt("User_ID");
                int contactid = rs.getInt("Contact_ID");
                String contact = null;

                Appointments a = new Appointments(appointmentId, title, description, location, type, finalstart, finalend, customerid, userid, contactid, contact);
                id3.add(a);


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return id3;
    }

    public static ObservableList<Appointments> sortByCustID(int cid) {
        ObservableList<Appointments> custIDSort = FXCollections.observableArrayList();
        try {

            String sql = "SELECT * FROM appointments WHERE Customer_ID = ?";
            PreparedStatement ps = JDBC.connection.prepareStatement(sql);
            ps.setInt(1, cid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                int appointmentId = rs.getInt("Appointment_ID");
                String title = rs.getString("Title");
                String description = rs.getString("Description");
                String location = rs.getString("Location");
                String type = rs.getString("Type");
                LocalDateTime start = rs.getTimestamp("Start").toLocalDateTime();
                ZonedDateTime utctolocal1 = start.atZone(ZoneId.of("UTC"));
                ZonedDateTime utctolocal2 = utctolocal1.withZoneSameInstant(ZoneId.of(ZoneId.systemDefault().toString()));
                LocalDateTime finalstart = utctolocal2.toLocalDateTime();
                LocalDateTime end = rs.getTimestamp("End").toLocalDateTime();
                ZonedDateTime utctolocal3 = end.atZone(ZoneId.of("UTC"));
                ZonedDateTime utctolocal4 = utctolocal3.withZoneSameInstant(ZoneId.of(ZoneId.systemDefault().toString()));
                LocalDateTime finalend = utctolocal4.toLocalDateTime();

                int customerid = rs.getInt("Customer_ID");
                int userid = rs.getInt("User_ID");
                int contactid = rs.getInt("Contact_ID");
                String contact = null;

                Appointments a = new Appointments(appointmentId, title, description, location, type, finalstart, finalend, customerid, userid, contactid, contact);
                custIDSort.add(a);


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return custIDSort;
    }

    /** This method organizes the database by month and type, and then counts the total.
     *
     * @param type
     * @param month
     * @return
     */
    public static int sortByMonth(String type, String month) {
            int index = 1;
        try {

            String sql = "SELECT COUNT(*) AS total FROM appointments WHERE MONTHNAME(Start) = ? AND Type = ?";
            PreparedStatement ps = JDBC.connection.prepareStatement(sql);
            ps.setString(1, type);
            ps.setString(2, month);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

               int total = rs.getInt(1);







            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }



}
