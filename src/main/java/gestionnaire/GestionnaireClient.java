package gestionnaire;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import AubergeInn.Connexion;
import AubergeInn.tuples.TupleClientReservations;

public class GestionnaireClient{
    private final PreparedStatement stmtAjouterClient;
    private final PreparedStatement stmtSupprimerClient;
    private final PreparedStatement stmtAfficherClient;
    private final PreparedStatement stmtExiste;
    private final PreparedStatement stmtreservationsfutures;
    private final PreparedStatement stmtdeleteReservations;

    private final Connexion connexion;
    

    public GestionnaireClient(Connexion connexion) throws SQLException{
        this.connexion = connexion;

        stmtExiste = connexion.getConnection().prepareStatement(
            "SELECT * FROM Client WHERE idClient = ?");

        stmtAjouterClient = connexion.getConnection().prepareStatement(
            "INSERT INTO Client (IdClient,Nom, Prenom, Age) VALUES (?,?,?,?)"
        );

        stmtSupprimerClient = connexion.getConnection().prepareStatement(
            "DELETE FROM Client WHERE idClient = ?"
        );

        stmtAfficherClient = connexion.getConnection().prepareStatement(
                "SELECT Prenom, Nom, Age,dateDebut, datefin,nomDeLaChambre, typeDeLit, PrixDeBase + (SELECT SUM(Surplus_prix) FROM reservation INNER JOIN chambre ON chambre.idchambre = reservation.idchambre INNER JOIN commoditechambre ON commoditechambre.idchambre = chambre.idchambre INNER JOIN commodite ON commodite.idcommodite = commoditechambre.idcommodite WHERE client.idclient = ?) AS PrixReservation   FROM client INNER JOIN reservation r ON r.idclient = client.idclient INNER JOIN chambre ON chambre.idchambre = r.idchambre WHERE client.idclient = ?"
        );
        stmtreservationsfutures = connexion.getConnection().prepareStatement(
            "SELECT Count(*) as nombre FROM Reservation WHERE idClient = ? AND NOW() < DateFin"
        );
        stmtdeleteReservations = connexion.getConnection().prepareStatement(
                "DELETE FROM Reservation WHERE IdClient = ?"
        );
    }
    public boolean existe(int id) throws SQLException{
        stmtExiste.setInt(1,id);
        ResultSet rset = stmtExiste.executeQuery();
        boolean clientExiste = rset.next();
        rset.close();
        return clientExiste;
    }

    public int reservationsfutures(int id) throws SQLException{
        stmtreservationsfutures.setInt(1,id);
        ResultSet rset = stmtreservationsfutures.executeQuery();
        rset.next();
        int result = rset.getInt("nombre");
        rset.close();
        return result;
    }
    
    public void supprimerReservations(int idClient) throws SQLException{
        stmtdeleteReservations.setInt(1, idClient);
        stmtdeleteReservations.executeUpdate();
    }

    public void ajouterClient(int id,String nom, String prenom, int age) throws SQLException{
        stmtAjouterClient.setInt(1, id);
        stmtAjouterClient.setString(2,nom);
        stmtAjouterClient.setString(3, prenom);
        stmtAjouterClient.setInt(4, age);
        stmtAjouterClient.executeUpdate();
    }

    public void supprimerClient(int id) throws SQLException{
        stmtSupprimerClient.setInt(1,id);
        stmtSupprimerClient.executeUpdate();
    }

    public List<TupleClientReservations> afficherClient(int id) throws SQLException{
        stmtAfficherClient.setInt(1, id);
        stmtAfficherClient.setInt(2, id);
        ResultSet rset = stmtAfficherClient.executeQuery();

        List<TupleClientReservations> listeClient = new LinkedList<>();

        while(rset.next()){
            TupleClientReservations tuple= new TupleClientReservations(
                rset.getString("prenom"), rset.getString("nom"), 
                rset.getInt("age"), rset.getDate("dateDebut"), rset.getDate("dateFin"), 
                rset.getString("nomDeLaChambre"), rset.getString("typeDeLit"), rset.getDouble("prixReservation"));

            listeClient.add(tuple);
        }
        rset.close();
        return listeClient;

    }

    public Connexion getConnexion(){
        return connexion;
    }

}