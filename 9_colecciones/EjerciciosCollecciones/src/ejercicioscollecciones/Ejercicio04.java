/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioscollecciones;

import Entity.Pelicula;
import Services.PeliculaService;
import java.util.ArrayList;

/**
 *
 * @author A309436
 */
public class Ejercicio04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        PeliculaService ps = new PeliculaService();
        ArrayList<Pelicula> lista = new ArrayList();
        ps.agregarPeliculaEnLista(lista);
        System.out.println("Lista de peliculas");
        ps.imprimirPeliculas(lista);
        System.out.println("Lista de peliculas con mas de 1 hora de duracion");
        ps.imprimirPeliculas(lista, 1);
        System.out.println("Lista de peliculas ordenadas por duracion");
        ps.ordenarListaPorDuracion(lista);
        ps.imprimirPeliculas(lista);
        System.out.println("Lista de peliculas ordenadas por duracion desc");
        ps.ordenarListaPorDuracionDesc(lista);        
        ps.imprimirPeliculas(lista);
        System.out.println("Lista de peliculas ordenadas por titulo");
        ps.ordenarListaPorTitulo(lista);
        ps.imprimirPeliculas(lista);
        System.out.println("Lista de peliculas ordenadas por director");
        ps.ordenarListaPorDirector(lista);
        ps.imprimirPeliculas(lista);
    }
    
}
