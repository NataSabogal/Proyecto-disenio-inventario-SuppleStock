/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package strategy;

import dto.SuplementoDTO;
import java.util.ArrayList;

/**
 *
 * @author nataliasabogalrada
 */
public class OrdenadorSuplementos {
    
    private EstrategiaOrdenamiento estrategia;

    public void setEstrategia(EstrategiaOrdenamiento estrategia) {
        this.estrategia = estrategia;
    }

    public void ordenar(ArrayList<SuplementoDTO> lista) {
        if (estrategia != null) {
            estrategia.ordenar(lista);
        }
    }
}
