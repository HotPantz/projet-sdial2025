package com.projetsdial2025.interfaces;

import com.projetsdial2025.model.*;

public interface IResourceManager {
    void creerSalle(Salle salle);
    void supprimerSalle(int salleId);
    void creerPersonne(Personne personne);
    void supprimerPersonne(int personneId);
    void creerCreneau(Creneau creneau);
    void supprimerCreneau(int creneauId);
    void creerReservation(Reservation reservation);
    void supprimerReservation(int reservationId);
}
