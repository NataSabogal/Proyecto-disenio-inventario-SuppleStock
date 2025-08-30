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
public class OrdenPorPrecioAscendente implements EstrategiaOrdenamiento{
    
    public void ordenar(ArrayList<SuplementoDTO> lista) {
        for (int i = 0; i < lista.size() - 1; i++) {
            for (int j = 0; j < lista.size() - i - 1; j++) {
                if (lista.get(j).getPrecio() > lista.get(j + 1).getPrecio()) {
                    SuplementoDTO temp = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, temp);
                }
            }
        }
    }
    
}
