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
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>
        <script type="text/javascript" src="http://jquery-json.googlecode.com/files/jquery.json-2.2.min.js"></script>
        <script type="text/javascript">
            function createAlcohol(button, alcoholType) {
                var bar = document.getElementById('welcome').getAttribute('title');
                var alcohol = button.value;
                $.post('AlcoholMakerServlet', {bar: bar, alcohol: alcohol, alcoholType: alcoholType}, function(data) {
                    $('#recipe').empty();
//                    $('#orders').empty();
                    var recipe = data.recipe;
                    for (var i in recipe) {
                        $('#recipe').append('<span>' + recipe[i] + '</span><br>');
                    }
                    var orders = data.orders;
                    var toInsert = orders.length;
                    while (($('#orders').children().length / 2) + toInsert > 5) {
                        $('#orders').find(':first-child').remove();
                    }
                    for (var i in orders) {
                        $('#orders').append('<span>' + orders[i] + '</span><br>');
                    }
                });
            }
        </script>
    </head>
    <body>
        <div class="row">
            <div class=" col-md-11">
                <h1 id="welcome" title="<%= (String) request.getParameter("bar")%>">Witaj w <%= (String) request.getParameter("bar")%>!</h1>
                <h2>Przygotuj napoj:</h2>
            </div>

            <div id="beers" class=" col-md-3">
                <h3>Piwa:</h3>
                <%
                    LinkedList<String> beerNames = (LinkedList<String>) request.getAttribute("beers");
                    Iterator<String> it = beerNames.iterator();
                    while (it.hasNext()) {
                        String paramName = it.next();
                        out.println("<button type=\"button\" class=\"btn btn-info btn-lg btn-block\" id=\"" + paramName + "\" value=\"" + paramName + "\" onclick=\"createAlcohol(this, 'beer');\">" + paramName + "</button>");

                    }
                %>      
            </div>

            <div id="drinks" class=" col-md-3">
                <h3>Drinki:</h3>
                <%
                    LinkedList<String> drinkNames = (LinkedList<String>) request.getAttribute("drinks");
                    Iterator<String> iter = drinkNames.iterator();
                    while (iter.hasNext()) {
                        String paramName = iter.next();
                        out.println("<button type=\"button\" class=\"btn btn-info btn-lg btn-block\" id=\"" + paramName + "\" value=\"" + paramName + "\" onclick=\"createAlcohol(this, 'drink');\">" + paramName + "</button>");
                    }
                %>
            </div>
            </div>

            <h3>Przepis na napoj:</h3>
            <div id="recipe" style="font-family: monospace;">

            </div>

            <h3>Ostatnio zrealizowane zamowienia:</h3>

            <div id="orders">
        </div>
    </body>
</html>
