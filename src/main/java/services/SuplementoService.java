/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dto.SuplementoDTO;
import java.util.ArrayList;
import repository.SuplementoRepository;

/**
 *
 * @author nataliasabogalrada
 */
public class SuplementoService {

    private final SuplementoRepository suplementoRepository;

    public SuplementoService() {
        this.suplementoRepository = new SuplementoRepository();
    }

    public boolean guardarSuplemento(SuplementoDTO suplemento) {
        return suplementoRepository.guardarSuplemento(suplemento);
    }

    public ArrayList<SuplementoDTO> listarSuplementos() {
        return suplementoRepository.listarSuplementos();
    }

    public SuplementoDTO buscarPorId(int id) {
        return suplementoRepository.buscarPorId(id);
    }

    public boolean actualizarSuplemento(SuplementoDTO suplemento) {
        return suplementoRepository.actualizarSuplemento(suplemento);
    }

    public boolean eliminarSuplemento(int id) {
        return suplementoRepository.eliminarSuplemento(id);
    }

    public ArrayList<SuplementoDTO> obtenerTodos() {
        return suplementoRepository.obtenerTodos();
    }
}
