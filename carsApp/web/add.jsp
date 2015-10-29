<%-- 
    Document   : add
    Created on : Oct 26, 2015, 5:08:12 PM
    Author     : thewagdy
--%>
<link rel="stylesheet" type="text/css" href="./style.css" /> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add a new Car</title>
    </head>
    <body>
        <h1>Add a new Car</h1>

        <form name="addForm" action="addCar" method="get"/>
        <p>
            <label>Car Make</label>
            <input type="text" name="Make" value=""/>
            <br>
        </p>
        <p>

            <label>Car Model</label>
            <input type="text" name="Model" value=""/>
            <br>
        </p>
        <p>
            <label>Car Year</label>
            <input type="text" name="Year" value=""/>
            <br>
        </p>
        <p>
            <label>Car Color</label>
            <input type="text" name="Color" value=""/>
            <br>
        </p>
        <p>

            <input type="submit"  name="submit" value="Submit"/>
        </p>
    </form>
</body>
</html>
