/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author krzysztof
 */
@WebServlet
public class AlcoholMakerServlet extends HttpServlet implements MagicStrings {
    
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
            out.write(new JSONObject()
                    .put(RECIPE, new JSONArray(recipe))
                    .put(ORDERS, new JSONArray(orders))
                    .toString());
        } catch (JSONException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, EXCEPTION_CAUGHT, e);
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
