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

@WebServlet
public class BarServlet extends HttpServlet implements MagicStrings {
    
    @Inject
    private Barman barman;

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
        return "BarServlet";
    }

}
