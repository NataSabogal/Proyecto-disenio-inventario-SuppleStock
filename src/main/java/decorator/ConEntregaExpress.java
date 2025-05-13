/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package decorator;

/**
 *
 * @author nataliasabogalrada
 */
public class ConEntregaExpress extends PaqueteDecorator{
    
    public ConEntregaExpress(Paquete paquete) {
        super(paquete);
    }

    @Override
    public String getDescripcion() {
        return paquete.getDescripcion() + " + Entrega Express";
    }

    @Override
    public double getPrecio() {
        return paquete.getPrecio() + 15.0; // Agrega costo de entrega
    }
    
}
