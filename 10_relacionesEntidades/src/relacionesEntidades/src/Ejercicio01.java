/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package relacionesentidades;

import Entity.Perro;
import Entity.Persona;

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

        Perro perro1 = new Perro();
        Perro perro2 = new Perro();
        Persona persona1 = new Persona();
        Persona persona2 = new Persona();

        perro1.setNombre("Luis");
        perro1.setEdad(4);
        perro1.setRaza("Chihuaha");
        perro1.setTamanio(2.1);

        perro2.setNombre("Pedro");
        perro2.setEdad(5);
        perro2.setRaza("Chihuaha");
        perro2.setTamanio(2.5);

        persona1.setNombre("Carlos");
        persona1.setApellido("Hernandez");
        persona1.setDocumento("4649874987");
        persona1.setEdad(15);
        persona1.setPerro(perro1);

        persona2.setNombre("Karen");
        persona2.setApellido("Hernandez");
        persona2.setDocumento("464980007");
        persona2.setEdad(25);
        persona2.setPerro(perro2);

        System.out.println("Persona1");
        System.out.println(persona1.toString());
        System.out.println("Persona2");
        System.out.println(persona2.toString());

    }

}
