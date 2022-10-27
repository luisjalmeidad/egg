/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosextrascoach;

import Entity.Auto;
import Service.AutoService;

/**
 *
 * @author A309436
 */
public class Ejercicio07 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Crea una clase Auto. Como atributos tendrá nombre del dueño, fecha vencimiento carnet, color del
        //vehículo, modelo y KM en motor (deberá ser inicializado por defecto en 7500km),
        //Crear métodos que permitan:
        //● Que un usuario cargue su ficha del auto.
        //● Que el usuario, modifique la titularidad del vehículo.
        //● Indicar un trayecto recorrido, modificando de este modo los KM del motor
        //● Crear un método que indique si es necesario realizar Service al vehículo, considerando que
        //al llegar a los 10.000km corresponde realizarlo.
        
        AutoService as = new AutoService();
        Auto auto = as.crearAuto();
        as.modificarTitular(auto);
        as.actualizarRecorrido(auto);
        as.alertaService(auto);

    }

}
