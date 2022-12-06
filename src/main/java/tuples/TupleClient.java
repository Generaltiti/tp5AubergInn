package tuples;

public class TupleClient{
    private int idClient;
    private String nom;
    private String prenom;
    private int age;

    public TupleClient(int idClient, String nom, String prenom, int age) {
        this.idClient = idClient;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }
    public int getidClient() {
        return idClient;
    }

    public void setidClient(int idClient) {
        this.idClient = idClient;
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void getAge(int age) {
        this.age = age;
    }
}