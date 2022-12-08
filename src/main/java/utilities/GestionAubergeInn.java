package utilities;

import java.sql.SQLException;

import gestionnaire.GestionnaireChambre;
import gestionnaire.GestionnaireClient;
import gestionnaire.GestionnaireCommodite;
import gestionnaire.GestionnaireCommoditeChambre;
import gestionnaire.GestionnaireReservation;
import transactions.TransactionChambre;
import transactions.TransactionClient;
import transactions.TransactionCommodite;
import transactions.TransactionCommoditeChambre;
import transactions.TransactionReservation;

public class GestionAubergeInn {
    private final Connexion connexion;
    private final TransactionClient clients;
    private final TransactionCommodite commodites;
    private final TransactionChambre chambre;
    private final TransactionCommoditeChambre commoditechambre;
    private final TransactionReservation reservation;

    public GestionAubergeInn (String serveur, String bd, String user, String password)
            throws IFT287Exception, SQLException
    {
        // Allocation des objets pour le traitement des transactions
        connexion = new Connexion(serveur, bd, user, password);
        clients = new TransactionClient(new GestionnaireClient(connexion));
        commodites = new TransactionCommodite(new GestionnaireCommodite(connexion));
        chambre = new TransactionChambre(new GestionnaireChambre(connexion));
        commoditechambre = new TransactionCommoditeChambre(new GestionnaireCommoditeChambre(connexion),chambre.getGestionnaireChambre(),commodites.getGestionnaireCommodite());
        reservation = new TransactionReservation(new GestionnaireReservation(connexion),new GestionnaireClient(connexion),new GestionnaireChambre(connexion));
    }

    public void fermer() throws SQLException{
        connexion.fermer();
    }

    public TransactionClient transactionClient(){
        return clients;
    }

    public Connexion getConnexion(){
        return connexion;
    }

    public TransactionCommodite transactionCommodites() {
        return commodites;
    }

    public TransactionChambre transactionChambre() {
        return chambre;
    }


    public TransactionCommoditeChambre transactionCommoditechambre() {
        return commoditechambre;
    }

    public TransactionReservation transactionReservation() {
        return reservation;
    }
    
}
