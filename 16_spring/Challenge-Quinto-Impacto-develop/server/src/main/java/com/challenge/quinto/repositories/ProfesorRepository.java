/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.challenge.quinto.repositories;

import com.challenge.quinto.entities.Profesor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author santi
 */
@Repository
public interface ProfesorRepository extends JpaRepository<Profesor,Integer>{
    
    @Query("SELECT p FROM Profesor p WHERE p.nombre LIKE :nombre%")
    public List<Profesor> getProfesoresByNombre(@Param("nombre") String nombre);
    
    @Query("SELECT p FROM Profesor p WHERE p.role LIKE 'PROFESOR'")
    public List<Profesor> getProfesores();
    
}
