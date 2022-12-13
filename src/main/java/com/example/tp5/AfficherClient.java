package com.example.tp5;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import utilities.GestionAubergeInn;
import tuples.*;
import utilities.IFT287Exception;

import java.io.PrintWriter;
import java.util.List;

import static java.lang.Integer.parseInt;

@WebServlet(name = "afficherClient", value = "/afficherClient")
public class AfficherClient extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/CreerClient.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            AubergInnHelper.creerGestionnaire(getServletContext(), session);

            String idClient = request.getParameter("idClient");
            if(idClient == null || idClient == ""){
                throw new IFT287Exception("Le idClient ne peux pas être vide");
            }

            GestionAubergeInn gestion = (GestionAubergeInn) request.getSession().getAttribute("gestion");
            List<TupleClientReservations> client = gestion.transactionClient().afficherClient(Integer.parseInt(idClient));

            String table = "";


            for(TupleClientReservations tuple : client){
                table = table + "<tr>";
                table = table + "<td>"+tuple.getPrenom()+"</td>";
                table = table + "<td>"+tuple.getNom()+"</td>";
                table = table + "<td>"+tuple.getAge()+"</td>";
                table = table + "<td>"+tuple.getDateDebut()+"</td>";
                table = table + "<td>"+tuple.getDateFin()+"</td>";
                table = table + "<td>"+tuple.getNomDeLachambre()+"</td>";
                table = table + "<td>"+tuple.getTypeDeLit()+"</td>";
                table = table + "<td>"+tuple.getPrixReservation()+"</td>";
                table = table + "</tr>";
            }
            request.setAttribute("table",table);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/CreerClient.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
