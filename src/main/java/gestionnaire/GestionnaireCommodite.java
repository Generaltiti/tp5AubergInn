package gestionnaire;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utilities.Connexion;

public class GestionnaireCommodite{
    private final Connexion connexion;

    private final PreparedStatement stmtAjouterCommodite;
    private final PreparedStatement stmtExiste;

    public GestionnaireCommodite(Connexion connexion) throws SQLException {
        this.connexion = connexion;

        stmtAjouterCommodite = connexion.getConnection().prepareStatement("INSERT INTO Commodite (IdCommodite, Surplus_prix, Description) VALUES (?,?,?)");
        stmtExiste = connexion.getConnection().prepareStatement("SELECT IdCommodite, Surplus_prix, Description FROM Commodite WHERE IdCommodite = ?");
    }

    public void ajouterCommodite(int id, float surplus, String description) throws SQLException{
        stmtAjouterCommodite.setInt(1,id);
        stmtAjouterCommodite.setFloat(2, surplus);
        stmtAjouterCommodite.setString(3, description);
        stmtAjouterCommodite.executeUpdate();
    }

    public Boolean existe(int id) throws SQLException{
        stmtExiste.setInt(1, id);
        ResultSet rset = stmtExiste.executeQuery();
        Boolean aRetourner = rset.next();
        rset.close();
        return aRetourner;
    }

    public Connexion getConnexion() {
        return connexion;
    }

    public PreparedStatement getStmtAjouterCommodite() {
        return stmtAjouterCommodite;
    }

    
}