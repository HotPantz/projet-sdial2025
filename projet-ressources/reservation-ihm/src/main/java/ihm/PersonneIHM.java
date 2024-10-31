package ihm;

import api.PersonneService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonneIHM {
    private PersonneService personneService; // Utilisation de l'interface
    private JPanel panel;

    // Modification du constructeur pour accepter un service
    public PersonneIHM(PersonneService personneService) {
        this.personneService = personneService;
        panel = initializeUI();
    }

    private JPanel initializeUI() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JLabel idLabel = new JLabel("ID de la personne:");
        JTextField idField = new JTextField();
        JLabel nomLabel = new JLabel("Nom de la personne:");
        JTextField nomField = new JTextField();
        JLabel prenomLabel = new JLabel("Prénom de la personne:");
        JTextField prenomField = new JTextField();
        JLabel typeLabel = new JLabel("Type de la personne:");
        JTextField typeField = new JTextField();
        JButton ajouterButton = new JButton("Ajouter Personne");
        JButton supprimerButton = new JButton("Supprimer Personne");

        ajouterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    String nom = nomField.getText();
                    String prenom = prenomField.getText();
                    String type = typeField.getText();
                    personneService.ajouterPersonne(id, nom, prenom, type);
                    JOptionPane.showMessageDialog(panel, "Personne ajoutée avec succès.");
                    idField.setText("");
                    nomField.setText("");
                    prenomField.setText("");
                    typeField.setText("");
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
                    personneService.supprimerPersonne(id);
                    JOptionPane.showMessageDialog(panel, "Personne supprimée avec succès.");
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
        panel.add(prenomLabel);
        panel.add(prenomField);
        panel.add(typeLabel);
        panel.add(typeField);
        panel.add(ajouterButton);
        panel.add(supprimerButton);

        return panel;
    }

    public JPanel getPanel() {
        return panel;
    }
}
