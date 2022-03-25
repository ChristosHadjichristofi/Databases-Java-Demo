<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="com.demo.StudentService" %>
<%@ page import="com.demo.Student" %>
<%@ page import="com.demo.Message" %>
<%@ page import="java.util.ArrayList" %>

<%
    String name = request.getParameter("name");
    String surname = request.getParameter("surname");
    String email = request.getParameter("email");
    StudentService studentService = new StudentService();
    // create student object
    Student student = new Student(name, surname, email);

    Message msg;
    try {
        String value = studentService.createStudent(student);
        if (value.contains("Error") || value.contains("error")) msg = new Message("error", value);
        else msg = new Message("success", value);
    } catch (Exception e) {
        e.printStackTrace();
        msg = new Message("error", "Something went wrong!");
    }

    ArrayList<Message> messages = new ArrayList<>();
    messages.add(msg);

    session.setAttribute("messages", messages);
    response.sendRedirect("index.jsp");
%>