/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Builder;

import dto.SuplementoDTO;
import java.time.LocalDate;

/**
 *
 * @author nataliasabogalrada
 */
public class SuplementoBuilder {
    
    private int id;
    private String nombre;
    private String descripcion;
    private String tipo;
    private String marca;
    private double precio;
    private int stock;
    private LocalDate fechaRegistro;

    public SuplementoBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public SuplementoBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public SuplementoBuilder setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public SuplementoBuilder setTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    public SuplementoBuilder setMarca(String marca) {
        this.marca = marca;
        return this;
    }

    public SuplementoBuilder setPrecio(double precio) {
        this.precio = precio;
        return this;
    }

    public SuplementoBuilder setStock(int stock) {
        this.stock = stock;
        return this;
    }

    public SuplementoBuilder setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
        return this;
    }

    public SuplementoDTO build() {
        return new SuplementoDTO(id, nombre, descripcion, tipo, marca, precio, stock, fechaRegistro);
    }
    
}
