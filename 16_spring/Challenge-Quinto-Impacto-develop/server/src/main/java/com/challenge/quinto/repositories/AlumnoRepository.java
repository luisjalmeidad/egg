/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.challenge.quinto.repositories;

import com.challenge.quinto.entities.Alumno;
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
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {
    
    @Query("SELECT a FROM Alumno a JOIN a.cursos c WHERE c.id = :idCurso AND a.nombre LIKE %:letter%")
    public List<Alumno> findByCursoIdAndNameContaining(@Param("idCurso") Integer idCurso, @Param("letter") String letter);
    
    @Query("SELECT a FROM Alumno a WHERE a.nombre LIKE :nombre%")
    public List<Alumno> getAlumnoByNombre(@Param("nombre") String nombre);
    
    @Query("SELECT a FROM Alumno a WHERE a.role LIKE 'ALUMNO'")
    public List<Alumno> getAlumnos();
    
}
