import java.sql.SQLException;

import AubergeInn.gestionnaire.GestionnaireChambre;
import AubergeInn.gestionnaire.GestionnaireClient;
import AubergeInn.gestionnaire.GestionnaireCommodite;
import AubergeInn.gestionnaire.GestionnaireCommoditeChambre;
import AubergeInn.gestionnaire.GestionnaireReservation;
import AubergeInn.transactions.TransactionChambre;
import AubergeInn.transactions.TransactionClient;
import AubergeInn.transactions.TransactionCommodite;
import AubergeInn.transactions.TransactionCommoditeChambre;
import AubergeInn.transactions.TransactionReservation;

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
