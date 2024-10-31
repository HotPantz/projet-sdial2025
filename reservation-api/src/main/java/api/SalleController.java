package api;

import database.Connexion;
import model.Salle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalleController implements SalleService {
    @Override
    public void ajouterSalle(int id, String nom) {
        try (Connection connection = Connexion.getConnection()) {
            String query = "INSERT INTO salle (id, nom) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                statement.setString(2, nom);
                statement.executeUpdate();
                System.out.println("Salle ajoutée avec succès.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void supprimerSalle(int id) {
        try (Connection connection = Connexion.getConnection()) {
            String query = "DELETE FROM salle WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                int rowsDeleted = statement.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("Salle supprimée avec succès.");
                } else {
                    System.out.println("Aucune salle trouvée avec cet ID.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Salle> getSalles() {
        List<Salle> salles = new ArrayList<>();
        try (Connection connection = Connexion.getConnection()) {
            String query = "SELECT * FROM salle";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String nom = resultSet.getString("nom");
                    salles.add(new Salle(id, nom));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salles;
    }
}
