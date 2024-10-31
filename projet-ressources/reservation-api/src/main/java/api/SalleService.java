package api;

import model.Salle;

import java.util.List;

public interface SalleService {
    void ajouterSalle(int id, String nom);
    void supprimerSalle(int id);
    List<Salle> getSalles(); // Assurez-vous que cette méthode est présente ici
}
