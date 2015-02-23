/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Bar.Barman;
import Bar.Order;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.collections4.queue.CircularFifoQueue;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author krzysztof
 */
public class AlcoholMakerServlet extends HttpServlet {

    @Inject
    private Barman barman;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String barName = request.getParameter("bar");
        String alcohol = request.getParameter("alcohol");
        String alcoholType = request.getParameter("alcoholType");
        LinkedList<String> recipe;
        LinkedList<String> orders;

        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("application/json");
        recipe = barman.placeOrder(alcoholType, alcohol);
        orders = barman.getOrdersList();
        for (String a : orders) {
            System.out.println(a);
        }
        try (PrintWriter out = response.getWriter()) {
            out.write(new JSONObject()
                    .put("recipe", new JSONArray(recipe))
                    .put("orders", new JSONArray(orders))
                    .toString());
        } catch (JSONException e) {
            throw new ServletException(e.getMessage(), e);
        }
        response.getWriter().flush();
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
