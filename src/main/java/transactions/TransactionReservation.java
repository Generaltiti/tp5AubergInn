package transactions;

import java.sql.Date;
import java.sql.SQLException;

import utilities.Connexion;
import utilities.IFT287Exception;
import gestionnaire.GestionnaireChambre;
import gestionnaire.GestionnaireClient;
import gestionnaire.GestionnaireReservation;

public class TransactionReservation {
    private final GestionnaireClient client;
    private final GestionnaireChambre chambre;
    private final GestionnaireReservation reservation;

    private final Connexion connexion;

    public TransactionReservation(GestionnaireReservation reservation, GestionnaireClient client, GestionnaireChambre chambre){
        this.connexion = reservation.getConnexion();
        this.reservation = reservation;
        this.chambre = chambre;
        this.client = client;
    }

    public void reserver(int idClient, int idChambre, Date dateDebut, Date dateFin) throws Exception{
        try{
            if(!client.existe(idClient)){
                throw new IFT287Exception("Ce client n'existe pas: " + idClient);
            }
            if(!chambre.existe(idChambre)){
                throw new IFT287Exception("Cette chambre n'existe pas:" + idChambre);
            }
            if(!reservation.peutReserver(idChambre, dateDebut, dateFin)){
                throw new IFT287Exception("Cette chambre (" + idChambre +") est déjà réservée pour ces dates : " + dateDebut.toString() + "à " + dateFin.toString());
            }

            reservation.reserver(idClient, idChambre, dateDebut, dateFin);
            connexion.commit();
        }   
        catch(Exception e){
            connexion.rollback();
            throw e;
        }
    }
}
