package com.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GradeService {

    /**
     * Method to get all grades from the database
     *
     * @return List of grades from database
     * @throws Exception when trying to connect to database
     */
    public List<Grade> getGrades() throws Exception {

        // sql query
        String sql = "SELECT * FROM grades";
        // database connection object
        ConnectionDB db = new ConnectionDB();

        // data structure to keep all grades retrieved from database
        List<Grade> grades = new ArrayList<>();

        // try connect to database, catch any exceptions
        try (Connection con = db.getConnection()) {
            // prepare the statement
            PreparedStatement stmt = con.prepareStatement(sql);

            // get the results from executing the query
            ResultSet rs = stmt.executeQuery();

            // iterate through the result set
            while (rs.next()) {
                // create new grade object
                Grade grade = new Grade(
                        rs.getInt("grades.id"),
                        rs.getString("grades.course_name"),
                        rs.getInt("grades.grade"),
                        rs.getInt("grades.student_id")
                );

                // append grade in grades list
                grades.add(grade);
            }

            //close the result set
            rs.close();
            // close the statement
            stmt.close();

            // return the grades retrieved from database
            return grades;
        } catch (Exception e) {
            // throw any errors occurred
            throw new Exception(e.getMessage());
        }
    }

    /**
     * Method to delete by ID a grade
     *
     * @param id id of grade to be deleted from database
     * @return string returned that states if the grade deleted or not
     * @throws Exception when trying to connect to database
     */
    public String deleteGrade(Integer id) throws Exception {
        Connection con = null;
        String message = "";

        // sql query
        String sql = "DELETE FROM grades WHERE id = ?;";

        // database connection object
        ConnectionDB db = new ConnectionDB();

        // try connect to database, catch any exceptions
        try {
            con = db.getConnection();

            // prepare statement
            PreparedStatement stmt = con.prepareStatement(sql);

            // set every ? of statement
            stmt.setInt(1, id);

            // execute the query
            stmt.executeUpdate();

            // close the statement
            stmt.close();

        } catch (Exception e) {
            message = "Error while delete grade: " + e.getMessage();
        } finally {
            if (con != null) con.close();
            if (message.equals("")) message = "Grade successfully deleted!";
        }

        return message;
    }
}
