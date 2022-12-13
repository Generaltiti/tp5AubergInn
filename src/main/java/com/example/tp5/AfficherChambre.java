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
        try {
            HttpSession session = request.getSession();
            AubergInnHelper.creerGestionnaire(getServletContext(), session);

            String idChambre = request.getParameter("idChambre");
            if(idChambre == null || idChambre == ""){
                throw new IFT287Exception("Le idChambre ne peux pas être vide");
            }

            GestionAubergeInn gestion = (GestionAubergeInn) request.getSession().getAttribute("gestion");
            TupleChambre chambre = gestion.transactionChambre().getChambre(Integer.parseInt(idChambre));
            List<TupleCommodite> commodites = gestion.transactionChambre().getCommodites(Integer.parseInt(idChambre));
            String table = "";

            table = table + "<tr>";
            table = table + "<td>"+chambre.id+"</td>";
            table = table + "<td>"+chambre.nom+"</td>";
            table = table + "<td>"+chambre.type+"</td>";
            table = table + "<td>"+chambre.prix+"</td>";
            table = table + "</tr>";

            String tablecommo = "";
            for(TupleCommodite tuple : commodites){
                tablecommo = tablecommo + "<tr>";
                tablecommo = tablecommo + "<td>"+tuple.idCommodite+"</td>";
                tablecommo = tablecommo + "<td>"+tuple.Surplus_prix+"</td>";
                tablecommo = tablecommo + "<td>"+tuple.Description+"</td>";
                tablecommo = tablecommo + "</tr>";
            }

            request.setAttribute("tableChambre",table);
            request.setAttribute("tableCommo",tablecommo);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/afficherChambre.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
