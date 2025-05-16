/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package observer;

import dto.SuplementoDTO;
import javax.swing.JOptionPane;

/**
 *
 * @author nataliasabogalrada
 */
public class NotificadorStockBajo implements ObservadorSuplemento {
    
    @Override
    public void notificar(SuplementoDTO suplemento) {
        if (suplemento.getStock() <= 5) {
            JOptionPane.showMessageDialog(null,
                "¡Alerta! El suplemento \"" + suplemento.getNombre() + "\" tiene un stock bajo (" + suplemento.getStock() + ").",
                "Stock Bajo",
                JOptionPane.WARNING_MESSAGE
            );
        }
    }
}
