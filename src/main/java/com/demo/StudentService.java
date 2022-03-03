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

}
