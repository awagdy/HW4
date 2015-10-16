<%-- 
    Document   : read
    Created on : Oct 13, 2015, 8:13:31 PM
    Author     : thewagdy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <% String table = (String) request.getAttribute("table"); %>
    
    <body>
        <h1>Cars Database</h1>
        <%= table %>
    </body>
</html>
