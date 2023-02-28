/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.services;

import java.util.List;
import java.util.Scanner;
import libreria.entities.Autor;
import libreria.persistencia.AutorDAO;

/**
 *
 * @author A309436
 */
public class AutorService {

    private Scanner leer = new Scanner(System.in).useDelimiter("\n");

    private final AutorDAO DAO;

    public AutorService() {
        this.DAO = new AutorDAO();
    }

    public Autor crearAutor() {
        Autor autor = new Autor();
        try {
            System.out.println("\n//----------------- Crear un autor -----------------\\\\");
            System.out.println("Indique el nombre del autor");
            String nombre = leer.next();
            autor.setAlta(true);
            autor.setNombre(nombre);
            DAO.insertarAutor(autor);
            return autor;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void eliminarAutor(Autor autor) {
        try {
            DAO.eliminarAutor(autor);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminarAutor() {
        try {
            System.out.println("Elija el autor a eliminar");
            List<Autor> autores = imprimirAutores();
            int op = leer.nextInt() - 1;
            eliminarAutor(autores.get(op));
            System.out.println("Autor eliminado con éxito");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void modificarAutor(Autor autor) {
        try {
            DAO.modificarAutor(autor);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void modificarAutor() {
        try {
            System.out.println("Elija el autor a modificar");
            List<Autor> autores = imprimirAutores();
            int op = leer.nextInt() - 1;
            System.out.println("Indique el nuevo nombre del autor " + autores.get(op).getNombre());
            String nombre = leer.next();
            autores.get(op).setNombre(nombre);
            modificarAutor(autores.get(op));
            System.out.println("Nombre modificado con éxito");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Autor consultarAutorNombre(String nombre) {
        try {
            return DAO.consultarAutorNombre(nombre);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Autor> consultarAutores() {
        try {
            return DAO.consultarAutores();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Autor> imprimirAutores() {
        try {
            System.out.println("\n//----------------- Lista de autores -----------------\\\\");
            List<Autor> autores = consultarAutores();
            System.out.println("0 - Crear un nuevo Autor");
            for (int i = 0; i < autores.size(); i++) {
                System.out.println((i + 1) + " - " + autores.get(i).getNombre());
            }
            return autores;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
