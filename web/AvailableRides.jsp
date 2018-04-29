<%-- 
    Document   : AvailableRides
    Created on : Apr 27, 2018, 10:42:16 AM
    Author     : harsh
--%>

<%@page import="src.RideObject"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/js/materialize.min.js"></script>
        <link rel="stylesheet" type="text/css" href="registercss.css">
        <style>
            table{
                width:100%;
            }
        </style>
        <script
            src="https://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous"></script>
        <script src="test.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="row">
                
                <button class="btn waves-effect waves-light" onclick=location.href="Welcome.jsp" type="submit" name="action">Home
                    <i class="material-icons right">send</i>
                </button>
                <button class="btn waves-effect waves-light" onclick=location.href="Login.jsp" type="submit" name="action">Logout
                    <i class="material-icons right">send</i>
                </button>
                <h4>Search all available rides</h4>
                
                
            </div>
            <form class="col s12" action="SearchRides" method="post">
                <div class="input-field col s12">
                    <select class = "browser-default" name="selected">
                        <option value = "" disabled selected>Select Option</option>
                        <option value = "Available">Available</option>
                        <option value = "Requested">Requested</option>  
                    </select>
                </div>
                <div class="input-field col s6">
                    <button class="btn btn-large btn-register waves-effect waves-light" type="submit" name="action">Submit
                        <i class="material-icons right">done</i>
                    </button>
                </div>
            </form>
            
            <div class="input-field col s6">
                <table class = "striped bordered">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Origin</th>
                            <th>Destination</th>
                            <th>Date</th>
                            <th>Time</th>
                            <th>Seats</th>
                            <th>Contacts</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    
                    <tbody>
                        <%  
                 // retrieve your list from the request, with casting 
                ArrayList<RideObject> list = (ArrayList<RideObject>) request.getAttribute("list");
//                try{
                    if(list!= null && !list.isEmpty())
                    {

                   // print the information about every category of the list
                              for(RideObject rideObject : list) { %>
                              <tr>
                            <td><%out.println(rideObject.getName());%></td>
                            <td><%out.println(rideObject.getOrigin());%></td>
                            <td><%out.println(rideObject.getDestination());%></td>
                            <td><%out.println(rideObject.getDate());%></td>
                            <td><%out.println(rideObject.getTime());%></td>
                            <td><%out.println(rideObject.getSeats());%></td>
                            <td><%out.println(rideObject.getContact());%></td>
                            <td>
                                
                               <%
                                
                                    if (!rideObject.getStatus().equals("booked")&& !rideObject.getStatus().equals("request")) {
                                %>
                                <form action="SearchRides" method="post">
                                    <input type="hidden"  name="ride_id" id="ride_id" value="<%out.println(rideObject.getId());%>" />
                                    <input type="submit" class="btn" name="bookride" id="bookride" value="Book Ride" />
                                </form>
                                <%
                                    } else {
                                      out.println(rideObject.getStatus().toUpperCase());
                                    }
                                %>
                            </td>
                        </tr>
                        <%
//                                  out.println(rideObject.getName());
//                                  out.println(rideObject.getOrigin());
//                                  out.println(rideObject.getDestination());
//                                  out.println(rideObject.getDate());
//                                  out.println(rideObject.getTime());
//                                  out.println(rideObject.getSeats());
//                                  out.println(rideObject.getContact());
//                                  out.println("<br/>");
                              }
                    }
//                }
//                catch(Exception e)
//                {
//                    out.println(e.getMessage());
//                }
            %>             
                    </tbody>
                </table>
            </div>
            
        </div>
    </body>
</html>
