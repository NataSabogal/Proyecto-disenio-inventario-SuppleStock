/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dto.AdminDTO;
import org.mindrot.jbcrypt.BCrypt;
import repository.AdminRepository;

/**
 *
 * @author nataliasabogalrada
 */
public class AdminService {

    private final AdminRepository adminRepository = new AdminRepository();

    public boolean registerAdmin(String cedula, String nombre, String password) {
        if (cedula.isEmpty() || nombre.isEmpty() || password.isEmpty()) {
            return false;
        }

        AdminDTO admin = new AdminDTO(cedula, nombre, password);
        return adminRepository.saveAdmin(admin);
    }

    public boolean login(String cedula, String password) {
        AdminDTO admin = adminRepository.findAdminByCedula(cedula);

        if (admin != null && BCrypt.checkpw(password, admin.getPassword())) {
            return true;
        }
        return false;
    }

}
