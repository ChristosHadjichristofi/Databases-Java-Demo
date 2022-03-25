package com.demo;

/**
 * Student class to store student data
 */
public class Student {

    private Integer id;
    private String name;
    private String surname;
    private String email;

    /**
     * Constructor to save student's data (without id)
     *
     * @param name name of student
     * @param surname surname of student
     * @param email email of student
     */
    public Student(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    /**
     * Constructor to save student's data (with id)
     *
     * @param id id of student
     * @param name name of student
     * @param surname surname of student
     * @param email email of student
     */
    public Student(Integer id, String name, String surname, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    // getters
    public Integer getId() { return this.id; }
    public String getName() { return this.name; }
    public String getSurname() { return this.surname; }
    public String getEmail() { return this.email; }

    // setters
    public void setId(Integer id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setSurname(String surname) { this.surname = surname; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {

    return "<ul>"
            + "<li>email= " + name + "</li>"
            + "<li>surname= " + surname + "</li>"
            + "<li>email= " + email + "</li>";
    }
}
