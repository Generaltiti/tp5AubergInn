package tuples;

public class TupleChambre{

    public Integer id;
    public String nom;
    public String type;
    public float prix;
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