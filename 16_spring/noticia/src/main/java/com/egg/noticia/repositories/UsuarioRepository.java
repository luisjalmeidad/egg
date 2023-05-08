package com.egg.noticia.repositories;

import com.egg.noticia.entities.Usuario;
import com.egg.noticia.entities.Periodista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    @Query("SELECT u FROM Usuario u WHERE u.nombre = :nombre")
    public Usuario buscarPorNombre(@Param("nombre") String nombre);

    @Query("SELECT u FROM Usuario u WHERE u.activo = 1")
    public List<Usuario> buscarUsuariosActivos();

//@Query("SELECT u FROM Usuario u LEFT JOIN FETCH u.periodista p WHERE u.activo = 1")
//@Query("SELECT u FROM Usuario u LEFT JOIN FETCH u.periodista p")
//    @Query("SELECT u FROM Usuario u JOIN Periodista p ON u.id = p.usuario.id")
//    public List<Usuario> buscarUsuariosYPeriodista();


}
