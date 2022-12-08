package com.example.tp5;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import utilities.*;
import tuples.*;
import java.util.List;
@WebServlet(name = "afficherChambre", value = "/afficherChambre")
public class AfficherChambre extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/afficherChambre.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idChambre = (int) request.getAttribute("idChambre");
        GestionAubergeInn gestion = (GestionAubergeInn)  request.getSession().getAttribute("gestion");
        //TupleChambre chambre = gestion.transactionChambre().getChambre(idChambre);
        //List<TupleCommodite> liste = gestion.transactionChambre().getCommodites(idChambre);
        //System.out.println("\n"+chambre.toString());
        //for(TupleCommodite t:liste) {
         //   System.out.println(t.toString());
       // }
    }
}
