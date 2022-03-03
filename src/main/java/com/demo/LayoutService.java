package com.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LayoutService {

    public Pair<String, Integer> getBestDribblerDetails() throws Exception {
        Pair<String, Integer> result = null;
        String sql = "SELECT * FROM grades, students WHERE course_name = 'DRI' AND grades.student_id = students.id ORDER BY grade DESC LIMIT 1";
        ConnectionDB db = new ConnectionDB();

       try (Connection con = db.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                result = new Pair<>(rs.getString("name") + " " + rs.getString("surname"), rs.getInt("grade"));
            }
            
            rs.close();
            stmt.close();

            return result;
       } catch (Exception e) {
           throw new Exception(e.getMessage());
       }
    }

    public Pair<String, Integer> getBestShooterDetails() throws Exception {
        Pair<String, Integer> result = null;
        String sql = "SELECT * FROM grades, students WHERE course_name = 'SHO' AND grades.student_id = students.id ORDER BY grade DESC LIMIT 1";
        ConnectionDB db = new ConnectionDB();

        try (Connection con = db.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                result = new Pair<>(rs.getString("name") + " " + rs.getString("surname"), rs.getInt("grade"));
            }

            rs.close();
            stmt.close();

            return result;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
