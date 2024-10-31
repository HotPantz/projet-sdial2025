package model;

import java.time.LocalDateTime;

public class Creneau {
    private int id;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;

    public Creneau(int id, LocalDateTime dateDebut, LocalDateTime dateFin) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public LocalDateTime getDateFin() {
        return dateFin;
    }

    @Override
    public String toString() {
        return "Creneau{" +
                "id=" + id +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                '}';
    }
}
