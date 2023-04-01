
package com.egg.noticia.repositories;

import com.egg.noticia.entities.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticiaRepository extends JpaRepository<Noticia, String>{
    
}
