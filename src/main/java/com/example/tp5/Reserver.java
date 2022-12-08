package com.example.tp5;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import utilities.*;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "reserver", value = "/reserver")
public class Reserver extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/afficherChambre.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try{

            HttpSession session = request.getSession();
            AubergInnHelper.creerGestionnaire(getServletContext(), session);


            String idClient = request.getParameter("idClient");
            if(idClient == null || idClient == ""){
                throw new IFT287Exception("Le idClient ne peux pas être vide");
            }
            String idChambre = request.getParameter("idChambre");
            if(idChambre == null || idChambre == ""){
                throw new IFT287Exception("Le idChambre ne peux pas être vide");
            }
            String debut = request.getParameter("debut");
            if(debut == null || debut == ""){
                throw new IFT287Exception("La date de debut ne peux pas être vide");
            }
            String fin = request.getParameter("fin");
            if(fin == null || fin == ""){
                throw new IFT287Exception("La date de fin ne peux pas être vide");
            }


            GestionAubergeInn gestion = (GestionAubergeInn) request.getSession().getAttribute("gestion");
            gestion.transactionReservation().reserver(Integer.parseInt(idClient),Integer.parseInt(idChambre),Date.valueOf(debut),Date.valueOf(fin));

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
