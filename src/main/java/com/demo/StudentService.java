package com.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentService {

    /**
     * Method to get all students from database
     *
     * @return list of all students found in database
     * @throws Exception when trying to connect to database
     */
    public List<Student> getStudents() throws Exception {

        // sql query
        String sql = "SELECT * FROM students";
        // connection object
        ConnectionDB db = new ConnectionDB();

        // data structure to keep all students retrieved from database
        List<Student> students = new ArrayList<Student>();

        // try connect to database, catch any exceptions
        try (Connection con = db.getConnection()) {
            // prepare statement
            PreparedStatement stmt = con.prepareStatement(sql);

            // get the results from executing the query
            ResultSet rs = stmt.executeQuery();

            // iterate through the result set
            while (rs.next()) {
                // create new student object
                Student student = new Student(
                    rs.getInt("students.id"),
                    rs.getString("students.name"),
                    rs.getString("students.surname"),
                    rs.getString("students.email")
                );

                // append student in students list
                students.add(student);
            }

            // close result set
            rs.close();
            // close statement
            stmt.close();

            // return result
            return students;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /**
     * Method to create a student in the database
     *
     * @param student student to be created
     * @return string returned that states if the student created or not
     * @throws Exception when trying to connect to database
     */
    public String createStudent(Student student) throws Exception {
        String message = "";
        Connection con = null;

        // connection object
        ConnectionDB db = new ConnectionDB();

        // sql query
        String insertStudentQuery = "INSERT INTO students (name, surname, email) VALUES (?, ?, ?);";

        // try connect to database, catch any exceptions
        try {
            con = db.getConnection(); //get Connection

            // prepare the statement
            PreparedStatement stmt = con.prepareStatement(insertStudentQuery);

            // set every ? of statement
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getSurname());
            stmt.setString(3, student.getEmail());

            // execute the query
            stmt.executeUpdate();

            // close the statement
            stmt.close();
            // close the connection
            db.close();
        } catch (Exception e) {
            message = "Error while inserting customer: " + e.getMessage();
        } finally {
            if (con != null) // if connection is still open, then close.
                con.close();
            if (message.equals("")) message = "Student successfully inserted!";

        }

        // return respective message
        return message;
    }

    /**
     * Method to update student
     *
     * @param student student to be updated
     * @return string returned that states if the grade deleted or not
     * @throws Exception when trying to connect to database
     */
    public String updateStudent(Student student) throws Exception {
        Connection con = null;
        String message = "";

        // sql query
        String sql = "UPDATE students SET name=?, surname=?, email=? WHERE id=?;";

        // connection object
        ConnectionDB db = new ConnectionDB();

        // try connect to database, catch any exceptions
        try {
            // get connection
            con = db.getConnection();

            // prepare the statement
            PreparedStatement stmt = con.prepareStatement(sql);

            // set every ? of statement
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getSurname());
            stmt.setString(3, student.getEmail());
            stmt.setInt(4, student.getId());

            // execute the query
            stmt.executeUpdate();

            // close the statement
            stmt.close();

        } catch (Exception e) {
            message = "Error while updating student: " + e.getMessage();

        } finally {
            if (con != null) con.close();
            if (message.equals("")) message = "Student successfully updated!";
        }

        // return respective message
        return message;
    }

}
