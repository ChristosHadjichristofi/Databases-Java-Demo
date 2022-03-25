package com.demo;

public class Student {

    private Integer id;
    private String name;
    private String surname;
    private String email;

    public Student(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public Student(Integer id, String name, String surname, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public Integer getId() { return this.id; }
    public String getName() { return this.name; }
    public String getSurname() { return this.surname; }
    public String getEmail() { return this.email; }

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
