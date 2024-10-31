package ihm;

import api.CreneauService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CreneauIHM {
    private CreneauService creneauService; // Utilisation de l'interface
    private JPanel panel;

    // Constructeur prenant CreneauService comme paramètre
    public CreneauIHM(CreneauService creneauService) {
        this.creneauService = creneauService;
        panel = initializeUI(); // Créer et récupérer le panneau
    }

    private JPanel initializeUI() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel idLabel = new JLabel("ID du créneau:");
        JTextField idField = new JTextField();
        JLabel debutLabel = new JLabel("Début du créneau (yyyy-MM-dd HH:mm):");
        JTextField debutField = new JTextField();
        JLabel finLabel = new JLabel("Fin du créneau (yyyy-MM-dd HH:mm):");
        JTextField finField = new JTextField();
        JButton ajouterButton = new JButton("Ajouter Créneau");
        JButton supprimerButton = new JButton("Supprimer Créneau");

        ajouterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    LocalDateTime debut = LocalDateTime.parse(debutField.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
                    LocalDateTime fin = LocalDateTime.parse(finField.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
                    creneauService.ajouterCreneau(id, debut, fin);
                    JOptionPane.showMessageDialog(panel, "Créneau ajouté avec succès.");
                    idField.setText("");
                    debutField.setText("");
                    finField.setText("");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panel, "Erreur dans les données. Assurez-vous que l'ID est valide et que les dates sont bien formatées.", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        supprimerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    creneauService.supprimerCreneau(id);
                    JOptionPane.showMessageDialog(panel, "Créneau supprimé avec succès.");
                    idField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel, "Veuillez entrer un ID valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(idLabel);
        panel.add(idField);
        panel.add(debutLabel);
        panel.add(debutField);
        panel.add(finLabel);
        panel.add(finField);
        panel.add(ajouterButton);
        panel.add(supprimerButton);

        return panel;
    }

    public JPanel getPanel() {
        return panel;
    }
}
