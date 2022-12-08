package com.example.tp5;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import utilities.*;
@WebServlet(name = "supprimerClient", value = "/supprimerClient")
public class SupprimerClient extends HttpServlet{
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

            GestionAubergeInn gestion = (GestionAubergeInn) request.getSession().getAttribute("gestion");
            gestion.transactionClient().supprimerClient(Integer.parseInt(idClient));

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
