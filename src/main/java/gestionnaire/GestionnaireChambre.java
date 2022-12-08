package gestionnaire;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utilities.Connexion;
import tuples.TupleCommodite;
import tuples.TupleChambre;

public class GestionnaireChambre{
    private final PreparedStatement stmtajouterChambre;
    private final PreparedStatement stmtsupprimerChambre;
    private final PreparedStatement stmtafficherChambresLibres;
    private final PreparedStatement stmtafficherChambre;
    private final PreparedStatement stmtexistes;
    private final PreparedStatement stmtreservationsfutures;
    private final PreparedStatement stmtcommoditesincluses;
    private final PreparedStatement stmtdeleteReservations;
    private final PreparedStatement stmtremoveCommodites;

    private final Connexion conn;

    public GestionnaireChambre(Connexion conn) throws SQLException {
        this.conn = conn;

        stmtajouterChambre = conn.getConnection().prepareStatement(
            "INSERT INTO Chambre (IdChambre,NomDeLaChambre,TypeDeLit,PrixDeBase) VALUES (?,?,?,?)"
        );
        stmtsupprimerChambre = conn.getConnection().prepareStatement(
            "DELETE FROM Chambre WHERE idchambre = ?"
        );
        stmtafficherChambresLibres = conn.getConnection().prepareStatement(
                "SELECT idChambre , NomDeLaChambre, TypeDeLit, PrixDeBase+sum(commodite.surplus_prix) AS Prix FROM Chambre NATURAL JOIN CommoditeChambre NATURAL JOIN Commodite WHERE (SELECT Count(*) FROM reservation WHERE NOW() < DateFin) = 0 GROUP BY idChambre"
        );
        stmtafficherChambre = conn.getConnection().prepareStatement(
            "SELECT IDChambre, NomDeLaChambre, TypeDeLit, PrixDeBase FROM Chambre WHERE IdChambre = ?"
        );
        stmtexistes = conn.getConnection().prepareStatement(
            "SELECT * FROM Chambre WHERE IdChambre = ?"
        );
        stmtreservationsfutures = conn.getConnection().prepareStatement(
            "SELECT Count(*) as nombre FROM Reservation WHERE idChambre = ? AND NOW() < DateFin"
        );
        stmtcommoditesincluses = conn.getConnection().prepareStatement(
            "SELECT IdCommodite, Surplus_prix, Description FROM Commodite NATURAL JOIN CommoditeChambre WHERE IdChambre = ?"
        );
        stmtdeleteReservations = conn.getConnection().prepareStatement(
             "DELETE FROM Reservation WHERE IdChambre = ?"
        );
        stmtremoveCommodites = conn.getConnection().prepareStatement(
                "DELETE FROM commoditeChambre WHERE IdChambre = ?"
        );

    }
    public Boolean existe(int id) throws SQLException{
        stmtexistes.setInt(1, id);
        ResultSet rset = stmtexistes.executeQuery();
        Boolean aRetourner = rset.next();
        rset.close();
        return aRetourner;
    }

    public int reservationsfutures(int id) throws SQLException{
        stmtreservationsfutures.setInt(1,id);
        ResultSet rset = stmtreservationsfutures.executeQuery();
        rset.next();
        int result = rset.getInt("nombre");
        rset.close();
        return result;
    }

    public List<TupleCommodite> commoditeincluses(int idChambre) throws SQLException {
        List<TupleCommodite> returnlist = new ArrayList<TupleCommodite>();
        stmtcommoditesincluses.setInt(1,idChambre);
        ResultSet rset = stmtcommoditesincluses.executeQuery();
        while(rset.next()){
            int IdCommodite = rset.getInt("IdCommodite");
            float Surplus_prix = rset.getFloat("Surplus_prix");
            String Description = rset.getString("Description");
            TupleCommodite commodite = new TupleCommodite(IdCommodite, Surplus_prix, Description);
            returnlist.add(commodite);
        }
        rset.close();
        return returnlist;
    }

    public TupleChambre getChambre(int idChambre) throws SQLException{
        stmtafficherChambre.setInt(1, idChambre);
        ResultSet rset = stmtafficherChambre.executeQuery();
        rset.next();
        int id = rset.getInt("IdChambre");
        String nom = rset.getString("NomDeLaChambre");
        String type = rset.getString("TypeDeLit");
        float prix = rset.getFloat("PrixDeBase");

        TupleChambre chambre = new TupleChambre(id, nom, type, prix);
        rset.close();
        return chambre;
    }

    public void supprimerChambre(int idChambre) throws SQLException{
        stmtsupprimerChambre.setInt(1, idChambre);
        stmtsupprimerChambre.executeUpdate();
    }
    
    public void supprimerReservations(int idChambre) throws SQLException{
        stmtdeleteReservations.setInt(1, idChambre);
        stmtdeleteReservations.executeUpdate();
    }
    
    public void supprimerCommodites(int idChambre) throws SQLException{
        stmtremoveCommodites.setInt(1, idChambre);
        stmtremoveCommodites.executeUpdate();
    }

    public void addChambre(int idChambre, String nom, String type, float prix) throws SQLException{
        stmtajouterChambre.setInt(1, idChambre);
        stmtajouterChambre.setString(2, nom);
        stmtajouterChambre.setString(3, type);
        stmtajouterChambre.setFloat(4, prix);
        stmtajouterChambre.executeUpdate();

    }

    public List<TupleChambre> chambresLibres() throws SQLException {
        List<TupleChambre> returnlist = new ArrayList<TupleChambre>();
        ResultSet rset = stmtafficherChambresLibres.executeQuery();
        while(rset.next()){ 
            int Id = rset.getInt("IdChambre");
            String NomDeLaChambre = rset.getString("NomDeLaChambre");
            String TypeDeLit = rset.getString("TypeDeLit");
            float Prix = rset.getFloat("Prix");           
            TupleChambre chambre = new TupleChambre(Id,NomDeLaChambre,TypeDeLit,Prix);
            returnlist.add(chambre);
        }
        rset.close();
        return returnlist;
    }

    public Connexion getConnexion() {
        return this.conn;
    }

}