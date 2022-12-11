/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package relacionesentidades;

import Entity.Perro;
import Entity.Persona;
import Services.AdopcionService;
import java.util.ArrayList;

/**
 *
 * @author A309436
 */
public class Ejercicio01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Realizar un programa para que una Persona pueda adoptar un Perro. Vamos a contar de dos
        //clases. Perro, que tendrá como atributos: nombre, raza, edad y tamaño; y la clase Persona con
        //atributos: nombre, apellido, edad, documento y Perro.
        //Ahora deberemos en el main crear dos Personas y dos Perros. Después, vamos a tener que
        //pensar la lógica necesaria para asignarle a cada Persona un Perro y por ultimo, mostrar desde
        //la clase Persona, la información del Perro y de la Persona.
        
        //Ahora se debe realizar unas mejoras al ejercicio de Perro y Persona. Nuestro programa va a
        //tener que contar con muchas personas y muchos perros. El programa deberá preguntarle a
        //cada persona, que perro según su nombre, quiere adoptar. Dos personas no pueden adoptar
        //al mismo perro, si la persona eligió un perro que ya estaba adoptado, se le debe informar a la
        //persona.
        //Una vez que la Persona elige el Perro se le asigna, al final deberemos mostrar todas las
        //personas con sus respectivos perros.
        AdopcionService ps = new AdopcionService();
        ArrayList<Perro> perros = new ArrayList();
        ArrayList<Perro> perrosAdoptados = new ArrayList();
        ArrayList<Persona> personas = new ArrayList();
        
        ps.iniciarApp(personas, perros, perrosAdoptados);



    }

}
