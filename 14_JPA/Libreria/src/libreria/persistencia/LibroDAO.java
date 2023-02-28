/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.persistencia;

import java.util.List;
import libreria.entities.Libro;

/**
 *
 * @author A309436
 */
public class LibroDAO extends DAO<Libro> {

    public void insertarLibro(Libro libro) {
        super.guardar(libro);
    }

    public void eliminarLibro(Libro libro) {
        super.eliminar(libro);
    }

    public void modificarLibro(Libro libro) {
        super.editar(libro);
    }

    public List<Libro> buscarLibros() {
        conectar();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l", Libro.class)
                .getResultList();
        desconectar();
        return libros;
    }

    public Libro buscarLibroPorISBN(Long ISBN) {
        conectar();
        Libro libro = em.createQuery("SELECT l FROM Libro l WHERE ISBN = :ISBN", Libro.class)
                .setParameter("ISBN", ISBN)
                .getSingleResult();
        desconectar();
        return libro;
    }

}
