/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Entity.Perro;
import Entity.Persona;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author A309436
 */
public class PersonaService {

    Scanner leer = new Scanner(System.in);

    public void inicializarApp(ArrayList<Perro> perros, ArrayList<Persona> personas) {
        perros.add(new Perro("Ronald", "Chihuaha", 4, 2.1));
        perros.add(new Perro("Firu", "Husky", 1, 2.1));
        perros.add(new Perro("Laika", "Golden", 3, 2.1));
        perros.add(new Perro("Loki", "Bulldog", 5, 2.1));
        perros.add(new Perro("Linda", "Pitbull", 2, 2.1));

        personas.add(new Persona("Carlos", "Hernandez", 15, "659987498"));
        personas.add(new Persona("Karen", "Hernandez", 25, "464980007"));
    }

    public void adoptar(Persona persona, Perro perro, ArrayList<Perro> perrosAdoptados) {
        persona.getPerros().add(perro);
        perrosAdoptados.add(perro);
    }

    public void imprimirPerros(ArrayList<Perro> perros) {
        for (int i = 0; i < perros.size(); i++) {
            System.out.println((i + 1) + " - " + perros.get(i).toString());
        }
    }

    public void imprimirAdopciones(ArrayList<Persona> personas) {
        for (int i = 0; i < personas.size(); i++) {
            System.out.println((i + 1) + " - " + personas.get(i).toString());
        }
    }

    public void imprimirClientes(ArrayList<Persona> personas) {
        for (int i = 0; i < personas.size(); i++) {
            System.out.println((i + 1) + " - " + personas.get(i).getNombre() + " " + personas.get(i).getApellido());
        }
    }

    public boolean validarPerroAdoptado(ArrayList<Perro> perrosAdoptados, Perro perro) {
        for (Perro perrosAdoptado : perrosAdoptados) {
            if (perrosAdoptado.getNombre().equalsIgnoreCase(perro.getNombre())) {
                return true;
            }
        }
        return false;
    }

    public void iniciarApp(ArrayList<Persona> personas, ArrayList<Perro> perros, ArrayList<Perro> perrosAdoptados) {
        inicializarApp(perros, personas);
        int persona = 0;
        int perro = 0;
        int opcion = 0;
        int indice = 2;
        do {
            System.out.println("--------------/ Aplicacion para adoptar perros /--------------");

            System.out.println("");

            System.out.println("-------------- MENU --------------");
            System.out.println("1 - Adoptar perro");
            if (perrosAdoptados.size() > 0) {
                indice = 3;
                System.out.println((indice - 1) + " - Ver adopciones");
            }

            System.out.println(indice + " - Salir");
            System.out.println("-------------- MENU --------------");

            do {

                try {
                    opcion = leer.nextInt();
                } catch (Exception e) {
                    leer.next();
                    System.out.println("Ingrese un valor valido");
                }

                if (opcion < 1 || opcion > indice) {
                    System.out.println("La opcion " + opcion + " no esta disponible");
                    System.out.println("Por favor intente con una opcion valida");
                }

            } while (opcion < 1 || opcion > indice);

            System.out.println("");

            switch (opcion) {
                case 1:
                    System.out.println("¿Quien adoptara un perro?");
                    imprimirClientes(personas);
                    persona = leer.nextInt() - 1;
                    System.out.println("¿Que perro desea adoptar?");
                    imprimirPerros(perros);
                    perro = leer.nextInt() - 1;
                    if (!validarPerroAdoptado(perrosAdoptados, perros.get(perro))) {
                        adoptar(personas.get(persona), perros.get(perro), perrosAdoptados);
                    } else {
                        System.out.println("El perro " + perros.get(perro).toString() + " ya fue adoptado");
                    }
                    break;
                case 2:
                    if (indice == 3) {
                        imprimirAdopciones(personas);
                    }
                    break;
                default:
                    opcion = indice;
            }

        } while (indice != opcion);
    }
}
