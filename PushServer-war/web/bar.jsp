<%-- 
    Document   : bar
    Created on : Feb 21, 2015, 7:09:45 PM
    Author     : krzysztof
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bar</title>
    </head>
    <body>
        <center>
            <h1>Witaj w <%= (String) request.getParameter("bar") %>!</h1>
            
            <h2>Przygotuj napoj:</h2>

            <h3>Piwa:</h3>
            <div id="beers">
                
            </div>
            
            <h3>Drinki:</h3>
            <div id="drinks">
                
            </div>
            
        </center>
    </body>
</html>
