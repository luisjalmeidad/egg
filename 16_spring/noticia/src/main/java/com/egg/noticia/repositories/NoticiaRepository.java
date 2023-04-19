
package com.egg.noticia.repositories;

import com.egg.noticia.entities.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticiaRepository extends JpaRepository<Noticia, String>{

    @Query("SELECT n FROM Noticia n WHERE n.hab = 1")
    public List<Noticia> buscarNoticiasHab();

    @Query("SELECT n FROM Noticia n WHERE n.hab = 1 and n.id = :id")
    public Noticia buscarNoticiaHab(@Param("id") String id);
    
}
