package com.example.tp5;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import utilities.*;
import tuples.*;
import java.sql.SQLException;
import java.util.List;
@WebServlet(name = "afficherChambresLibres", value = "/afficherChambresLibres")
public class AfficherChambresLibres extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/afficherChambre.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*GestionAubergeInn gestion = (GestionAubergeInn)  request.getSession().getAttribute("gestion");
        List<TupleChambre> liste = gestion.transactionChambre().ChambresLibres();
        System.out.println();
        for(TupleChambre c:liste) {
            System.out.println(c.toString());
        }*/
    }
}
