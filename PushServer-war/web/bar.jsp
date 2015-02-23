<%-- 
    Document   : bar
    Created on : Feb 21, 2015, 7:09:45 PM
    Author     : krzysztof
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ page import="java.io.*,java.util.*" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bar</title>
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>
        <script type="text/javascript" src="http://jquery-json.googlecode.com/files/jquery.json-2.2.min.js"></script>
        <script type="text/javascript">
            function createAlcohol(button, alcoholType) {
                var bar = document.getElementById('welcome').getAttribute('title');
                var alcohol = button.value;
                $.post('AlcoholMakerServlet', {bar: bar, alcohol: alcohol, alcoholType: alcoholType}, function(data) {
                    $('#recipe').empty();
                    var events = data.events;
                    for (var i in events) {
                        $('#recipe').append('<span>' + events[i] + '</span><br>');
                    }
                });
            }
        </script>
    </head>
    <body>
        <center>
            <h1 id="welcome" title="<%= (String) request.getParameter("bar") %>">Witaj w <%= (String) request.getParameter("bar") %>!</h1>
            
            <h2>Przygotuj napoj:</h2>

            <h3>Piwa:</h3>
            <div id="beers">
                <%
                    LinkedList<String> beerNames = (LinkedList<String>) request.getAttribute("beers");
                    Iterator<String> it = beerNames.iterator();
                    while(it.hasNext()) {
                        String paramName = it.next();
                        out.println("<button id=\"" + paramName + "\" value=\"" + paramName + "\" onclick=\"createAlcohol(this, 'beer');\">" + paramName + "</button><br>");
                    }
                %>      
            </div>
            
            <h3>Drinki:</h3>
            <div id="drinks">
                <%
                    LinkedList<String> drinkNames = (LinkedList<String>) request.getAttribute("drinks");
                    Iterator<String> iter = drinkNames.iterator();
                    while(iter.hasNext()) {
                        String paramName = iter.next();
                        out.println("<button id=\"" + paramName + "\" value=\"" + paramName + "\" onclick=\"createAlcohol(this, 'drink');\">" + paramName + "</button><br>");
                    }
                %>
            </div>
            
            <h3>Przepis na napoj:</h3>
            <div id="recipe" style="font-family: monospace;">
                
            </div>
            
        </center>
    </body>
</html>
