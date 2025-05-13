/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package decorator;

/**
 *
 * @author nataliasabogalrada
 */
public abstract class PaqueteDecorator implements Paquete{
    
    protected Paquete paquete;
    
    public PaqueteDecorator(Paquete paquete) {
        this.paquete = paquete;
    }
    
}
