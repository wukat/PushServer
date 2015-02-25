<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.io.*,java.util.*" %>
<%@ page import="Consts.MagicStrings" %>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%= (String) request.getParameter(MagicStrings.BAR)%></title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/modern-business.css">
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>
        <script type="text/javascript" src="http://jquery-json.googlecode.com/files/jquery.json-2.2.min.js"></script>
        <script type="text/javascript">
            function createAlcohol(button, alcoholType) {
                var alcohol = button.value;
                $.post('AlcoholMakerServlet', {alcohol: alcohol, alcoholType: alcoholType}, function(data) {
                    $('#recipe').empty();
                    var recipe = data.recipe;
                    for (var i in recipe) {
                        $('#recipe').append('<li class=\"list-group-item\"><span>' + recipe[i] + '</span></li>');
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
                while (($('#orders').children().length) + toInsert > 5) {
                    $('#orders').find(':first-child').remove();
                }
                for (var i in orders) {
                    if (orders[i].indexOf("brak") > -1) {
                        $('#orders').append('<li class=\"list-group-item\" style="color: red">' + orders[i] + '</li>');
                    } else {
                        $('#orders').append('<li class=\"list-group-item\">' + orders[i] + '</li>');
                    }
                }
            }
        </script>
    </head>
    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#"><%= (String) request.getParameter(MagicStrings.BAR)%> wita!</a>
                </div>
            </div>
        </nav>

        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Panel barmana</h1>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4">
                    <div class="panel panel-default text-center">
                        <div class="panel-heading">
                            <h3 class="panel-title">Piwa</h3>
                        </div>
                        <ul class="list-group">
                            <%
                                LinkedList<String> beerNames = (LinkedList<String>) request.getAttribute(MagicStrings.BEERS);
                                Iterator<String> it = beerNames.iterator();
                                while (it.hasNext()) {
                                    String paramName = it.next();
                                    out.println("<li class=\"list-group-item\"><button type=\"button\" class=\"btn btn-default btn-block\" id=\"" + paramName + "\" value=\"" + paramName + "\" onclick=\"createAlcohol(this, 'beer');\">" + paramName + "</button></li>");
                                }
                            %>  
                        </ul>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="panel panel-default text-center">
                        <div class="panel-heading">
                            <h3 class="panel-title">Drinki</h3>
                        </div>
                        <ul class="list-group">
                            <%
                                LinkedList<String> drinkNames = (LinkedList<String>) request.getAttribute(MagicStrings.DRINKS);
                                Iterator<String> iter = drinkNames.iterator();
                                while (iter.hasNext()) {
                                    String paramName = iter.next();
                                    out.println("<li class=\"list-group-item\"><button type=\"button\" class=\"btn btn-default btn-block\" id=\"" + paramName + "\" value=\"" + paramName + "\" onclick=\"createAlcohol(this, '" + MagicStrings.DRINK + "');\">" + paramName + "</button></li>");
                                }
                            %>
                        </ul>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="panel panel-default text-center">
                        <div class="panel-heading">
                            <h3 class="panel-title">Obserwuj bary</h3>
                        </div>
                        <ul class="list-group">
                            <li class="list-group-item">
                                <div class="checkbox">
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
                                </div>
                            </li>
                            <li class="list-group-item">
                                <button type="button" class="btn btn-default" value="Potwierdz" onclick="subscribe();">Potwierdź!</button>  
                            </li>                </ul>

                    </div>
                </div>
            </div>


            <div class="row">
                <div class=" col-md-5">
                    <div class="panel panel-default text-left">
                        <div class="panel-heading">
                            <h3 class="panel-title">Przepis na napoj</h3>
                        </div>
                        <ul class="list-group" id="recipe">

                        </ul>
                    </div>
                </div>

                <div class=" col-md-7">
                    <div class="panel panel-default text-left">
                        <div class="panel-heading">
                            <h3 class="panel-title">Ostatnio zrealizowane zamowienia</h3>
                        </div>
                        <ul class="list-group" id="orders">

                        </ul>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
