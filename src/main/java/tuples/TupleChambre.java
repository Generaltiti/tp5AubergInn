package tuples;

public class TupleChambre{

    private Integer id;
    private String nom;
    private String type;
    private float prix;
    public TupleChambre(Integer id, String nomDeLaChambre, String typeDeLit, float prix) {
        this.id = id;
        this.nom = nomDeLaChambre;
        this.type = typeDeLit;
        this.prix = prix;
    }
    public String toString() {
        return id.toString() + " " + nom + " " + type + " " + Float.toString(prix);
    }
    
}