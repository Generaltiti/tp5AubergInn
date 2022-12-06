package transactions;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import AubergeInn.Connexion;
import AubergeInn.IFT287Exception;
import AubergeInn.gestionnaire.GestionnaireChambre;
import AubergeInn.gestionnaire.GestionnaireClient;
import AubergeInn.gestionnaire.GestionnaireCommodite;
import AubergeInn.gestionnaire.GestionnaireCommoditeChambre;
import AubergeInn.tuples.TupleClientReservations;

public class TransactionCommoditeChambre {
    private final GestionnaireCommoditeChambre commoditechambre;
    private final GestionnaireChambre chambre;
    private final GestionnaireCommodite commodite;

    private final Connexion connexion;

    public TransactionCommoditeChambre(GestionnaireCommoditeChambre commoditechambre, GestionnaireChambre chambre, GestionnaireCommodite commodite){
        this.connexion = commoditechambre.getConnexion();
        this.commoditechambre = commoditechambre;
        this.chambre = chambre;
        this.commodite = commodite;
    }

    public void inclureCommodite(int idChambre, int idCommodite) throws SQLException{
        try {
            if(chambre.existe(idChambre) && commodite.existe(idCommodite)){
                commoditechambre.inclureCommodite(idChambre, idCommodite);
                connexion.commit();
            }
        }
        catch(Exception e) {
            connexion.rollback();
            throw e;
        }
        
    }

    public void enleverCommodite(int idChambre, int idCommodite) throws SQLException{
        try {
            if(chambre.existe(idChambre) && commodite.existe(idCommodite)){
                commoditechambre.enleverCommodite(idChambre, idCommodite);
                connexion.commit();
            }
        }
        catch(Exception e) {
            connexion.rollback();
            throw e;
        }
        
    }

 }
