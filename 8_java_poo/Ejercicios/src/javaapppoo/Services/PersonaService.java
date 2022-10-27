/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapppoo.Services;

import java.util.Scanner;
import javaapppoo.Entity.Persona;

/**
 *
 * @author A309436
 */
public class PersonaService {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public Persona crearPersona() {

        Persona p1 = new Persona();
        boolean bandera = true;

        System.out.println("Ingrese el nombre");
        p1.setNombre(leer.next());
        System.out.println("Ingrese la edad");
        p1.setEdad(leer.nextInt());

        do {
            System.out.println("Ingrese el sexo con la letra que corresponde");
            System.out.println("H -> Hombre");
            System.out.println("M -> Mujer");
            System.out.println("O -> Otro");
            p1.setSexo(leer.next());

            if (p1.getSexo().equalsIgnoreCase("O") || p1.getSexo().equalsIgnoreCase("M") || p1.getSexo().equalsIgnoreCase("H")) {
                bandera = false;
            } else {
                System.out.println("Solo se admiten alguna de las tres opciones (\"O\", \"M\" o \"H\")");
            }

        } while (bandera);

        System.out.println("Ingrese el peso");
        p1.setPeso(leer.nextDouble());

        System.out.println("Ingrese la alutra");
        p1.setAltura(leer.nextDouble());

        return p1;

    }

    public int calcularIMC(Persona p1) {

        double indice;

        indice = p1.getPeso() / Math.pow(p1.getAltura(), 2);

        if (indice < 20) {
            System.out.println(p1.getNombre() + " está por debajo del peso ideal");
            return -1;

        } else if (indice <= 25) {
            System.out.println(p1.getNombre() + " está en el peso ideal");
            return 0;
        }
        System.out.println(p1.getNombre() + " está por encima del peso ideal");
        return 1;
    }

    public boolean esMayorDeEdad(Persona p1) {

        if (p1.getEdad() > 17) {
            System.out.println(p1.getNombre() + " es mayor de edad");
            return true;
        }
        System.out.println(p1.getNombre() + " es menor de edad");
        return false;

    }

}
