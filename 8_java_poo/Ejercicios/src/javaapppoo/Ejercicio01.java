/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapppoo;

import javaapppoo.Entity.Libro;
import javaapppoo.Services.LibroService;

/**
 *
 * @author A309436
 */
public class Ejercicio01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    //Crear una clase llamada Libro que contenga los siguientes atributos: ISBN, Título, Autor,
    //Número de páginas, y un constructor con todos los atributos pasados por parámetro y un
    //constructor vacío. Crear un método para cargar un libro pidiendo los datos al usuario y
    //luego informar mediante otro método el número de ISBN, el título, el autor del libro y el
    //numero de páginas.
    
        LibroService lib = new LibroService();
        
        lib.cargarLibro();
        System.out.println("Libro cargado: " + lib.toString());

    }

}
