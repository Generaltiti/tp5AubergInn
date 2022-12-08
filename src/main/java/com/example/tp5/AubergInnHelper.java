package com.example.tp5;

import utilities.Connexion;
import utilities.GestionAubergeInn;
import utilities.IFT287Exception;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class AubergInnHelper {
    public static void creerGestionnaire(ServletContext c, HttpSession s) throws IFT287Exception, SQLException {

        if(!gestionnairesCrees(s)){
            GestionAubergeInn gestion = new GestionAubergeInn("dinf", "ift287_29db","ift287_29","Veet4tuyoo3h");
            s.setAttribute("gestion", gestion);
        }


    }

    private static boolean gestionnairesCrees(HttpSession session)
    {
        if(session == null)
            return false;
        return session.getAttribute("gestion") != null;
    }

}
