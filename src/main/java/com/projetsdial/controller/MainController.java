package com.projetsdial.controller;

import com.projetsdial.model.Personne;
import com.projetsdial.model.Salle;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class MainController {

    @FXML
    private TextField numeroSalleField;

    @FXML
    private TextField nomPersonneField;

    @FXML
    private TextField prenomPersonneField;

    @FXML
    protected void handleAddSalle() {
        String numero = numeroSalleField.getText();
        Salle salle = new Salle(numero);
        System.out.println("Salle ajoutée : " + salle);
        numeroSalleField.clear();  // Clear the input field after adding the salle
    }

    @FXML
    protected void handleAddPersonne() {
        String nom = nomPersonneField.getText();
        String prenom = prenomPersonneField.getText();
        Personne personne = new Personne(nom, prenom);
        System.out.println("Personne ajoutée : " + personne);
        nomPersonneField.clear();  // Clear the input fields after adding the person
        prenomPersonneField.clear();
    }
}
