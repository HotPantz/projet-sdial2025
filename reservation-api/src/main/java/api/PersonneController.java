package api;

import database.Connexion;
import model.Personne;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonneController implements PersonneService {
    @Override
    public void ajouterPersonne(int id, String nom, String prenom, String type) {
        try (Connection connection = Connexion.getConnection()) {
            String query = "INSERT INTO personne (id, nom, prenom, type) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                statement.setString(2, nom);
                statement.setString(3, prenom); // Ajout du prénom
                statement.setString(4, type); // Ajout du type
                statement.executeUpdate();
                System.out.println("Personne ajoutée avec succès.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void supprimerPersonne(int id) {
        try (Connection connection = Connexion.getConnection()) {
            String query = "DELETE FROM personne WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                int rowsDeleted = statement.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("Personne supprimée avec succès.");
                } else {
                    System.out.println("Aucune personne trouvée avec cet ID.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Optionnel si vous souhaitez récupérer la liste
    public List<Personne> getPersonnes() {
        List<Personne> personnes = new ArrayList<>();
        try (Connection connection = Connexion.getConnection()) {
            String query = "SELECT * FROM personne";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String nom = resultSet.getString("nom");
                    String prenom = resultSet.getString("prenom"); // Récupération du prénom
                    String type = resultSet.getString("type"); // Récupération du type
                    personnes.add(new Personne(id, nom, prenom, type));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personnes;
    }
}
