package com.example.tp5;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import utilities.*;
@WebServlet(name = "supprimerChambre", value = "/supprimerChambre")
public class SupprimerChambre extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/afficherChambre.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // GestionAubergeInn gestion = (GestionAubergeInn)  request.getSession().getAttribute("gestion");
        //gestion.transactionChambre().supprimerChambre(idChambre);
    }
}