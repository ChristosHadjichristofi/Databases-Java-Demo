<%@ page import="com.demo.LayoutService" %>
<%@ page import="com.demo.Pair" %>
<%@ page import="com.demo.Message" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    ArrayList<Message> messages;

    // get any incoming messages from session attribute named messages
    // if nothing exists then messages is an empty arraylist
    if ((ArrayList<Message>) session.getAttribute("messages") == null) messages = new ArrayList<>();
        // else get that value
    else messages = (ArrayList<Message>) session.getAttribute("messages");

    String msgField = "";

    // create the object in the form of a stringified json
    for (Message m : messages) {
        msgField += "{\"type\":\"" + m.type + "\",\"value\":\"" + m.value.replaceAll("['\"]+", "") + "\"},";
    }

    // empty session messages
    session.setAttribute("messages", new ArrayList<Message>());

    // retrieve best dribbler/shooter details from database
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
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css">
</head>

<body>

    <jsp:include page="navbar.jsp"/>

    <input type="hidden" name="message" id="message" value='<%=msgField%>' >
    <div class="container" id="row-container">
        <div class="row" id="row">
            <div class="col-md-4">
                <div class="card" id="card-container-layout">
                    <div class="card-body" id="card">
                        <h4 class="card-title">View Students</h4>
                        <p class="card-text" id="paragraph">Simple Query to database to show all students</p>
                        <a class="btn btn-primary" id="show-btn" href="students.jsp">Show</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card" id="card-container-layout">
                    <div class="card-body" id="card">
                        <h4 class="card-title">View Grades</h4>
                        <p class="card-text" id="paragraph">Simple Query to database to show students' grades<br></p>
                        <a class="btn btn-primary" id="show-btn" href="grades.jsp">Show</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card" id="card-container-layout">
                    <div class="card-body" id="card">
                        <h4 class="card-title">Create Student</h4>
                        <p class="card-text" id="paragraph">Enter a new student into the database<br></p>
                        <a class="btn btn-primary" id="show-btn" href="/insert-student.jsp">Create</a>
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
    <script src="/assets/js/jquery.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>

    <script>
        $(document).ready(function() {
            toastr.options = {
                "closeButton": true,
                "positionClass": "toast-bottom-right",
                "preventDuplicates": false
            };
            /* In order to access variables sent to ejs file to script you must Parse them to string */
            /* then to parse them back to JSON */
            let messages = document.getElementById("message").value;
            if (messages !== "") messages = JSON.parse("[" + messages.slice(0, -1) + "]");
            else messages = [];

            messages
            .forEach(({
              type,
              value
            }) => {
                switch (type) {
                    case "error":
                        toastr.error(value)
                        break;
                    case "success":
                        toastr.success(value)
                        break;
                    case "warning":
                        toastr.warning(value)
                        break;
                    default:
                        toastr.info(value)
                        break;
                }
            });
        })
    </script>
</body>

</html>