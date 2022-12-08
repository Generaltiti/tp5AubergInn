package com.example.tp5;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import utilities.*;
import java.sql.Date;
@WebServlet(name = "reserver", value = "/reserver")
public class Reserver extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/afficherChambre.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        GestionAubergeInn gestion = (GestionAubergeInn)  request.getSession().getAttribute("gestion");
        int idClient = (int)request.getAttribute("idClient");
        int idChambre = (int)request.getAttribute("idChambre");
        Date debut = (Date)request.getAttribute("debut");
        Date fin = (Date)request.getAttribute("fin");
        try {
            gestion.transactionReservation().reserver(idClient, idChambre, debut, fin);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
