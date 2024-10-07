package com.projetsdial2025.model;

import java.time.LocalDateTime;

public class Creneau {
    private int id;
    private LocalDateTime debut;
    private LocalDateTime fin;

    public Creneau(int id, LocalDateTime debut, LocalDateTime fin) {
        this.id = id;
        this.debut = debut;
        this.fin = fin;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDebut() {
        return debut;
    }

    public void setDebut(LocalDateTime debut) {
        this.debut = debut;
    }

    public LocalDateTime getFin() {
        return fin;
    }

    public void setFin(LocalDateTime fin) {
        this.fin = fin;
    }

    @Override
    public String toString() {
        return "Creneau{" + "id=" + id + ", debut=" + debut + ", fin=" + fin + '}';
    }
}
