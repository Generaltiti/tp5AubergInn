package transactions;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import AubergeInn.Connexion;
import AubergeInn.IFT287Exception;
import AubergeInn.gestionnaire.GestionnaireChambre;
import AubergeInn.gestionnaire.GestionnaireClient;
import AubergeInn.tuples.TupleChambre;
import AubergeInn.tuples.TupleClientReservations;
import AubergeInn.tuples.TupleCommodite;

public class TransactionChambre {
    private final GestionnaireChambre chambre;
    private final Connexion connexion;

    public TransactionChambre(GestionnaireChambre chambre){
        this.connexion = chambre.getConnexion();
        this.chambre = chambre;
    }

    public void ajouterChambre(int idChambre, String nom_de_la_chambre, String type_de_lit, float prix) throws SQLException {
        try {
            chambre.addChambre(idChambre,nom_de_la_chambre,type_de_lit,prix);
            connexion.commit();
        } catch (Exception e) {
            connexion.rollback();
            throw e;
        }
    }

    public void supprimerChambre(int idChambre) throws SQLException {
        try {
            if(chambre.reservationsfutures(idChambre) == 0) {
                chambre.supprimerReservations(idChambre);
                chambre.supprimerCommodites(idChambre);
                chambre.supprimerChambre(idChambre);
                connexion.commit();
            }else {
                throw new SQLException("il y a des reservations futures pour cette chambre");
            }
            
        } catch (Exception e) {
            connexion.rollback();
            throw e;
        }
    }

    public List<TupleChambre> ChambresLibres() throws SQLException {
        try {
            List<TupleChambre> c =  chambre.chambresLibres();
            connexion.commit();
            return c;
        } catch (Exception e) {
            connexion.rollback();
            throw e;
        }

    }
    
    public GestionnaireChambre getGestionnaireChambre(){
        return chambre;
    }

    public TupleChambre getChambre(int idChambre) throws SQLException {
        try {
            
            if(chambre.existe(idChambre)) {
                TupleChambre c = chambre.getChambre(idChambre);
                connexion.commit();
                return c;
            }
            else {
                throw new SQLException("il n'y a pas de chambre avec l'ID : "+idChambre);
            }
        } catch (Exception e) {
            connexion.rollback();
            throw e;
        }
        
    }
    
    public List<TupleCommodite> getCommodites(int idChambre) throws SQLException {
        try {
            
            if(chambre.existe(idChambre)) {
                List<TupleCommodite> l = chambre.commoditeincluses(idChambre);
                connexion.commit();
                return l;
            }
            else {
                return new ArrayList<TupleCommodite>();
            }
        } catch (Exception e) {
            connexion.rollback();
            throw e;
        }
    }

    
 }
