package api;

import database.Connexion;
import model.Creneau;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CreneauController implements CreneauService {
    @Override
    public void ajouterCreneau(int id, LocalDateTime dateDebut, LocalDateTime dateFin) {
        try (Connection connection = Connexion.getConnection()) {
            String query = "INSERT INTO creneau (id, debut, fin) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                statement.setObject(2, dateDebut);
                statement.setObject(3, dateFin);
                statement.executeUpdate();
                System.out.println("Créneau ajouté avec succès.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void supprimerCreneau(int id) {
        try (Connection connection = Connexion.getConnection()) {
            String query = "DELETE FROM creneau WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                int rowsDeleted = statement.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("Créneau supprimé avec succès.");
                } else {
                    System.out.println("Aucun créneau trouvé avec cet ID.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
