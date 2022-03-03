package com.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GradeService {

    public List<Grade> getGrades() throws Exception {

        String sql = "SELECT * FROM grades";
        ConnectionDB db = new ConnectionDB();

        List<Grade> grades = new ArrayList<>();

        try (Connection con = db.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Grade grade = new Grade(
                        rs.getString("grades.course_name"),
                        rs.getInt("grades.grade"),
                        rs.getInt("grades.student_id")
                );
                grades.add(grade);
            }

            rs.close();
            stmt.close();

            return grades;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
