package com.demo;

/**
 * Grade class to save grade information
 */
public class Grade {

    private Integer id;
    private String course_name;
    private int grade;
    private int student_id;

    /**
     * Constructor to create Grade object with id, course_name, grade, student_id
     *
     * @param id id of grade
     * @param course_name name of course that grade belongs to
     * @param grade grade of course
     * @param student_id student achieved grade
     */
    public Grade(Integer id, String course_name, int grade, int student_id) {
        this.id = id;
        this.course_name = course_name;
        this.grade = grade;
        this.student_id = student_id;
    }

    /**
     * Constructor to create Grade object with course_name, grade, student_id
     *
     * @param course_name name of course that grade belongs to
     * @param grade grade of course
     * @param student_id student achieved grade
     */
    public Grade(String course_name, int grade, int student_id) {
        this.course_name = course_name;
        this.grade = grade;
        this.student_id = student_id;
    }

    /* Getters */
    public Integer getId() { return this.id; }
    public int getGrade() { return this.grade; }
    public int getStudentID() { return this.student_id; }
    public String getCourseName() { return this.course_name; }

    /* Setters */
    public void setId(int id) { this.id = id; }
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
