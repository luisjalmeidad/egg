/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapppoo.Services;

import java.util.Scanner;
import javaapppoo.Entity.Libro;

/**
 *
 * @author A309436
 */
public class LibroService {
    
    public void cargarLibro() {

        Scanner leer = new Scanner(System.in);
        
        Libro libro = new Libro();

        System.out.println("Ingrese el ISBN");
        libro.setIsbn(leer.nextLine());
        System.out.println("Ingrese el titulo");
        libro.setTitulo(leer.nextLine());
        System.out.println("Ingrese el autor");
        libro.setAutor(leer.nextLine());
        System.out.println("Ingrese el número de páginas");
        libro.setNumPaginas(leer.nextInt());
    }
    
}
