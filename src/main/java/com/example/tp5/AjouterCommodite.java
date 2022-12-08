package com.example.tp5;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import utilities.GestionAubergeInn;
import utilities.IFT287Exception;

@WebServlet(name = "ajouterCommodite", value = "/ajouterCommodite")
public class AjouterCommodite extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/ajouterCommodite.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{

            HttpSession session = request.getSession();
            AubergInnHelper.creerGestionnaire(getServletContext(), session);


            String idCommodite = request.getParameter("idCommodite");
            if(idCommodite == null || idCommodite == ""){
                throw new IFT287Exception("Le idCommodite ne peux pas être vide");
            }
            String description = request.getParameter("description");
            if(description == null || description == ""){
                throw new IFT287Exception("La description ne peux pas être vide");
            }
            String surplus = request.getParameter("surplus");
            if(surplus == null || surplus == ""){
                throw new IFT287Exception("Le surplus ne peux pas être vide");
            }


            GestionAubergeInn gestion = (GestionAubergeInn) request.getSession().getAttribute("gestion");
            gestion.transactionCommodites().ajouterCommodite(Integer.parseInt(idCommodite),  Float.parseFloat(surplus),description );

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/ajouterCommodite.jsp");
            dispatcher.forward(request, response);
        }
        catch (Exception e)
        {
            List<String> listeMessageErreur = new LinkedList<String>();
            listeMessageErreur.add(e.getMessage());
            request.setAttribute("listeMessageErreur", listeMessageErreur);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/ajouterCommodite.jsp");
            dispatcher.forward(request, response);
            // pour d�boggage seulement : afficher tout le contenu de l'exception
            e.printStackTrace();
        }
    }
}
