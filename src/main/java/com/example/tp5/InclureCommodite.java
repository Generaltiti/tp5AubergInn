package com.example.tp5;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

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
        //GestionAubergeInn gestion = (GestionAubergeInn)  request.getSession().getAttribute("gestion");int idChambre = readInt(tokenizer);
        int idCommodite = (int)request.getAttribute("idCommodite");

        try {
            //gestion.transactionCommoditechambre().inclureCommodite(idChambre, idCommodite);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}