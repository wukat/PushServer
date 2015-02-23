/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlets;

import Bar.BarLocal;
import Bar.Barman;
import Consts.MagicStrings;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author krzysztof
 */
@WebServlet
public class BarServlet extends HttpServlet implements MagicStrings {
    
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
        
        BarLocal barLocal;

        if (request.getParameter(BAR) == null) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(INDEX_SITE);
            dispatcher.include(request, response);
            return;
        }
        
        try {
            InitialContext ctx  = new InitialContext();
            barLocal = (BarLocal) ctx.lookup(EJB_PATH 
                    + request.getParameter(BAR).replaceAll("\\s+",""));
        } catch (NamingException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, EXCEPTION_CAUGHT, e);
            RequestDispatcher dispatcher = getServletContext()
                    .getRequestDispatcher(INDEX_SITE);
            dispatcher.include(request, response);
            return;
        }
        
        barman.setBar(barLocal);
        barman.register(barLocal.getBarName());
        request.setAttribute(BEERS, barLocal.getBeers());
        request.setAttribute(DRINKS, barLocal.getDrinks());
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(BAR_SITE);
        dispatcher.include(request, response);
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
