<%-- 
    Document   : Welcome
    Created on : Apr 26, 2018, 9:18:54 PM
    Author     : harsh
--%>
<%@ page import = "java.io.*,java.util.*" %>
<%
    HttpSession session2 = request.getSession();
    String user_id = ""+request.getSession().getAttribute("user_id");
    if (null != user_id && !user_id.isEmpty()) {
        
    } else {
        response.sendRedirect("Login.jsp");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
            <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css">
            <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/js/materialize.min.js"></script>
            <link rel="stylesheet" type="text/css" href="registercss.css">
            <script
                    src="https://code.jquery.com/jquery-3.3.1.min.js"
                    integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
                    crossorigin="anonymous"></script>
                    <script src="test.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="row">
                    <h4>Welcome</h4>

                
                <button class="btn waves-effect waves-light" onclick=location.href="AvailableRides.jsp" type="submit" name="action">Available Ride
                        <i class="material-icons right">send</i>
                </button><br><br>
                <button class="btn waves-effect waves-light" onclick=location.href="RequestRides.jsp" type="submit" name="action">Request Ride
                        <i class="material-icons right">send</i>
                </button><br><br>
                <button class="btn waves-effect waves-light" onclick=location.href="WantToShareRide.jsp" type="submit" name="action">Want to share Ride
                        <i class="material-icons right">send</i>
                </button><br><br>
               

            </div>
            
            
        </div>
    </body>
</html>
