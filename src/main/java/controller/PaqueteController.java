/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import decorator.Paquete;
import dto.SuplementoDTO;
import services.PaquetePromocionalService;

/**
 *
 * @author nataliasabogalrada
 */
public class PaqueteController {
    
    private PaquetePromocionalService service;

    public PaqueteController() {
        this.service = new PaquetePromocionalService();
    }

    public Paquete generarPaqueteDesdeSuplemento(SuplementoDTO suplemento) {
        return service.generarPaquete(suplemento);
    }
    
}
