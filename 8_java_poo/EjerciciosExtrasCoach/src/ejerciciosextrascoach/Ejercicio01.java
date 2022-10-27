/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosextrascoach;

import Entity.Fraccion;
import Service.FraccionService;

/**
 *
 * @author A309436
 */
public class Ejercicio01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//Crear una clase llamada fracción que contenga 4 atributos (denominador y numerador de cada
//fracción). Crear la clase servicio que contenga métodos para sumar, restar, multiplicar y dividir
//fracciones. Mostrar por pantalla un menú de opciones para que el usuario decida que ver. 

    FraccionService fs = new FraccionService();
    Fraccion fr = fs.crearFraccion();    
    fs.operar(fr);
    }

}
