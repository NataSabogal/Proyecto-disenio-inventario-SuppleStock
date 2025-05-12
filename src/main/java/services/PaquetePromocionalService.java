/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import decorator.ConCuponDeDescuento;
import decorator.ConEntregaExpress;
import decorator.ConShakerGratis;
import decorator.Paquete;
import decorator.PaqueteBasico;
import dto.SuplementoDTO;

/**
 *
 * @author nataliasabogalrada
 */
public class PaquetePromocionalService {
    
    public Paquete generarPaquete(SuplementoDTO suplemento) {
        Paquete paquete = new PaqueteBasico(suplemento.getNombre(), suplemento.getPrecio());

        if (suplemento.getPrecio() > 80) {
            paquete = new ConShakerGratis(paquete);
        }

        if (suplemento.getNombre().toLowerCase().contains("proteína")) {
            paquete = new ConCuponDeDescuento(paquete);
        }

        paquete = new ConEntregaExpress(paquete); 

        return paquete;
    }
    
}
