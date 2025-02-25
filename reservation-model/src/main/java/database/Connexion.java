package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
    private static final String URL = "jdbc:mysql://localhost:3306/reservations"; // Remplacez par votre nom de base de données
    private static final String USER = "root"; // Remplacez par votre utilisateur
    private static final String PASSWORD = ""; // Remplacez par votre mot de passe

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
