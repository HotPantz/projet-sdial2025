package com.projetsdial2025;

import com.projetsdial2025.logic.ResourceManager;
import com.projetsdial2025.model.Personne;
import com.projetsdial2025.model.Salle;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    private ResourceManager resourceManager = new ResourceManager();

    @Override
    public void start(Stage stage) {
        // Créer les éléments d'interface
        Label label = new Label("Bienvenue à Projet SDIAL 2025 avec JavaFX 22 sur Java 21!");

        // Section pour gérer les salles
        VBox salleSection = new VBox(10);
        salleSection.setPadding(new Insets(10));
        Label salleLabel = new Label("Gestion des Salles");

        TextField salleNomInput = new TextField();
        salleNomInput.setPromptText("Nom de la salle");

        Button ajouterSalleButton = new Button("Ajouter Salle");
        ajouterSalleButton.setOnAction(e -> {
            String nomSalle = salleNomInput.getText();
            if (!nomSalle.isEmpty()) {
                Salle salle = new Salle(resourceManager.getSalles().size() + 1, nomSalle);
                resourceManager.creerSalle(salle);
                salleNomInput.clear();
            }
        });

        salleSection.getChildren().addAll(salleLabel, salleNomInput, ajouterSalleButton);

        // Section pour gérer les personnes
        VBox personneSection = new VBox(10);
        personneSection.setPadding(new Insets(10));
        Label personneLabel = new Label("Gestion des Personnes");
        TextField personneNomInput = new TextField();
        personneNomInput.setPromptText("Nom de la personne");

        Button ajouterPersonneButton = new Button("Ajouter Personne");
        ajouterPersonneButton.setOnAction(e -> {
            String nomPersonne = personneNomInput.getText();
            if (!nomPersonne.isEmpty()) {
                resourceManager.creerPersonne(new Personne(resourceManager.getPersonnes().size() + 1, nomPersonne, "Prenom", "eleve"));
                personneNomInput.clear();
            }
        });

        personneSection.getChildren().addAll(personneLabel, personneNomInput, ajouterPersonneButton);

        // Mise en page générale
        VBox root = new VBox(20);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(label, salleSection, personneSection);

        // Créer la scène principale
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setTitle("Projet SDIAL 2025 - Gestion des Ressources");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
