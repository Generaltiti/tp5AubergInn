package tuples;

import java.sql.Date;

public class TupleCommodite{

    public Integer idCommodite;
    public float Surplus_prix;
    public String Description;
    
    public TupleCommodite(Integer idCommodite, float Surplus_prix, String Description){
        this.idCommodite = idCommodite;
        this.Surplus_prix = Surplus_prix;
        this.Description = Description;
    }
    
    public String toString() {
        return idCommodite + " " + Description + " " + Float.toString(Surplus_prix);
    }

}