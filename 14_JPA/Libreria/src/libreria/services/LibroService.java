/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.services;

import java.util.List;
import java.util.Scanner;
import libreria.entities.Autor;
import libreria.entities.Editorial;
import libreria.entities.Libro;
import static libreria.entities.Libro_.autor;
import libreria.persistencia.LibroDAO;

/**
 *
 * @author A309436
 */
public class LibroService {

    private Scanner leer = new Scanner(System.in).useDelimiter("\n");
    private AutorService autorService;
    private EditorialService editorialService;
    private final LibroDAO DAO;

    public LibroService() {
        this.DAO = new LibroDAO();
    }

    public void setServicios(AutorService autorService, EditorialService editorialService) {
        this.autorService = autorService;
        this.editorialService = editorialService;
    }

    public Libro crearLibro(Long isbn, String titulo, Integer anio, Integer ejemplares, Autor autor, Editorial editorial) {
        Libro lib = new Libro();
        try {
            lib.setIsbn(isbn);
            lib.setTitulo(titulo);
            lib.setAnio(anio);
            lib.setEjemplares(ejemplares);
            lib.setEjemplaresPrestados(0);
            lib.setEjemplaresRestantes(ejemplares);
            lib.setAlta(true);
            lib.setAutor(autor);
            lib.setEditorial(editorial);
            DAO.insertarLibro(lib);
            return lib;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<Libro> buscarLibros() {
        System.out.println("\n//----------------- Lista de Libros -----------------\\\\");
        List<Libro> libros = DAO.buscarLibros();
        for (int i = 0; i < libros.size(); i++) {
            Libro libro = libros.get(i);
            System.out.println((i + 1) + " - " + libro.getTitulo());
        }
        return libros;
    }
    
    public Libro buscarLibroPorISBN(Long ISBN){
        try {
        return DAO.buscarLibroPorISBN(ISBN);            
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }
    }
    
    public Boolean validaLibroDuplicado(Long ISBN){
        Libro libro = buscarLibroPorISBN(ISBN);
        
    }

    public Libro crearLibro() {
        System.out.println("\n//----------------- Crear un libro -----------------\\\\");
        System.out.println("Indique el ISBN");
        Long isbn = leer.nextLong();
        System.out.println("Indique el titulo");
        String titulo = leer.next();
        System.out.println("Indique el año");
        Integer anio = leer.nextInt();
        System.out.println("Indique la cantidad de ejemplares a registrar");
        Integer ejemplares = leer.nextInt();
        System.out.println("Indique el autor del libro");
        List<Autor> autores = autorService.imprimirAutores();
        int op = leer.nextInt() - 1;
        Autor autor = autores.get(op);
        System.out.println("Autor " + autor.getNombre() + " fue asignado al libro.");
        System.out.println("Indique la Editorial del libro");
        List<Editorial> editoriales = editorialService.imprimirEditoriales();
        op = leer.nextInt() - 1;
        Editorial editorial = editoriales.get(op);
        System.out.println("Editorial " + editorial.getNombre() + " fue asignada al libro.");
        return crearLibro(isbn, titulo, anio, ejemplares, autor, editorial);
    }

    public void eliminarLibro() {
        try {
            System.out.println("Elija el libro a eliminar");
            List<Libro> libros = buscarLibros();
            int op = leer.nextInt() - 1;
            DAO.eliminarLibro(libros.get(op));
            System.out.println("libro eliminado con éxito");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void modificarLibro(Libro lib) {
        try {
            DAO.modificarLibro(lib);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void modificarLibro() {
        try {
            Boolean salir = false;
            Autor autor = new Autor();
            Editorial editorial = new Editorial();
            System.out.println("Elija el libro a modificar");
            List<Libro> libros = buscarLibros();
            int op = leer.nextInt() - 1;
            Libro libro = libros.get(op);

            do {
                System.out.println("Indique el dato que desea modificar");
                System.out.println("1. Titulo");
                System.out.println("2. Autor");
                System.out.println("3. Editorial");
                System.out.println("4. Cantidad de Ejemplares");
                System.out.println("5. ISBN");
                System.out.println("\n0. Salir");
                op = leer.nextInt();

                if (op == 0) {
                    salir = true;
                }

                switch (op) {
                    case 1:
                        System.out.println("Ingrese el nuevo titulo");
                        libro.setTitulo(leer.next());
                        DAO.modificarLibro(libro);
                        break;
                    case 2:
                        System.out.println("Indique el autor del libro");
                        List<Autor> autores = autorService.imprimirAutores();
                        op = leer.nextInt() - 1;
                        if (op == -1) {
                            autor = autorService.crearAutor();
                        } else if (op >= autores.size()) {
                            System.out.println("\"" + op + "\" no es una opción valida");
                            break;
                        } else {
                            autor = autores.get(op);
                        }
                        System.out.println("Autor " + autor.getNombre() + " fue asignado al libro.");
                        libro.setAutor(autor);
                        DAO.modificarLibro(libro);
                        break;
                    case 3:
                        System.out.println("Indique la ediotial del libro");
                        List<Editorial> editoriales = editorialService.imprimirEditoriales();
                        op = leer.nextInt() - 1;
                        if (op == -1) {
                            editorial = editorialService.crearEditorial();
                        } else if (op >= editoriales.size()) {
                            System.out.println("\"" + op + "\" no es una opción valida");
                            break;
                        } else {
                            editorial = editoriales.get(op);
                        }
                        libro.setEditorial(editorial);
                        DAO.modificarLibro(libro);
                        break;
                    case 4:
                        System.out.println("Ingrese la cantidad de ejemplares");
                        Integer ejem = leer.nextInt();
                        libro.setEjemplaresRestantes(ejem + libro.getEjemplaresRestantes());
                        DAO.modificarLibro(libro);
                        break;
                    case 5:
                        System.out.println("Ingrese el nuevo ISBN");
                        libro.setIsbn(leer.nextLong());
                        DAO.modificarLibro(libro);
                        break;
                    default:
                        if (op > 0) {
                            throw new AssertionError();
                        }
                }
            } while (!salir);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    

}
