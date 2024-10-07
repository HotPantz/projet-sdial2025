package com.projetsdial.model;

public class Reservation {
    private Personne personne;
    private Salle salle;
    private Creneau creneau;

    public Reservation(Personne personne, Salle salle, Creneau creneau) {
        this.personne = personne;
        this.salle = salle;
        this.creneau = creneau;
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
        return "Reservation{" +
                "personne=" + personne +
                ", salle=" + salle +
                ", creneau=" + creneau +
                '}';
    }
}
