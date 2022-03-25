package com.demo;

public class Grade {

    private Integer id;
    private String course_name;
    private int grade;
    private int student_id;

    public Grade(Integer id, String course_name, int grade, int student_id) {
        this.id = id;
        this.course_name = course_name;
        this.grade = grade;
        this.student_id = student_id;
    }

    public Grade(String course_name, int grade, int student_id) {
        this.course_name = course_name;
        this.grade = grade;
        this.student_id = student_id;
    }

    public Integer getId() { return this.id; }
    public int getGrade() { return this.grade; }
    public int getStudentID() { return this.student_id; }
    public String getCourseName() { return this.course_name; }

    public void setGrade(int grade) { this.grade = grade; }
    public void setStudentID(int student_id) { this.student_id = student_id; }
    public void setCourseName(String course_name) { this.course_name = course_name; }

    @Override
    public String toString() {
        return "<ul>"
            + "<li>grade= " + course_name + "</li>"
            + "<li>grade= " + grade + "</li>"
            + "<li>grade= " + student_id + "</li>";
    }
}
