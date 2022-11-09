/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entity.Pelicula;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author A309436
 */
public class PeliculaService {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public Pelicula crearPelicula() {
        Pelicula p = new Pelicula();

        System.out.println("Ingrese el nombre de la pelicula");
        p.setTitulo(leer.next());
        System.out.println("Indique el director de la pelicula");
        p.setDirector(leer.next());
        System.out.println("Ingrese la duracion en horas de la pelicula");
        p.setDuracion(leer.nextDouble());

        return p;
    }

    public void agregarPeliculaEnLista(ArrayList<Pelicula> lista) {
        String respuesta = "S";

        do {
            lista.add(crearPelicula());
            System.out.println("¿Desea agregar otra pelicula? S/N ");
            respuesta = leer.next();
        } while (respuesta.equalsIgnoreCase("S"));

    }

    public void imprimirPeliculas(ArrayList<Pelicula> lista) {
        lista.forEach((pelicula) -> {
            System.out.println(pelicula.toString());
        });
    }

    public void imprimirPeliculas(ArrayList<Pelicula> lista, double hora) {
        lista.forEach((pelicula) -> {
            if (pelicula.getDuracion() > hora) {
                System.out.println(pelicula.toString());
            }

        });
    }

    public void ordenarListaPorDuracion(ArrayList<Pelicula> lista) {
        lista.sort(Pelicula.compararDuracion);
    }
    
    public void ordenarListaPorDuracionDesc(ArrayList<Pelicula> lista) {
        lista.sort(Pelicula.compararDuracionDesc);
    }
    
    public void ordenarListaPorTitulo(ArrayList<Pelicula> lista) {
        lista.sort(Pelicula.compararTitulo);
    }

    public void ordenarListaPorDirector(ArrayList<Pelicula> lista) {
        lista.sort(Pelicula.compararDirector);
    }

}
