package com.projetsdial2025.model;

public class Personne {
    private int id;
    private String nom;
    private String prenom;
    private String type; // 'enseignant' ou 'eleve'

    public Personne(int id, String nom, String prenom, String type) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.type = type;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Personne{" + "id=" + id + ", nom='" + nom + '\'' + ", prenom='" + prenom + '\'' + ", type='" + type + '\'' + '}';
    }
}
