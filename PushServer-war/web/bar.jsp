<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.io.*,java.util.*" %>
<%@ page import="Consts.MagicStrings" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bar</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>
        <script type="text/javascript" src="http://jquery-json.googlecode.com/files/jquery.json-2.2.min.js"></script>
        <script type="text/javascript">
            function createAlcohol(button, alcoholType) {
                var alcohol = button.value;
                $.post('AlcoholMakerServlet', {alcohol: alcohol, alcoholType: alcoholType}, function(data) {
                    $('#recipe').empty();
                    var recipe = data.recipe;
                    for (var i in recipe) {
                        $('#recipe').append('<span>' + recipe[i] + '</span><br>');
                    }
                    if (data.hasOwnProperty('orders')) {
                        publicOrders(data.orders);
                    }
                });
            }
            function subscribe() {
                var plebeianBar = document.getElementById("Plebeian Bar").checked;
                var luxuryBar = document.getElementById("Luxury Bar").checked;
                $.post('BarSubscriberServlet', {"Bar Plebejski": plebeianBar, "Bar Luksus": luxuryBar}, function(data) {
                    if (data !== null) {
                        if (data.hasOwnProperty('orders')) {
                            publicOrders(data.orders);
                        }
                    }
                });
            }
            function publicOrders(orders) {
                var toInsert = orders.length;
                while (($('#orders').children().length / 2) + toInsert > 5) {
                    $('#orders').find(':first-child').remove();
                }
                for (var i in orders) {
                    if (orders[i].indexOf("brak") > -1) {
                        $('#orders').append('<span style="color: red">' + orders[i] + '</span><br>');
                    } else {
                        $('#orders').append('<span>' + orders[i] + '</span><br>');
                    }
                }
            }
        </script>
    </head>
    <body>
        <div class="row">
            <div class=" col-md-11">
                <h1 id="welcome" title="<%= (String) request.getParameter(MagicStrings.BAR)%>">Witaj w <%= (String) request.getParameter(MagicStrings.BAR)%>!</h1>

                <h2>Obserwowane bary:</h2>
                <%
                    if (((String) request.getParameter(MagicStrings.BAR)).equals("Plebeian Bar")) {
                        out.println("<input id=\"Plebeian Bar\" type=\"checkbox\" checked=\"checked\" name=\"barOptions\" value=\"Plebeian Bar\">Plebeian Bar<br>");
                    } else {
                        out.println("<input id=\"Plebeian Bar\" type=\"checkbox\" name=\"barOptions\" value=\"Plebeian Bar\">Plebeian Bar<br>");
                    }
                    if (((String) request.getParameter("bar")).equals("Luxury Bar")) {
                        out.println("<input id=\"Luxury Bar\" type=\"checkbox\" checked=\"checked\" name=\"barOptions\" value=\"Luxury Bar\">Luxury Bar<br>");
                    } else {
                        out.println("<input id=\"Luxury Bar\" type=\"checkbox\" name=\"barOptions\" value=\"Luxury Bar\">Luxury Bar<br>");
                    }
                %>
                <button type="button" value="Potwierdz" onclick="subscribe();">Potwierdz</button>             

                <h2>Przygotuj napoj:</h2>
            </div>

            <div id="beers" class=" col-md-3">
                <h3>Piwa:</h3>
                <%
                    LinkedList<String> beerNames = (LinkedList<String>) request.getAttribute(MagicStrings.BEERS);
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
                    LinkedList<String> drinkNames = (LinkedList<String>) request.getAttribute(MagicStrings.DRINKS);
                    Iterator<String> iter = drinkNames.iterator();
                    while (iter.hasNext()) {
                        String paramName = iter.next();
                        out.println("<button type=\"button\" class=\"btn btn-info btn-lg btn-block\" id=\"" + paramName + "\" value=\"" + paramName + "\" onclick=\"createAlcohol(this, '" + MagicStrings.DRINK + "');\">" + paramName + "</button>");
                    }
                %>
            </div>
        </div>

        <div class="row">
            <div class=" col-md-3">
                <h3>Przepis na napoj:</h3>
                <div id="recipe"  style="font-family: monospace;">

                </div>
            </div>

            <div class=" col-md-3">
                <h3>Ostatnio zrealizowane zamowienia:</h3>
                <div id="orders">

                </div>
            </div>
        </div>
    </body>
</html>
