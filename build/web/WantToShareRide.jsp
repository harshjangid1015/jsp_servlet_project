<%-- 
    Document   : WantToShareRide
    Created on : Apr 27, 2018, 10:43:13 AM
    Author     : harsh
--%>

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
                <script src="requestride.js"></script>
                
    </head>
<div class="container">
    <div class="row">
        <form class="col s12" action="AvailableRideAdd" method="post">
          <h4>Fill the form to share a ride</h4>
          <div class="row">
            <div class="input-field col s12">
              <input name="name" type="text" class="validate" required>
              <label for="name">Name</label>
            </div>
            <div class="input-field col s12">
              <input name="origin" type="text" class="validate" required>
              <label for="origin">Origin</label>
            </div>
            <div class="input-field col s12">
                    <input name="destination" type="text" class="validate" required>
                    <label for="destination">Destination</label>
            </div>
            <div class="input-field col s12">
                    <input name="date" type="date" class="datepicker">
                    <label for="date">Date of Journey</label> 
            </div>
            <div class="input-field col s12">
                    <input name="time" type="time" class="timepicker">
                    <label for="time">Time of Journey</label>
            </div>
            <div class="input-field col s12">  
                <select class = "browser-default" name="seats">
                    <option value = "" disabled selected>Seats Available</option>
                    <option value = "1">1</option>
                    <option value = "2">2</option>
                    <option value = "3">3</option>
                    <option value = "3">4</option>
                 </select>   
        </div>
            <div class="input-field col s12">
                    <input name="contact" type="text" class="validate" required>
                    <label for="contact">Contact No</label>
            </div>
            </div>            
          </div>
    <div class="row">
        <div class="input-field col s6">
              <button class="btn btn-large btn-register waves-effect waves-light" type="submit" name="action">Submit
                <i class="material-icons right">done</i>
              </button>
            </div>
          </div>
        </form>
      </div>
      <a title="Login" class="ngl btn-floating btn-large waves-effect waves-light red"><i class="material-icons">input</i></a>
    </div>
</html>   
