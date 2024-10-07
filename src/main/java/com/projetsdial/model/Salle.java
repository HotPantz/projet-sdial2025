package com.projetsdial.model;

public class Salle {
    private String numero;

    public Salle(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Salle{" +
                "numero='" + numero + '\'' +
                '}';
    }
}
