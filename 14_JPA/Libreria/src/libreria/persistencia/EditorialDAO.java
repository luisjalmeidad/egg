/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.persistencia;

import java.util.List;
import libreria.entities.Editorial;

/**
 *
 * @author A309436
 */
public class EditorialDAO extends DAO<Editorial> {

    public void insertarEditorial(Editorial editorial) {
        super.guardar(editorial);
    }

    public void eliminarEditorial(Editorial editorial) {
        super.eliminar(editorial);
    }

    public void modificarEditorial(Editorial editorial) {
        super.editar(editorial);
    }

    public Editorial consultarEditorialNombre(String nombre) {
        conectar();
        Editorial editorial = em.createQuery("SELECT e FROM Editorial e WHERE NOMBRE = :nombre", Editorial.class)
                .setParameter("nombre", nombre)
                .getSingleResult();
        desconectar();
        return editorial;
    }

    public List<Editorial> consultarEditoriales() {
        conectar();
        List<Editorial> editoriales = em.createQuery("SELECT e FROM Editorial e", Editorial.class)
                .getResultList();
        desconectar(); 
        return editoriales;
    }    
        

}
