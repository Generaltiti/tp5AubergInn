package transactions;

import java.sql.SQLException;

import AubergeInn.Connexion;
import AubergeInn.IFT287Exception;
import AubergeInn.gestionnaire.GestionnaireCommodite;

public class TransactionCommodite {
    private final GestionnaireCommodite commodites;
    private final Connexion connexion;

    public TransactionCommodite(GestionnaireCommodite commodites) {
        this.commodites = commodites;
        this.connexion = commodites.getConnexion();
    }

    public void ajouterCommodite(int id, float surplus, String description) throws Exception{
        try{
            if(commodites.existe(id)){
                throw new IFT287Exception("Cette commodite existe déjà : " + id);
            }
            commodites.ajouterCommodite(id, surplus, description);
            connexion.commit();
        }catch(Exception e){
            connexion.rollback();
            throw e;
        }
    }
    public GestionnaireCommodite getGestionnaireCommodite(){
        return commodites;
    }

}
