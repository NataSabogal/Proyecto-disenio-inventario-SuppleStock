/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package observer;

import dto.SuplementoDTO;
import javax.swing.JTextArea;

/**
 *
 * @author nataliasabogalrada
 */
public class LogVisualStockBajo implements ObservadorSuplemento{
    
    private final JTextArea areaTexto;

    public LogVisualStockBajo(JTextArea areaTexto) {
        this.areaTexto = areaTexto;
    }

    @Override
    public void notificar(SuplementoDTO suplemento) {
        if (suplemento.getStock() <= 5) {
            areaTexto.append("⚠ Suplemento con bajo stock: " +
                suplemento.getNombre() + " (" + suplemento.getStock() + ")\n");
        }
    }
}
