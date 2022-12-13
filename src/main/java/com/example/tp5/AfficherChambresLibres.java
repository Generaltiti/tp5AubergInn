package com.example.tp5;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import utilities.*;
import tuples.*;
import java.sql.SQLException;
import java.util.List;
@WebServlet(name = "afficherChambresLibres", value = "/afficherChambresLibres")
public class AfficherChambresLibres extends HttpServlet{
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


            GestionAubergeInn gestion = (GestionAubergeInn) request.getSession().getAttribute("gestion");
            List<TupleChambre> chambres = gestion.transactionChambre().ChambresLibres();

            String alltable = "";

            for(TupleChambre tuple : chambres){
                alltable = alltable + "<tr>";
                alltable = alltable + "<td>"+tuple.id+"</td>";
                alltable = alltable + "<td>"+tuple.nom+"</td>";
                alltable = alltable + "<td>"+tuple.type+"</td>";
                alltable = alltable + "<td>"+tuple.prix+"</td>";
                alltable = alltable + "</tr>";
            }
            request.setAttribute("tableChambresLibres",alltable);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/afficherChambre.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
