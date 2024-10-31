package model;

public class Personne {
    private int id;
    private String nom;
    private String prenom;
    private String type; // Ajout du champ type

    public Personne(int id, String nom, String prenom, String type) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.type = type; // Initialisation du type
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom; // Getter pour le prénom
    }

    public String getType() {
        return type; // Getter pour le type
    }

    @Override
    public String toString() {
        return "Personne{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", type='" + type + '\'' + // Ajout du type à l'affichage
                '}';
    }
}
