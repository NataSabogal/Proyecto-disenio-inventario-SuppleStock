/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package decorator;

/**
 *
 * @author nataliasabogalrada
 */
public class PaqueteBasico implements Paquete {

    private String nombre;
    private double precio;

    public PaqueteBasico(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String getDescripcion() {
        return "Paquete: " + nombre;
    }

    @Override
    public double getPrecio() {
        return precio;
    }

}
