/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package libreria;

import java.util.List;
import java.util.Scanner;
import libreria.entities.Autor;
import libreria.entities.Editorial;
import libreria.services.AutorService;
import libreria.services.EditorialService;
import libreria.services.LibroService;

/**
 *
 * @author A309436
 */
public class Libreria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        AutorService as = new AutorService();
        EditorialService es = new EditorialService();
        LibroService ls = new LibroService();
        ls.setServicios(as, es);
        int op = 0;

        do {
            System.out.println("//----------------- MENU -----------------\\\\\n");
            System.out.println("1 - Crear un autor");
            System.out.println("2 - Crear una editorial");
            System.out.println("3 - Crear un libro");
            System.out.println("4 - Consultar autores");
            System.out.println("5 - Consultar editoriales");
            System.out.println("6 - Consultar libros");
            System.out.println("7 - Modificar un autor");
            System.out.println("8 - Modificar una editorial");
            System.out.println("9 - Modificar un libro");
            System.out.println("10 - Eliminar un autor");
            System.out.println("11 - Eliminar una editorial");
            System.out.println("12 - Eliminar un libro");
            System.out.println("\nPresione 0 para salir");
            System.out.println("\n//----------------- MENU -----------------\\\\");

            op = leer.nextInt();

            if (op > 0) {

                switch (op) {
                    case 1:
                        as.crearAutor();
                        break;
                    case 2:                        
                        es.crearEditorial();
                        break;
                    case 3:
                        ls.crearLibro();
                        break;
                    case 4:
                        as.imprimirAutores();
                        break;
                    case 5:
                        es.imprimirEditoriales();
                        break;
                    case 6:
                        ls.buscarLibros();                        
                        break;
                    case 7:
                        as.modificarAutor();
                        break;
                    case 8:
                        es.modificarEditorial();
                        break;
                    case 9:
                        ls.modificarLibro();
                        break;
                    case 10:
                        as.eliminarAutor();
                        break;
                    case 11:
                        es.eliminarEditorial();
                        break;
                    case 12:
                        //System.out.println("12 - Eliminar un libro");                     
                        break;
                    default:
                        throw new AssertionError();
                }
            }
        } while (op > 0);

//6) Crear los métodos para persistir entidades en la base de datos librería
//7) Crear los métodos para dar de alta/bajo o editar dichas entidades.
//8) Búsqueda de un Autor por nombre.
//9) Búsqueda de un libro por ISBN.
//10) Búsqueda de un libro por Título. 
//11) Búsqueda de un libro/s por nombre de Autor.
//12) Búsqueda de un libro/s por nombre de Editorial. 
    }

}
