package com.example.tp5;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import utilities.GestionAubergeInn;
import tuples.*;
import java.util.List;

@WebServlet(name = "afficherClient", value = "/afficherClient")
public class AfficherClient extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/afficherChambre.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GestionAubergeInn gestion = (GestionAubergeInn)  request.getSession().getAttribute("gestion");
        int idClient = (int) request.getAttribute("idClient");
        List<TupleClientReservations> clients = null;
        try {
            clients = gestion.transactionClient().afficherClient(idClient);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        for(TupleClientReservations tuple : clients){
            System.out.println("\n"+tuple.getPrenom() + " " + tuple.getNom() + " " + tuple.getAge() + " " + tuple.getDateDebut() + " "
            + tuple.getDateFin() + " " + tuple.getNomDeLachambre() + " " + tuple.getTypeDeLit() + " " + tuple.getPrixReservation());
        }
    }
}
