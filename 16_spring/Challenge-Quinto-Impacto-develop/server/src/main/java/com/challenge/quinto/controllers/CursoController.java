/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.challenge.quinto.controllers;

import com.challenge.quinto.entities.dtos.CursoDTO;
import com.challenge.quinto.services.CursoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author santi
 */
@RestController
@RequestMapping("/cursos")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<CursoDTO>> getAllCursos() {
        try {
            return ResponseEntity.status(200).body(cursoService.getAllCursos());
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }
        
    }
    
    @GetMapping("/profesor")
    public ResponseEntity<List<CursoDTO>> getCursosWhereProfesorNotInt() {
        try {
            return ResponseEntity.status(200).body(cursoService.getCursosWhereProfesorNotIn());
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }
        
    }
    @GetMapping("/alumno/{id}")
    public ResponseEntity<List<CursoDTO>> getCursosWhereAlumnoNotInt(@PathVariable Integer id) {
        try {
            return ResponseEntity.status(200).body(cursoService.getCursosWhereAlumnoNotIn(id));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }
        
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<CursoDTO>> getCursosByNombre(@RequestParam String nombre) {
        try {
            return ResponseEntity.status(200).body(cursoService.getCursosByNombre(nombre));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }  
    }
    
    @GetMapping("/remove-profesor/{id}")
    public ResponseEntity<CursoDTO> deleteProfesorFromCurso(@PathVariable Integer id) {
        try {
            return ResponseEntity.status(200).body(cursoService.deleteProfesorFromCurso(id));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }  
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoDTO> getCursoById(@PathVariable Integer id) {
        try {
            return ResponseEntity.status(200).body(cursoService.getCursoById(id));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }
        
    }

    @PostMapping
    public ResponseEntity<CursoDTO> createCurso(@RequestBody CursoDTO cursoDTO) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.createCurso(cursoDTO));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoDTO> updateCurso(@PathVariable Integer id, @RequestBody CursoDTO cursoDTO) {
        try {
            return ResponseEntity.status(200).body(cursoService.updateCurso(id, cursoDTO));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCurso(@PathVariable Integer id) {
        try {
            cursoService.deleteCurso(id);
        return ResponseEntity.status(200).body("Curso deleted successfuly");
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }
        
    }
}
