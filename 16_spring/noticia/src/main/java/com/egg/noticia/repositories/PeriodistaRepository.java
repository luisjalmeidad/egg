package com.egg.noticia.repositories;

import com.egg.noticia.entities.Periodista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodistaRepository extends JpaRepository<Periodista, String> {

}
