package com.example.tp5;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import utilities.*;
@WebServlet(name = "inclureCommodite", value = "/inclureCommodite")
public class InclureCommodite extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/afficherChambre.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{

            HttpSession session = request.getSession();
            AubergInnHelper.creerGestionnaire(getServletContext(), session);


            String idChambre = request.getParameter("idChambre");
            if(idChambre == null || idChambre == ""){
                throw new IFT287Exception("Le idChambre ne peux pas être vide");
            }
            String idCommodite = request.getParameter("idCommodite");
            if(idCommodite == null || idCommodite == ""){
                throw new IFT287Exception("Le idCommodite ne peux pas être vide");
            }

            GestionAubergeInn gestion = (GestionAubergeInn) request.getSession().getAttribute("gestion");
            gestion.transactionCommoditechambre().inclureCommodite(Integer.parseInt(idChambre), Integer.parseInt(idCommodite));

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/afficherChambre.jsp");
            dispatcher.forward(request, response);
        }
        catch (Exception e)
        {
            List<String> listeMessageErreur = new LinkedList<String>();
            listeMessageErreur.add(e.getMessage());
            request.setAttribute("listeMessageErreur", listeMessageErreur);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/afficherChambre.jsp");
            dispatcher.forward(request, response);
            // pour d�boggage seulement : afficher tout le contenu de l'exception
            e.printStackTrace();
        }
    }
}
