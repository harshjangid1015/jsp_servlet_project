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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Available Rides Page</title>
    </head>
    <body>
        <a href="Welcome.jsp">Home</a>
        <a href="Login.jsp">Logout</a>
	<br />
        <h1>Search all available or requested rides</h1>
         <br />
        <form action="SearchRides" method="post">
			<table style="with: 50%">
				
                                <tr>
                                        <td>Select Option</td>
                                        <td><select name="selected">
                                        <option></option>
                                        <option>Available</option>
                                        <option>Requested</option>
                                        </select>
                                        </td>
				</tr>    
				
                        </table>
			<input type="submit" value="Submit" />
	</form>
         
         <table border=="1">
            <%  
                 // retrieve your list from the request, with casting 
                ArrayList<RideObject> list = (ArrayList<RideObject>) request.getAttribute("list");
//                try{
                    if(list!= null && !list.isEmpty())
                    {

                   // print the information about every category of the list
                              for(RideObject rideObject : list) {
                                  out.println(rideObject.getName());
                                  out.println(rideObject.getOrigin());
                                  out.println(rideObject.getDestination());
                                  out.println(rideObject.getDate());
                                  out.println(rideObject.getTime());
                                  out.println(rideObject.getSeats());
                                  out.println(rideObject.getContact());
                                  out.println("<br/>");
                              }
                    }
//                }
//                catch(Exception e)
//                {
//                    out.println(e.getMessage());
//                }
            %>
        </table>
    </body>
</html>
