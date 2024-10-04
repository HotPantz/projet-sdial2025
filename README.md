# Projet SDIAL 2025 - Gestion des Ressources en Java/JavaFX

## Description

Ce projet fait partie du cours d'**Architecture Logicielle** dans le cadre de l'année 2025. Il s'agit d'une application Java développée avec **JavaFX** qui permet la gestion des ressources (salles, personnes, créneaux, et réservations) au sein d'une organisation.

L'application implémente les **exigences fonctionnelles liées aux ressources** définies dans le cahier des charges. Elle permet de :
- Créer et supprimer des salles, des personnes, et des créneaux temporels.
- Créer, modifier, et supprimer des réservations.
- Gérer plusieurs créneaux à la fois pour les réservations.

## Fonctionnalités

- **Gestion des salles** : Ajout, suppression de salles.
- **Gestion des personnes** : Ajout, suppression de personnes.
- **Gestion des créneaux temporels** : Ajout, suppression, modification des créneaux.
- **Gestion des réservations** : Créer, modifier, et supprimer des réservations associant une personne, une salle, et un créneau temporel.
- **Gestion des créneaux multiples** : Créer des réservations sur plusieurs créneaux simultanément.

## Exigences non fonctionnelles

- Documentation détaillée incluant les procédures d'installation, désinstallation, et utilisation.
- Architecture basée sur un modèle **client-serveur**.
- Utilisation des interfaces Java pour la communication entre l'IHM et les fonctionnalités métiers.
- Le programme est structuré en plusieurs packages distincts (IHM, modèle métier, logique d'application).

## Technologies utilisées

- **Java 21**
- **JavaFX** pour l'interface graphique
- **Maven** pour la gestion des dépendances
- **GIT** pour la gestion du versionnement
- **UML** pour la modélisation des composants et de l'architecture

## Prérequis

- **Java 21** doit être installé sur votre machine. Téléchargez-le [ici](https://www.oracle.com/java/technologies/javase-jdk21-downloads.html).
- **Maven** doit être installé pour la compilation et la gestion des dépendances. Instructions d'installation [ici](https://maven.apache.org/install.html).
- Un environnement compatible avec **JavaFX** (JavaFX SDK).

## Installation

1. Clonez le repository GitHub :
    ```bash
    git clone https://github.com/HotPantz/projet-sdial2025.git
    ```
2. Accédez au dossier du projet :
    ```bash
    cd projet-sdial2025
    ```
3. Compilez et exécutez le projet avec Maven :
    ```bash
    mvn clean install
    mvn javafx:run
    ```

## Utilisation

L'application offre une interface utilisateur simple pour gérer les ressources. Les fonctionnalités principales peuvent être accessibles via les menus ou boutons dans l'IHM :
- Ajouter, supprimer des salles et des personnes via les onglets correspondants.
- Gérer les réservations et les créneaux temporels via l'interface de réservation.

## Architecture

L'architecture suit un modèle **client-serveur**, où l'IHM (côté client) communique avec le serveur via des interfaces Java, exposant les fonctionnalités métier. L'application est divisée en plusieurs packages :
- `ihm` : contient les classes liées à l'interface graphique.
- `model` : contient les classes métier (salles, personnes, créneaux, réservations).
- `application` : contient le point d'entrée principal du programme.

## Contributeurs

- **KABLIA Selyan**
- **LESTRADE NATHAN**
- **MANSOUR Asma**
- **OURAGHENE Sami**

## License

Ce projet est sous licence MIT. Voir le fichier [LICENSE](LICENSE) pour plus de détails.
