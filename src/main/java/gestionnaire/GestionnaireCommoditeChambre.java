package gestionnaire;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import utilities.Connexion;

public class GestionnaireCommoditeChambre{
    private final PreparedStatement inclureCommodite;
    private final PreparedStatement enleverCommodite;

    private final Connexion conn;

    public GestionnaireCommoditeChambre(Connexion conn) throws SQLException {
        this.conn = conn;

        inclureCommodite = conn.getConnection().prepareStatement(
            "INSERT INTO CommoditeChambre (IdChambre,IdCommodite) VALUES (?,?)"
        );
        enleverCommodite = conn.getConnection().prepareStatement(
            "DELETE FROM CommoditeChambre WHERE IdChambre = ? AND IdCommodite = ?"
        );

    }

    public void inclureCommodite(int IdChambre, int IdCommodite) throws SQLException{
        inclureCommodite.setInt(1,IdChambre);
        inclureCommodite.setInt(2,IdCommodite);
        inclureCommodite.executeUpdate();
    }

    public void enleverCommodite(int IdChambre, int IdCommodite) throws SQLException{
        enleverCommodite.setInt(1,IdChambre);
        enleverCommodite.setInt(2,IdCommodite);
        enleverCommodite.executeUpdate();
    }

    public Connexion getConnexion() {
        return this.conn;
    }

}