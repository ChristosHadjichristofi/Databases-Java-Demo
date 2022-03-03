<%@ page import="com.demo.LayoutService" %>
<%@ page import="com.demo.Pair" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    Pair<String, Integer> bestDribblerDetails = null, bestShooterDetailes = null;
    LayoutService layoutService = new LayoutService();
    try {
        bestDribblerDetails = layoutService.getBestDribblerDetails();
        bestShooterDetailes = layoutService.getBestShooterDetails();

    } catch (Exception e) {
        e.printStackTrace();
    }
%>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title> Home Page </title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <link rel="stylesheet" href="assets/css/styles.css">
</head>

<body>

<jsp:include page="navbar.jsp"/>

<div class="container" id="row-container">
    <div class="row" id="row">
        <div class="col-md-6">
            <div class="card" id="card-container-layout">
                <div class="card-body" id="card">
                    <h4 class="card-title">View Students</h4>
                    <p class="card-text" id="paragraph">Simple Query to database to show all students</p>
                    <a class="btn btn-primary" id="show-btn" href="students.jsp">Show</a>
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <div class="card" id="card-container-layout">
                <div class="card-body" id="card">
                    <h4 class="card-title">View Grades</h4>
                    <p class="card-text" id="paragraph">Simple Query to database to show students' grades<br></p>
                    <a class="btn btn-primary" id="show-btn" href="grades.jsp">Show</a>
                </div>
            </div>
        </div>
    </div>

    <div class="row" id="row-2">
        <div class="col-md-6">
            <div class="card" id="card-container-layout">
                <div class="card-body" id="card">
                    <h4 class="card-title">Best Dribbling Grade</h4>
                    <p class="card-text" id="paragraph">The best Dribbling grade is <%= bestDribblerDetails.second() %> and belongs to <%= bestDribblerDetails.first() %>.</p>
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <div class="card" id="card-container-layout">
                <div class="card-body" id="card">
                    <h4 class="card-title">Best Shooting Grade</h4>
                    <p class="card-text" id="paragraph">The best Shooting grade is <%= bestShooterDetailes.second() %> and belongs to <%= bestShooterDetailes.first() %>.</p>
                </div>
            </div>
        </div>
    </div>

</div>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>