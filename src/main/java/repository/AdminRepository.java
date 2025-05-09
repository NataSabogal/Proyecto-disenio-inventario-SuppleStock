/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import config.DatabaseConfig;
import dto.AdminDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author nataliasabogalrada
 */
public class AdminRepository {

    public boolean saveAdmin(AdminDTO admin) {
        String sql = "INSERT INTO administrador (cedula, nombre, password) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConfig.getInstance().getConnection(); 
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, admin.getCedula());
            stmt.setString(2, admin.getNombre());
            stmt.setString(3, BCrypt.hashpw(admin.getPassword(), BCrypt.gensalt()));

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public AdminDTO findAdminByCedula(String cedula) {
        String sql = "SELECT * FROM administrador WHERE cedula = ?";

        try (Connection conn = DatabaseConfig.getInstance().getConnection(); 
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cedula);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new AdminDTO(
                        rs.getString("cedula"),
                        rs.getString("nombre"),
                        rs.getString("password")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
