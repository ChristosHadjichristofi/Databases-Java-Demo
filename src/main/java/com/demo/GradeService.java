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
                        rs.getInt("grades.id"),
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

    public String deleteGrade(Integer id) throws Exception {
        Connection con = null;
        String message = "";

        String sql = "DELETE FROM grades WHERE id = ?;";

        ConnectionDB db = new ConnectionDB();

        try {
            con = db.getConnection();

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);

            stmt.executeUpdate();
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
