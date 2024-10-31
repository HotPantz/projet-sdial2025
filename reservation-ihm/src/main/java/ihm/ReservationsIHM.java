package ihm;

import api.ReservationService;
import model.Reservation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReservationsIHM {
    private ReservationService reservationService;
    private JPanel panel;

    public ReservationsIHM(ReservationService reservationService) {
        this.reservationService = reservationService;
        this.panel = initializeUI();
    }

    private JPanel initializeUI() {
        JPanel panel = new JPanel(new GridLayout(6, 2));

        JLabel idLabel = new JLabel("ID Réservation:");
        JTextField idField = new JTextField();
        JLabel idPersonneLabel = new JLabel("ID Personne:");
        JTextField idPersonneField = new JTextField();
        JLabel idSalleLabel = new JLabel("ID Salle:");
        JTextField idSalleField = new JTextField();
        JLabel idCreneauLabel = new JLabel("ID Créneau:");
        JTextField idCreneauField = new JTextField();
        JButton ajouterButton = new JButton("Ajouter Réservation");
        JButton supprimerButton = new JButton("Supprimer Réservation");
        JButton changerCreneauButton = new JButton("Changer Créneau");

        ajouterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    int idPersonne = Integer.parseInt(idPersonneField.getText());
                    int idSalle = Integer.parseInt(idSalleField.getText());
                    int idCreneau = Integer.parseInt(idCreneauField.getText());
                    reservationService.ajouterReservation(id, idPersonne, idSalle, idCreneau);
                    JOptionPane.showMessageDialog(panel, "Réservation ajoutée avec succès.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel, "Veuillez entrer des valeurs valides.", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        supprimerButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                reservationService.supprimerReservation(id);
                JOptionPane.showMessageDialog(panel, "Réservation supprimée avec succès.");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(panel, "Veuillez entrer un ID valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });

        changerCreneauButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                int nouveauCreneau = Integer.parseInt(idCreneauField.getText());
                reservationService.changerCreneau(id, nouveauCreneau);
                JOptionPane.showMessageDialog(panel, "Créneau modifié avec succès.");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(panel, "Veuillez entrer un ID valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });

        panel.add(idLabel);
        panel.add(idField);
        panel.add(idPersonneLabel);
        panel.add(idPersonneField);
        panel.add(idSalleLabel);
        panel.add(idSalleField);
        panel.add(idCreneauLabel);
        panel.add(idCreneauField);
        panel.add(ajouterButton);
        panel.add(supprimerButton);
        panel.add(changerCreneauButton);

        return panel;
    }

    public JPanel getPanel() {
        return panel;
    }
}
