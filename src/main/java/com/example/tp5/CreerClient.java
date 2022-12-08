package com.example.tp5;

import utilities.GestionAubergeInn;
import utilities.IFT287Exception;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "CreerClient", value = "/CreerClient")
public class CreerClient extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/CreerClient.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{

            HttpSession session = request.getSession();
            AubergInnHelper.creerGestionnaire(getServletContext(), session);


            String idClient = request.getParameter("idClient");
            if(idClient == null || idClient == ""){
                throw new IFT287Exception("Le idClient ne peux pas être vide");
            }
            String prenom = request.getParameter("prenom");
            if(prenom == null || prenom == ""){
                throw new IFT287Exception("Le prenom ne peux pas être vide");
            }
            String nom = request.getParameter("nom");
            if(nom == null || nom == ""){
                throw new IFT287Exception("Le nom ne peux pas être vide");
            }
            String age = request.getParameter("age");
            if(age == null || age == ""){
                throw new IFT287Exception("L'age ne peux pas être vide");
            }


            GestionAubergeInn gestion = (GestionAubergeInn) request.getSession().getAttribute("gestion");
            gestion.transactionClient().ajouterClient(Integer.parseInt(idClient), prenom, nom, Integer.parseInt(age));

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/CreerClient.jsp");
            dispatcher.forward(request, response);
        }
        catch (Exception e)
        {
            List<String> listeMessageErreur = new LinkedList<String>();
            listeMessageErreur.add(e.getMessage());
            request.setAttribute("listeMessageErreur", listeMessageErreur);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/CreerClient.jsp");
            dispatcher.forward(request, response);
            // pour d�boggage seulement : afficher tout le contenu de l'exception
            e.printStackTrace();
        }
    }
}
