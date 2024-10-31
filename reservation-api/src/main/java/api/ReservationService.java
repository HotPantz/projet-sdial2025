package api;

import model.Reservation;
import java.util.List;

public interface ReservationService {
    void ajouterReservation(int id, int idPersonne, int idSalle, int idCreneau);
    void supprimerReservation(int id);
    void changerCreneau(int idReservation, int nouveauCreneau);
    void creerReservationsSurCreneaux(int idPersonne, int idSalle, List<Integer> creneaux);
    List<Reservation> getReservations();
}
