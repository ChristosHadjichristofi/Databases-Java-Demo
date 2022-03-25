<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="com.demo.StudentService" %>
<%@ page import="com.demo.Student" %>
<%@ page import="com.demo.Message" %>
<%@ page import="java.util.ArrayList" %>

<%
    // get student info from the request
    Integer id = Integer.valueOf(request.getParameter("id"));
    String name = request.getParameter("name");
    String surname = request.getParameter("surname");
    String email = request.getParameter("email");
    StudentService studentService = new StudentService();
    // create student object
    Student student = new Student(id, name, surname, email);

    Message msg;
    // try to update a student
    try {
        String value = studentService.updateStudent(student);
        // if the value contains error/Error then this is an error message
        if (value.contains("Error") || value.contains("error")) msg = new Message("error", value);
        // else the student was successfully created
        else msg = new Message("success", value);
    } catch (Exception e) {
        e.printStackTrace();
        msg = new Message("error", "Something went wrong!");
    }

    // create an arraylist of messages and append the new message
    ArrayList<Message> messages = new ArrayList<>();
    messages.add(msg);

    // set session attribute named messages to messages value
    session.setAttribute("messages", messages);
    // redirect to students page
    response.sendRedirect("students.jsp");
%>