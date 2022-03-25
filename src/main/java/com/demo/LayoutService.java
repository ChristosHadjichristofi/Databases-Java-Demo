package com.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LayoutService {

    /**
     * Method to retrieve the best dribbler details
     *
     * @return the best dribbler details
     * @throws Exception when trying to connect to database
     */
    public Pair<String, Integer> getBestDribblerDetails() throws Exception {
        Pair<String, Integer> result = null;

        // sql query to retrieve the best dribbler details
        String sql = "SELECT * FROM grades, students WHERE course_name = 'DRI' AND grades.student_id = students.id ORDER BY grade DESC LIMIT 1";
        // connection object
        ConnectionDB db = new ConnectionDB();

        // try connect to database, catch any exceptions
        try (Connection con = db.getConnection()) {
           // prepare the statement
           PreparedStatement stmt = con.prepareStatement(sql);

            // get the results from executing the query
           ResultSet rs = stmt.executeQuery();

            // iterate through the result set and save the result to result variable
           if (rs.next()) {
               result = new Pair<>(rs.getString("name") + " " + rs.getString("surname"), rs.getInt("grade"));
           }

           // close the result set
           rs.close();
           // close the statement
           stmt.close();

           // return the result
           return result;
       } catch (Exception e) {
           throw new Exception(e.getMessage());
       }
    }

    /**
     * Method to retrieve the best shooter details
     *
     * @return the best shooter details
     * @throws Exception when trying to connect to database
     */
    public Pair<String, Integer> getBestShooterDetails() throws Exception {
        Pair<String, Integer> result = null;
        // sql query
        String sql = "SELECT * FROM grades, students WHERE course_name = 'SHO' AND grades.student_id = students.id ORDER BY grade DESC LIMIT 1";
        // connection object
        ConnectionDB db = new ConnectionDB();

        // try connect to database, catch any exceptions
        try (Connection con = db.getConnection()) {
            // prepare the statement
            PreparedStatement stmt = con.prepareStatement(sql);

            // get the results from executing the query
            ResultSet rs = stmt.executeQuery();

            // iterate through the result set and save the result to result variable
            if (rs.next()) {
                result = new Pair<>(rs.getString("name") + " " + rs.getString("surname"), rs.getInt("grade"));
            }

            // close the result set
            rs.close();
            // close the statement
            stmt.close();

            // return result
            return result;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
