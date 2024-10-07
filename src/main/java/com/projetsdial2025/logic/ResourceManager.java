package com.projetsdial2025.logic;

import com.projetsdial2025.interfaces.IResourceManager;
import com.projetsdial2025.model.*;

import java.util.ArrayList;
import java.util.List;

public class ResourceManager implements IResourceManager {

    private List<Salle> salles = new ArrayList<>();
    private List<Personne> personnes = new ArrayList<>();
    private List<Creneau> creneaux = new ArrayList<>();
    private List<Reservation> reservations = new ArrayList<>();

    // Méthodes CRUD pour les ressources (déjà présentes dans la version précédente)
    @Override
    public void creerSalle(Salle salle) {
        salles.add(salle);
        System.out.println("Salle créée : " + salle);
    }

    @Override
    public void supprimerSalle(int salleId) {
        salles.removeIf(salle -> salle.getId() == salleId);
        System.out.println("Salle supprimée avec ID : " + salleId);
    }

    @Override
    public void creerPersonne(Personne personne) {
        personnes.add(personne);
        System.out.println("Personne créée : " + personne);
    }

    @Override
    public void supprimerPersonne(int personneId) {
        personnes.removeIf(personne -> personne.getId() == personneId);
        System.out.println("Personne supprimée avec ID : " + personneId);
    }

    @Override
    public void creerCreneau(Creneau creneau) {
        creneaux.add(creneau);
        System.out.println("Créneau créé : " + creneau);
    }

    @Override
    public void supprimerCreneau(int creneauId) {
        creneaux.removeIf(creneau -> creneau.getId() == creneauId);
        System.out.println("Créneau supprimé avec ID : " + creneauId);
    }

    @Override
    public void creerReservation(Reservation reservation) {
        reservations.add(reservation);
        System.out.println("Réservation créée : " + reservation);
    }

    @Override
    public void supprimerReservation(int reservationId) {
        reservations.removeIf(reservation -> reservation.getId() == reservationId);
        System.out.println("Réservation supprimée avec ID : " + reservationId);
    }

    // Ajout des méthodes getter pour accéder aux listes
    public List<Salle> getSalles() {
        return salles;
    }

    public List<Personne> getPersonnes() {
        return personnes;
    }

    public List<Creneau> getCreneaux() {
        return creneaux;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }
}
