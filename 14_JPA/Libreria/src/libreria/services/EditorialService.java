/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.services;

import java.util.List;
import java.util.Scanner;
import libreria.entities.Editorial;
import libreria.persistencia.EditorialDAO;

public class EditorialService {

    private final EditorialDAO DAO;
    private Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public EditorialService() {
        this.DAO = new EditorialDAO();
    }

    public Editorial crearEditorial() {
        Editorial ed = new Editorial();
        try {
            System.out.println("\n//----------------- Crear una editorial -----------------\\\\");
            System.out.println("Indique el nombre");    
            String nombre = leer.next();
            ed.setNombre(nombre);
            ed.setAlta(true);
            DAO.insertarEditorial(ed);
            return ed;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void eliminarEditorial(Editorial ed) {
        try {
            DAO.eliminarEditorial(ed);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void eliminarEditorial() {
        try {
            System.out.println("Elija la editorial a eliminar");
            List<Editorial> editoriales = imprimirEditoriales();
            int op = leer.nextInt() - 1;
            eliminarEditorial(editoriales.get(op));
            System.out.println("Editorial eliminada con éxito");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void modificarEditorial(Editorial ed) {
        try {
            DAO.modificarEditorial(ed);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void modificarEditorial() {
        try {
            System.out.println("Elija la editorial a modificar");
            List<Editorial> editoriales = imprimirEditoriales();
            int op = leer.nextInt() - 1;
            System.out.println("Indique el nuevo nombre de la editorial " + editoriales.get(op).getNombre());
            String nombre = leer.next();
            editoriales.get(op).setNombre(nombre);
            modificarEditorial(editoriales.get(op));
            System.out.println("Nombre modificado con éxito");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Editorial consultarEditorialNombre(String nombre) {
        try {
            return DAO.consultarEditorialNombre(nombre);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Editorial> consultarEditoriales() {
        try {
            return DAO.consultarEditoriales();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Editorial> imprimirEditoriales() {
        try {
            System.out.println("\n//----------------- Lista de editoriales -----------------\\\\");
            System.out.println("0 - Crear un nuevo Autor");
            List<Editorial> editoriales = consultarEditoriales();
            for (int i = 0; i < editoriales.size(); i++) {
                System.out.println((i + 1) + " - " + editoriales.get(i).getNombre());
            }
            return editoriales;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
