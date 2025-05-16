/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dto.SuplementoDTO;
import java.util.ArrayList;
import observer.GestorSuplementosObservable;
import observer.NotificadorStockBajo;
import observer.ObservadorSuplemento;
import services.SuplementoService;
import strategy.EstrategiaOrdenamiento;
import strategy.OrdenadorSuplementos;

/**
 *
 * @author nataliasabogalrada
 */
public class SuplementoController {

    private final SuplementoService suplementoService;
    private final GestorSuplementosObservable gestorObservable = new GestorSuplementosObservable();

    public SuplementoController() {
        this.suplementoService = new SuplementoService();
        gestorObservable.agregarObservador(new NotificadorStockBajo());
        

    }

    public void agregarObservador(ObservadorSuplemento observador) {
        gestorObservable.agregarObservador(observador);
    }

    public boolean registrarSuplemento(SuplementoDTO suplemento) {
        boolean registrado = suplementoService.guardarSuplemento(suplemento);
        if (registrado) {
            gestorObservable.notificarObservadores(suplemento);
        }
        return registrado;
    }

    public boolean actualizarSuplemento(SuplementoDTO suplemento) {
        boolean actualizado = suplementoService.actualizarSuplemento(suplemento);
        if (actualizado) {
            gestorObservable.notificarObservadores(suplemento);
        }
        return actualizado;
    }

    public boolean eliminarSuplemento(int id) {
        return suplementoService.eliminarSuplemento(id);
    }

    public SuplementoDTO buscarSuplementoPorId(int id) {
        return suplementoService.buscarPorId(id);
    }

    public ArrayList<SuplementoDTO> obtenerListaSuplementos() {
        return suplementoService.listarSuplementos();
    }

    public ArrayList<SuplementoDTO> obtenerTodos() {
        return suplementoService.obtenerTodos();
    }

    public ArrayList<SuplementoDTO> obtenerOrdenados(EstrategiaOrdenamiento estrategia) {
        ArrayList<SuplementoDTO> lista = suplementoService.obtenerTodos();

        OrdenadorSuplementos ordenador = new OrdenadorSuplementos();
        ordenador.setEstrategia(estrategia);
        ordenador.ordenar(lista);

        return lista;
    }
}
