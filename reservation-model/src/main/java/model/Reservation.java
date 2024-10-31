package model;

public class Reservation {
    private int id;
    private int idPersonne;
    private int idSalle;
    private int idCreneau;

    public Reservation(int id, int idPersonne, int idSalle, int idCreneau) {
        this.id = id;
        this.idPersonne = idPersonne;
        this.idSalle = idSalle;
        this.idCreneau = idCreneau;
    }

    // Getters et setters
    public int getId() { return id; }
    public int getIdPersonne() { return idPersonne; }
    public int getIdSalle() { return idSalle; }
    public int getIdCreneau() { return idCreneau; }

    public void setIdPersonne(int idPersonne) { this.idPersonne = idPersonne; }
    public void setIdSalle(int idSalle) { this.idSalle = idSalle; }
    public void setIdCreneau(int idCreneau) { this.idCreneau = idCreneau; }
}
