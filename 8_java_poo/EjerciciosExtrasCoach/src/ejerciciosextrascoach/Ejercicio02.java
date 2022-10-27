/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosextrascoach;

import Entity.Tiempo;
import java.util.Scanner;

/**
 *
 * @author A309436
 */
public class Ejercicio02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//Definir la clase Tiempo, la cual tendrá la hora, minutos y segundos. Definir dos constructores: un
//constructor vacío y otro con la hora, minutos y segundos ingresado por el usuario. Deberá definir
//además, los métodos getters y setters correspondientes, y el método imprimirHoraCompleta().
//Recordar crear una validación sobre las horas, minutos y segundos ingresados por el usuario. Te
//animas a simular el paso del tiempo en consola??????

    Scanner leer = new Scanner(System.in);
    Tiempo tiempo = new Tiempo();
    
        System.out.println("Ingrese la hora");
        tiempo.setHora(leer.next());
        System.out.println("Ingrese los minutos");
        tiempo.setMinuto(leer.next());
        System.out.println("Ingrese los segundos");
        tiempo.setSegundo(leer.next());
        
        tiempo.imprimirHoraCompleta();
    }

}
