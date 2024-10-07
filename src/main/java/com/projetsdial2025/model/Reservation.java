package com.projetsdial2025.model;

public class Reservation {
    private int id;
    private Personne personne;
    private Salle salle;
    private Creneau creneau;

    public Reservation(int id, Personne personne, Salle salle, Creneau creneau) {
        this.id = id;
        this.personne = personne;
        this.salle = salle;
        this.creneau = creneau;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public Creneau getCreneau() {
        return creneau;
    }

    public void setCreneau(Creneau creneau) {
        this.creneau = creneau;
    }

    @Override
    public String toString() {
        return "Reservation{" + "id=" + id + ", personne=" + personne + ", salle=" + salle + ", creneau=" + creneau + '}';
    }
}
