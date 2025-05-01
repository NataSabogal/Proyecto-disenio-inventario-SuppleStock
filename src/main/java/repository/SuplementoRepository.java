/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import config.DatabaseConfig;
import dto.SuplementoDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author nataliasabogalrada
 */
public class SuplementoRepository {

    public boolean guardarSuplemento(SuplementoDTO suplemento) {
        String sql = "INSERT INTO suplementos (nombre, descripcion, tipo, marca, precio, stock, fecha_registro) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConfig.getInstance().getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, suplemento.getNombre());
            stmt.setString(2, suplemento.getDescripcion());
            stmt.setString(3, suplemento.getTipo());
            stmt.setString(4, suplemento.getMarca());
            stmt.setDouble(5, suplemento.getPrecio());
            stmt.setInt(6, suplemento.getStock());
            stmt.setDate(7, Date.valueOf(suplemento.getFechaRegistro()));

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void listarSuplementos() {
        String sql = "SELECT * FROM suplementos";

        try (Connection conn = DatabaseConfig.getInstance().getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Descripción: " + rs.getString("descripcion"));
                System.out.println("Tipo: " + rs.getString("tipo"));
                System.out.println("Marca: " + rs.getString("marca"));
                System.out.println("Precio: $" + rs.getDouble("precio"));
                System.out.println("Stock: " + rs.getInt("stock"));
                System.out.println("Fecha de registro: " + rs.getDate("fecha_registro"));
                System.out.println("---------------");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public SuplementoDTO buscarPorId(int id) {
        String sql = "SELECT * FROM suplementos WHERE id = ?";
        SuplementoDTO suplemento = null;

        try (Connection conn = DatabaseConfig.getInstance().getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                suplemento = new SuplementoDTO();
                suplemento.setId(rs.getInt("id"));
                suplemento.setNombre(rs.getString("nombre"));
                suplemento.setDescripcion(rs.getString("descripcion"));
                suplemento.setTipo(rs.getString("tipo"));
                suplemento.setMarca(rs.getString("marca"));
                suplemento.setPrecio(rs.getDouble("precio"));
                suplemento.setStock(rs.getInt("stock"));
                suplemento.setFechaRegistro(rs.getDate("fecha_registro").toLocalDate());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return suplemento;
    }

    public boolean actualizarSuplemento(SuplementoDTO suplemento) {
        String sql = "UPDATE suplementos SET nombre = ?, descripcion = ?, tipo = ?, marca = ?, "
                + "precio = ?, stock = ?, fecha_registro = ? WHERE id = ?";

        try (Connection conn = DatabaseConfig.getInstance().getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, suplemento.getNombre());
            stmt.setString(2, suplemento.getDescripcion());
            stmt.setString(3, suplemento.getTipo());
            stmt.setString(4, suplemento.getMarca());
            stmt.setDouble(5, suplemento.getPrecio());
            stmt.setInt(6, suplemento.getStock());
            stmt.setDate(7, Date.valueOf(suplemento.getFechaRegistro()));
            stmt.setInt(8, suplemento.getId());

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarSuplemento(int id) {
        String sql = "DELETE FROM suplementos WHERE id = ?";

        try (Connection conn = DatabaseConfig.getInstance().getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
