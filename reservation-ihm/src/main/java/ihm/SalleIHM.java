package ihm;

import api.SalleService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SalleIHM {
    private SalleService salleService; // Utilisation de l'interface
    private JPanel panel;

    public SalleIHM(SalleService salleService) {
        this.salleService = salleService;
        panel = initializeUI(); // Créer et récupérer le panneau
    }

    private JPanel initializeUI() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel idLabel = new JLabel("ID de la salle:");
        JTextField idField = new JTextField();
        JLabel nomLabel = new JLabel("Nom de la salle:");
        JTextField nomField = new JTextField();
        JButton ajouterButton = new JButton("Ajouter Salle");
        JButton supprimerButton = new JButton("Supprimer Salle");

        ajouterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    String nom = nomField.getText();
                    salleService.ajouterSalle(id, nom);
                    JOptionPane.showMessageDialog(panel, "Salle ajoutée avec succès.");
                    idField.setText("");
                    nomField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel, "Veuillez entrer un ID valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        supprimerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    salleService.supprimerSalle(id);
                    JOptionPane.showMessageDialog(panel, "Salle supprimée avec succès.");
                    idField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel, "Veuillez entrer un ID valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(idLabel);
        panel.add(idField);
        panel.add(nomLabel);
        panel.add(nomField);
        panel.add(ajouterButton);
        panel.add(supprimerButton);

        return panel;
    }

    public JPanel getPanel() {
        return panel;
    }
}
