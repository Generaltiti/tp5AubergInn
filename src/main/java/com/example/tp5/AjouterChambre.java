package com.example.tp5;

import utilities.GestionAubergeInn;
import utilities.IFT287Exception;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "ajouterChambre", value = "/ajouterChambre")
public class AjouterChambre extends HttpServlet{
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
            String nom_de_la_chambre = request.getParameter("nom_de_la_chambre");
            if(nom_de_la_chambre == null || nom_de_la_chambre == ""){
                throw new IFT287Exception("Le nom de la chambre ne peux pas être vide");
            }
            String type_de_lit = request.getParameter("type_de_lit");
            if(type_de_lit == null || type_de_lit == ""){
                throw new IFT287Exception("Le type de lit ne peux pas être vide");
            }
            String prix = request.getParameter("prix");
            if(prix == null || prix == ""){
                throw new IFT287Exception("Le prix ne peux pas être vide");
            }


            GestionAubergeInn gestion = (GestionAubergeInn) request.getSession().getAttribute("gestion");
            gestion.transactionChambre().ajouterChambre(Integer.parseInt(idChambre), nom_de_la_chambre, type_de_lit, Integer.parseInt(prix));

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
