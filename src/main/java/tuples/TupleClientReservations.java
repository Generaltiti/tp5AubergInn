package tuples;

import java.sql.Date;

public class TupleClientReservations{
    private String prenom;
    private String nom;
    private int age;

    private Date dateDebut;
    private Date dateFin;
    private String nomDeLachambre;
    
    private String typeDeLit;

    private double prixReservation;
    
    public TupleClientReservations(String prenom, String nom, int age, Date dateDebut, Date dateFin,
        String nomDeLachambre, String typeDeLit, double prixReservation) {
        this.prenom = prenom;
        this.nom = nom;
        this.age = age;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nomDeLachambre = nomDeLachambre;
        this.typeDeLit = typeDeLit;
        this.prixReservation = prixReservation;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getNomDeLachambre() {
        return nomDeLachambre;
    }

    public void setNomDeLachambre(String nomDeLachambre) {
        this.nomDeLachambre = nomDeLachambre;
    }

    public String getTypeDeLit() {
        return typeDeLit;
    }

    public void setTypeDeLit(String typeDeLit) {
        this.typeDeLit = typeDeLit;
    }

    public double getPrixReservation() {
        return prixReservation;
    }

    public void setPrixReservation(double prixReservation) {
        this.prixReservation = prixReservation;
    }

}