package transactions;

import java.sql.SQLException;
import java.util.List;

import utilities.Connexion;
import utilities.IFT287Exception;
import gestionnaire.GestionnaireClient;
import tuples.TupleClientReservations;

public class TransactionClient {
    private final GestionnaireClient client;
    private final Connexion connexion;

    public TransactionClient(GestionnaireClient client){
        this.connexion = client.getConnexion();
        this.client = client;
    }

    public void ajouterClient(int id,String nom, String prenom, int age) throws Exception{
        try{
            if(client.existe(id)){
                throw new IFT287Exception("Ce client existe déjà: " +id);
            }
    
            client.ajouterClient(id, nom, prenom, age);
            connexion.commit();
        }catch(Exception e){
            connexion.rollback();
            throw e;
        }
    }

    public void supprimerClient(int id) throws Exception{
        try{
            if(!client.existe(id)){
                throw new IFT287Exception("Ce client n'existe pas: " + id);
            }
            if(client.reservationsfutures(id)==0) {
                client.supprimerReservations(id);
                client.supprimerClient(id);
                connexion.commit();
            }
            else {
                throw new SQLException("ce client a des reservations futures");
            }
            
        }catch(Exception e){
            connexion.rollback();
            throw e;
        }
    }

    public List<TupleClientReservations> afficherClient(int id) throws Exception{
        try{
            if(!client.existe(id)){
                throw new IFT287Exception("Ce client n'existe pas: " + id);
            }

            List<TupleClientReservations> liste = client.afficherClient(id);
            connexion.commit();
            return liste;
        }catch(Exception e){
            connexion.rollback();
            throw e;
        }
    }
 }
