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

    private final SuplementoDTO suplemento;

    public SuplementoBuilder() {
        suplemento = new SuplementoDTO();
    }

    public SuplementoBuilder conId(int id) {
        suplemento.setId(id);
        return this;
    }

    public SuplementoBuilder conNombre(String nombre) {
        suplemento.setNombre(nombre);
        return this;
    }

    public SuplementoBuilder conDescripcion(String descripcion) {
        suplemento.setDescripcion(descripcion);
        return this;
    }

    public SuplementoBuilder conTipo(String tipo) {
        suplemento.setTipo(tipo);
        return this;
    }

    public SuplementoBuilder conMarca(String marca) {
        suplemento.setMarca(marca);
        return this;
    }

    public SuplementoBuilder conPrecio(double precio) {
        suplemento.setPrecio(precio);
        return this;
    }

    public SuplementoBuilder conStock(int stock) {
        suplemento.setStock(stock);
        return this;
    }

    public SuplementoBuilder conFechaRegistro(LocalDate fecha) {
        suplemento.setFechaRegistro(fecha);
        return this;
    }

    public SuplementoDTO build() {
        return suplemento;
    }

}
