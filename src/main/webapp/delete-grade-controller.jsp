<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="com.demo.GradeService" %>
<%@ page import="com.demo.Message" %>
<%@ page import="java.util.ArrayList" %>

<%
    Integer id = Integer.valueOf(request.getParameter("id"));

    Message msg;
    try {
        GradeService gradeService = new GradeService();
        String value = gradeService.deleteGrade(id);
        if (value.contains("Error") || value.contains("error")) msg = new Message("error", value);
        else msg = new Message("success", value);
    } catch (Exception e) {
        e.printStackTrace();
        msg = new Message("error", "Something went wrong!");
    }

    ArrayList<Message> messages = new ArrayList<>();
    messages.add(msg);

    session.setAttribute("messages", messages);
    response.sendRedirect("grades.jsp");
%>