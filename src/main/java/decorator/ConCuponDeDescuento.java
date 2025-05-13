/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package decorator;

/**
 *
 * @author nataliasabogalrada
 */
public class ConCuponDeDescuento extends PaqueteDecorator{

    public ConCuponDeDescuento(Paquete paquete) {
        super(paquete);
    }
    
    

    @Override
    public String getDescripcion() {
        return paquete.getDescripcion() + " + Cupón 10%";
    }

    @Override
    public double getPrecio() {
        return paquete.getPrecio() * 0.90; // Aplica 10% de descuento
    }
    
}
