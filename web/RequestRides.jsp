<%-- 
    Document   : RequestRides
    Created on : Apr 27, 2018, 10:42:45 AM
    Author     : harsh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Request Ride Page</title>
    </head>
    <body>
        <h1>Fill the form to request a ride</h1>
        <form action="RequestAdd" method="post">
			<table style="with: 50%">
				<tr>
					<td>Name</td>
					<td><input type="text" name="name" /></td>
				</tr>
				<tr>
					<td>Origin</td>
					<td><input type="text" name="origin" /></td>
				</tr>
				<tr>
					<td>Destination</td>
					<td><input type="text" name="destination" /></td>
				</tr>
				<tr>
					<td>Date of Journey</td>
					<td><input type="date"  name="date" /></td>
				</tr>
                                <tr>
					<td>Time of Journey</td>
					<td><input type="time"  name="time" /></td>
				</tr>
                                <tr>
					<td>Seats Required</td>
                                        <td><select name="seats">
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                        <option>4</option>
                                        </select>
                                        </td>
				</tr>    
				<tr>
					<td>Contact No</td>
					<td><input type="text" name="contact" /></td>
				</tr>
                        </table>
			<input type="submit" value="Submit" />
	</form>
    </body>
</html>
