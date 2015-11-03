<!DOCTYPE html>
<link rel="stylesheet" type="text/css" href="./style.css" /> 

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Cars"%>
<% Cars car = (Cars) request.getAttribute("car"); %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update a Car</title>
    </head>
    <body>
        <h1>Update a Car</h1>
        <form name="updateForm" action="updateCar" method="get"/>
        
        <p>
            <label>Car ID</label>
            <input type="text" name="Make" value="<%= car.getCARID() %>"/>
            <br>
        </p>
    
        <p>
            <label>Car Make</label>
            <input type="text" name="Make" value="<%= car.getCARMAKE() %>"/>
            <br>
        </p>
        <p>

            <label>Car Model</label>
            <input type="text" name="Model" value="<%= car.getCARMODEL() %>"/>
            <br>
        </p>
        <p>
            <label>Car Year</label>
            <input type="text" name="Year" value="<%= car.getCARYEAR() %>"/>
            <br>
        </p>
        <p>
            <label>Car Color</label>
            <input type="text" name="Color" value="<%= car.getCARCOLOR() %>"/>
            <br>
        </p>
        <p>

            <input type="submit"  name="submit" value="Update"/>
        </p>
    </form>
    </body>
</html>
