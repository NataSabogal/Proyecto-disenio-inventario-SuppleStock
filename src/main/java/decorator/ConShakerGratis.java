/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package decorator;

/**
 *
 * @author nataliasabogalrada
 */
public class ConShakerGratis extends PaqueteDecorator {

    public ConShakerGratis(Paquete paquete) {
        super(paquete);
    }

    @Override
    public String getDescripcion() {
        return paquete.getDescripcion() + " + Shaker Gratis";
    }

    @Override
    public double getPrecio() {
        return paquete.getPrecio(); 
    }

}
