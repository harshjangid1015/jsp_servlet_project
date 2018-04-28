<%-- 
    Document   : Register
    Created on : Apr 26, 2018, 8:39:10 PM
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
                <script src="test.js"></script>
            <script src="registerjs.js"></script>
    </head>
<div class="container">
    <div class="row">
      <h4>Share ride registration form</h4>
        <form class="col s12" action="RiderRegistration" method="post">
          <div class="row">
            <div class="input-field col s6">
              <input name="first_name" type="text" class="validate" required>
              <label for="first_name">First Name</label>
            </div>
            <div class="input-field col s6">
              <input name="last_name" type="text" class="validate" required>
              <label for="last_name">Last Name</label>
            </div>
          </div>
<!--          <div class="row">
            <div class="input-field col s12">
              <input id="email" type="email" class="validate" required>
              <label for="email">Email</label>
            </div>
          </div>-->
          <div class="row">
            <div class="input-field col s12">
              <input name="username" type="text" class="validate" required>
              <label for="username">User Name</label>
            </div>
            <div class="input-field col s12">
              <input name="password" type="password" class="validate" minlength="4" required>
              <label for="password">Password</label>
            </div>
          </div>
          <div class="input-field col s12">
              <input name="contact" type="text" class="validate" minlength="6" required>
              <label for="contact">Contact No</label>
            </div>
          </div>
          <div class="row">
            
    
            <div class="input-field col s6">
              <button class="btn btn-large btn-register waves-effect waves-light" type="submit" name="action">Register
                <i class="material-icons right">done</i>
              </button>
            </div>
          </div>
        </form>
      </div>
      <a title="Login" class="ngl btn-floating btn-large waves-effect waves-light red"><i class="material-icons">input</i></a>
    </div>
</html>  
