/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.persistencia;

import java.util.List;
import libreria.entities.Autor;

/**
 *
 * @author A309436
 */
public class AutorDAO extends DAO<Autor> {

    public void insertarAutor(Autor autor) {
        super.guardar(autor);
    }

    public void eliminarAutor(Autor autor) {
        super.eliminar(autor);
    }

    public void modificarAutor(Autor autor) {
        super.editar(autor);
    }

    public Autor consultarAutorNombre(String nombre) {
        conectar();
        Autor autor = em.createQuery("SELECT a FROM Autor a WHERE NOMBRE = :nombre", Autor.class)
                .setParameter("nombre", nombre)
                .getSingleResult();
        desconectar();
        return autor;
    }

    public List<Autor> consultarAutores() {
        conectar();
        List<Autor> autores = em.createQuery("SELECT a FROM Autor a ", Autor.class)
                .getResultList();
        desconectar();
        return autores;
    }
}
