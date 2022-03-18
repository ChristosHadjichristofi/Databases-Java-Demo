package com.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentService {

    public List<Student> getStudents() throws Exception {

        String sql = "SELECT * FROM students";
        ConnectionDB db = new ConnectionDB();

        List<Student> students = new ArrayList<Student>();

        try (Connection con = db.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Student student = new Student(
                    rs.getString("students.name"),
                    rs.getString("students.surname"),
                    rs.getString("students.email")
                );
                students.add(student);
            }

            rs.close();
            stmt.close();

            return students;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public String create(Student student) throws Exception {
        String message = "";
        Connection con = null;
        ConnectionDB db = new ConnectionDB();
        String instertStudentQuery = "INSERT INTO students "
                + " (name, surname, email) "
                + " VALUES (?, ?, ?);";

        try {

            con = db.getConnection(); //get Connection

            PreparedStatement stmt = con.prepareStatement(instertStudentQuery);

            stmt.setString(1, student.getName());
            stmt.setString(2, student.getSurname());
            stmt.setString(3, student.getEmail());

            stmt.executeUpdate();

            stmt.close();
            db.close(); //close connection

        } catch (Exception e) {
            message = "Error while inserting customer: " + e.getMessage();
        } finally {
            if (con != null) // if connection is still open, then close.
                con.close();
            if (message.equals("")) message = "Student successfully inserted!";

        }

        return message;
    }

}
