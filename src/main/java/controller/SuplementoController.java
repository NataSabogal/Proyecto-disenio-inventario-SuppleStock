/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dto.SuplementoDTO;
import services.SuplementoService;

/**
 *
 * @author nataliasabogalrada
 */
public class SuplementoController {
    
    private final SuplementoService suplementoService;

    public SuplementoController() {
        this.suplementoService = new SuplementoService();
    }

    public boolean registrarSuplemento(SuplementoDTO suplemento) {
        return suplementoService.guardarSuplemento(suplemento);
    }

    public void mostrarTodosLosSuplementos() {
        suplementoService.listarSuplementos(); 
    }

    public SuplementoDTO buscarSuplementoPorId(int id) {
        return suplementoService.buscarPorId(id);
    }

    public boolean actualizarSuplemento(SuplementoDTO suplemento) {
        return suplementoService.actualizarSuplemento(suplemento);
    }

    public boolean eliminarSuplemento(int id) {
        return suplementoService.eliminarSuplemento(id);
    }
    
    
}
