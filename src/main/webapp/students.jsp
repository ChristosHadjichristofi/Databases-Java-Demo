<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="java.util.List" %>
<%@ page import="com.demo.StudentService" %>
<%@ page import="com.demo.Student" %>


<%
    StudentService studentService = new StudentService();
    List<Student> students = null;
    try {
        students = studentService.getStudents();
    } catch (Exception e) {
        e.printStackTrace();
    }
%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title> Students Page </title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <link rel="stylesheet" href="assets/css/styles.css">
</head>

<body>

<jsp:include page="navbar.jsp"/>

<div class="container">
    <div class="row" id="row">
        <div class="col-md-12">
            <div class="card" id="card-container">
                <div class="card-body" id="card">
                    <% if (students.size() == 0) { %>
                    <h1 style="margin-top: 5rem;">No Students found!</h1>
                    <% } else { %>
                    <div class="table-responsive">
                        <table class="table">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Surname</th>
                                <th>Email</th>
                            </tr>
                            </thead>
                            <tbody>
                            <%
                            int index = 0;
                            for (Student student : students) { %>
                            <tr>
                                <td><%= ++index %></td>
                                <td><%= student.getName() %></td>
                                <td><%= student.getSurname() %></td>
                                <td><%= student.getEmail() %></td>
                            </tr>
                            <% } %>
                            </tbody>
                        </table>
                    </div>
                    <% } %>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>