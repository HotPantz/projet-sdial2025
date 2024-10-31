package ihm;

import javax.swing.*;
import java.awt.*;
import api.SalleService;
import api.PersonneService;
import api.CreneauService;
import api.ReservationService;

public class ReservationIHM {
    public ReservationIHM(SalleService salleService, PersonneService personneService, CreneauService creneauService, ReservationService reservationService) {
        JFrame frame = new JFrame("Gestion des Salles, Personnes, Créneaux et Réservations");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JTabbedPane tabbedPane = new JTabbedPane();

        // Utilisation des interfaces Service pour chaque onglet
        tabbedPane.addTab("Salles", new SalleIHM(salleService).getPanel());
        tabbedPane.addTab("Personnes", new PersonneIHM(personneService).getPanel());
        tabbedPane.addTab("Créneaux", new CreneauIHM(creneauService).getPanel());
        tabbedPane.addTab("Réservations", new ReservationsIHM(reservationService).getPanel());

        frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Injection des implémentations concrètes dans le main
        SalleService salleService = new api.SalleController();
        PersonneService personneService = new api.PersonneController();
        CreneauService creneauService = new api.CreneauController();
        ReservationService reservationService = new api.ReservationController();

        SwingUtilities.invokeLater(() -> new ReservationIHM(salleService, personneService, creneauService, reservationService));
    }
}
