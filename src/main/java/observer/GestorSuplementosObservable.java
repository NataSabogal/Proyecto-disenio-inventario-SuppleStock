/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package observer;

import dto.SuplementoDTO;
import java.util.ArrayList;

/**
 *
 * @author nataliasabogalrada
 */
public class GestorSuplementosObservable {
    private final ArrayList<ObservadorSuplemento> observadores = new ArrayList<>();

    public void agregarObservador(ObservadorSuplemento observador) {
        observadores.add(observador);
    }

    public void notificarObservadores(SuplementoDTO suplemento) {
        for (ObservadorSuplemento obs : observadores) {
            obs.notificar(suplemento);
        }
    }
}
