/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlets;

import Bar.BarAbstract;
import Bar.BarLocal;
import Bar.Barman;
import Bar.BarmanLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
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
public class BarServlet extends HttpServlet {
    
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
        //BarmanLocal barman;
        BarLocal bar;
        
        response.setContentType("text/html;charset=UTF-8");
        
//        try {
//            InitialContext ctx  = new InitialContext();
//            barman = (BarmanLocal) ctx.lookup("java:global/PushServer/PushServerEJB/Barman");
//        } catch (NamingException e) {
//            System.out.println(e);
//            return;
//        }
        
        try {
            InitialContext ctx  = new InitialContext();
            bar = (BarLocal) ctx.lookup("java:global/PushServer/PushServerEJB/" + request.getParameter("bar").replaceAll("\\s+",""));
        
        } catch (NamingException e) {
            System.out.println(e);
            return;
        }
        
        System.out.println(bar.getDrinks().get(1) + "DDDDDDDDDDDDDD");
        barman.setBar(bar);
        barman.register(bar.getBarName());
       System.out.println(bar.getDrinks().get(1) + "DDDDDDDDDDDDDD");
        // System.out.println(bar.makeBeer("Jasne"));
       
        request.setAttribute("beers", bar.getBeers());
        request.setAttribute("drinks", bar.getDrinks());
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/bar.jsp");
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
