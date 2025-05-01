/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author nataliasabogalrada
 */
public class DatabaseConfig {

    private static DatabaseConfig instance;
    private Connection connection;
    
    private final String URL;
    private final String USER;
    private final String PASSWORD;

    private DatabaseConfig() {
        Dotenv dotenv = Dotenv.load();
        URL = dotenv.get("DB_URL");
        USER = dotenv.get("DB_USER");
        PASSWORD = dotenv.get("DB_PASSWORD");
        connect();
    }

    public static DatabaseConfig getInstance() {
        if (instance == null) {
            instance = new DatabaseConfig();
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connect();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexión cerrada exitosamente.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void connect() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión a la base de datos exitosa.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
