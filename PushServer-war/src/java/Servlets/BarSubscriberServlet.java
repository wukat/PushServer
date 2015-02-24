package Servlets;

import Bar.Barman;
import Consts.MagicStrings;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
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
public class BarSubscriberServlet extends HttpServlet implements MagicStrings {

    @Inject
    private Barman barman;

    private final LinkedList<String> allBars;

    public BarSubscriberServlet() {
        this.allBars = new LinkedList<>();
        allBars.add(PLEBEIAN_BAR);
        allBars.add(LUXURY_BAR);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        LinkedList<String> orders;
        
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("application/json");
        
        Iterator<String> it = allBars.iterator();
        while (it.hasNext()) {
            String actualBar = it.next();
            if (request.getParameter(actualBar).equals("true")) {
                barman.register(actualBar);
            } else {
                barman.unregister(actualBar);
            }
        }
        
        orders = barman.getOrdersList();
        try (PrintWriter out = response.getWriter()) {
            out.write(new JSONObject()
                    .put(ORDERS, new JSONArray(orders))
                    .toString());
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
        return "Short description";
    }

}
