package gestionnaire;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

import utilities.Connexion;

import static java.lang.System.currentTimeMillis;

public class GestionnaireReservation{
    private final Connexion connexion;

    private final PreparedStatement stmtPeutReserver;
    private final PreparedStatement stmtReserver;

    public GestionnaireReservation(Connexion connexion) throws SQLException{
        this.connexion = connexion;

        stmtReserver = connexion.getConnection().prepareStatement(
            "INSERT INTO reservation(IdClient, IdChambre, DateDebut, DateFin) VALUES (?,?,?,?)"
        );

        stmtPeutReserver = connexion.getConnection().prepareStatement(
            "SELECT Reservationid FROM reservation WHERE IdChambre = ? AND DateDebut >= ? AND DateFin <= ?"
        );
    }

    public Boolean peutReserver(int idChambre, Date dateDebut, Date dateFin) throws SQLException{
        stmtPeutReserver.setInt(1, idChambre);
        stmtPeutReserver.setDate(2, dateDebut);
        stmtPeutReserver.setDate(3, dateFin);
        ResultSet rset = stmtPeutReserver.executeQuery();
        boolean peutReserver = !rset.next();//S'il y a des réservations dans la plage horaire ->ne peut pas réserver
        rset.close();
        if(dateDebut.compareTo(new Date(currentTimeMillis())) < 0){
            peutReserver = false;
        }
        return peutReserver;
    }

    public void reserver(int idClient, int idChambre, Date dateDebut, Date dateFin) throws SQLException{
        stmtReserver.setInt(1, idClient);
        stmtReserver.setInt(2, idChambre);
        stmtReserver.setDate(3, dateDebut);
        stmtReserver.setDate(4, dateFin);
        stmtReserver.executeUpdate();
    }
    
    public Connexion getConnexion(){
        return connexion;
    }
}