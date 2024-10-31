package api;

import model.Personne;

import java.util.List;

public interface PersonneService {
    void ajouterPersonne(int id, String nom, String prenom, String type); // Mise à jour
    void supprimerPersonne(int id);
    List<Personne> getPersonnes(); // Optionnel
}
