package api;

import java.time.LocalDateTime;

public interface CreneauService {
    void ajouterCreneau(int id, LocalDateTime dateDebut, LocalDateTime dateFin);
    void supprimerCreneau(int id);
}
