/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entity.Perro;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author A309436
 */
public class PerroService {

    Scanner leer = new Scanner(System.in);

    public Perro crearPerro() {

        Perro p = new Perro();

        System.out.println("Ingrese una raza de perro");
        p.setRaza(leer.next());

        return p;
    }

    public void imprimirLista(ArrayList<Perro> lista) {

        lista.forEach((perro) -> {
            System.out.println("- " + perro.toString());
        });

    }

    public void llenarLista(ArrayList<Perro> lista) {
        Perro p;
        String respuesta = "S";

        do {
            p = crearPerro();
            lista.add(p);
            System.out.println("¿Desea agregar otra raza? (S/N)");
            respuesta = leer.next();

        } while (respuesta.equalsIgnoreCase("S"));
    }

    public void eliminarPerro(ArrayList<Perro> lista) {
        String razaEliminada;
        Iterator<Perro> it = lista.iterator();
        boolean razaBorrada = false;

        System.out.println("¿Que raza de perro desea eliminar?");
        razaEliminada = leer.next();

        while (it.hasNext()) {
            if (it.next().getRaza().equalsIgnoreCase(razaEliminada)) {
                razaBorrada = true;
                it.remove();
            }

        }

        if (razaBorrada) {
            System.out.println("El perro de raza: " + razaEliminada + " fue eliminado.");
        } else {
            System.out.println("Ups! la raza: " + razaEliminada + " no existe en la lista");
        }

    }

}
