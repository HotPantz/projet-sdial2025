package api;

import database.Connexion;
import model.Reservation;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationController implements ReservationService {
    @Override
    public void ajouterReservation(int id, int idPersonne, int idSalle, int idCreneau) {
        try (Connection connection = Connexion.getConnection()) {
            String query = "INSERT INTO reservation (id, id_personne, id_salle, id_creneau) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                statement.setInt(2, idPersonne);
                statement.setInt(3, idSalle);
                statement.setInt(4, idCreneau);
                statement.executeUpdate();
                System.out.println("Réservation ajoutée avec succès.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void supprimerReservation(int id) {
        try (Connection connection = Connexion.getConnection()) {
            String query = "DELETE FROM reservation WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                statement.executeUpdate();
                System.out.println("Réservation supprimée avec succès.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void changerCreneau(int idReservation, int nouveauCreneau) {
        try (Connection connection = Connexion.getConnection()) {
            String query = "UPDATE reservation SET id_creneau = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, nouveauCreneau);
                statement.setInt(2, idReservation);
                statement.executeUpdate();
                System.out.println("Créneau de la réservation modifié avec succès.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void creerReservationsSurCreneaux(int idPersonne, int idSalle, List<Integer> creneaux) {
        try (Connection connection = Connexion.getConnection()) {
            String query = "INSERT INTO reservation (id_personne, id_salle, id_creneau) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                for (int creneau : creneaux) {
                    statement.setInt(1, idPersonne);
                    statement.setInt(2, idSalle);
                    statement.setInt(3, creneau);
                    statement.executeUpdate();
                }
                System.out.println("Réservations ajoutées sur les créneaux sélectionnés.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Reservation> getReservations() {
        List<Reservation> reservations = new ArrayList<>();
        try (Connection connection = Connexion.getConnection()) {
            String query = "SELECT * FROM reservation";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    int idPersonne = resultSet.getInt("id_personne");
                    int idSalle = resultSet.getInt("id_salle");
                    int idCreneau = resultSet.getInt("id_creneau");
                    reservations.add(new Reservation(id, idPersonne, idSalle, idCreneau));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservations;
    }
}
