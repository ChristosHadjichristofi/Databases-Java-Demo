<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="com.demo.GradeService" %>
<%@ page import="com.demo.Message" %>
<%@ page import="java.util.ArrayList" %>

<%
    // get the id that was sent
    Integer id = Integer.valueOf(request.getParameter("id"));

    // create a message object
    Message msg;
    // try to delete a grade
    try {
        GradeService gradeService = new GradeService();
        // save the message returned from trying to delete a grade
        String value = gradeService.deleteGrade(id);
        // in case the value contains error/Error then this message is an error
        if (value.contains("Error") || value.contains("error")) msg = new Message("error", value);
        // else the grade was successfully deleted
        else msg = new Message("success", value);
    } catch (Exception e) {
        e.printStackTrace();
        msg = new Message("error", "Something went wrong!");
    }

    // append the message in a messages arraylist
    ArrayList<Message> messages = new ArrayList<>();
    messages.add(msg);

    // set session attribute named messages with the messages arraylist
    session.setAttribute("messages", messages);
    // redirect to grades
    response.sendRedirect("grades.jsp");
%>