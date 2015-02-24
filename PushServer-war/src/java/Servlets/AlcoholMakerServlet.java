package Servlets;

import Bar.Barman;
import Consts.MagicStrings;
import static Consts.MagicStrings.EXCEPTION_CAUGHT;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

@WebServlet
public class AlcoholMakerServlet extends HttpServlet implements MagicStrings {
    
    @Inject
    private Barman barman;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String alcohol = request.getParameter(ALCOHOL);
        String alcoholType = request.getParameter(ALCOHOL_TYPE);
        LinkedList<String> recipe;
        LinkedList<String> orders;
        
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-16LE");
        recipe = barman.placeOrder(alcoholType, alcohol);
        orders = barman.getOrdersList();
        try (PrintWriter out = response.getWriter()) {
            JSONObject json = new JSONObject();
            json.put(RECIPE, new JSONArray(recipe));
            if (orders.size() > 0) {
                json.put(ORDERS, new JSONArray(orders));
            }
            out.write(json.toString());
        } catch (JSONException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, EXCEPTION_CAUGHT, e);
            throw new ServletException(e.getMessage(), e);
        }
        response.getWriter().flush();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "AlcoholMakerServlet";
    }

}
