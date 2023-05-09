/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.challenge.quinto.controllers;

import com.challenge.quinto.entities.dtos.CursoDTO;
import com.challenge.quinto.entities.dtos.ProfesorDTO;
import com.challenge.quinto.services.ProfesorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
@RequestMapping("/profesores")
public class ProfesorController {
    @Autowired
    private ProfesorService profesorService;

    @GetMapping
    public ResponseEntity<List<ProfesorDTO>> getAllProfesores() {
        try {
            return ResponseEntity.status(200).body(profesorService.getAllProfesores());
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }
        
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<ProfesorDTO>> getProfesoresByNombre(@RequestParam String nombre) {
        try {
            return ResponseEntity.status(200).body(profesorService.getProfesoresByNombre(nombre));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }   
    }
    
    @PatchMapping("/{idProfesor}/{idCurso}")
    public ResponseEntity<ProfesorDTO> deleteCursoFromProfesor(@PathVariable Integer idProfesor, @PathVariable Integer idCurso){
        try {
            return ResponseEntity.status(200).body(profesorService.deleteCursoFromProfesor(idProfesor, idCurso));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(400).body(null);
        } 
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfesorDTO> getProfesorById(@PathVariable Integer id) {
        try {
            return ResponseEntity.status(200).body(profesorService.getProfesorById(id));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }
        
    }

    @PostMapping
    public ResponseEntity<ProfesorDTO> createProfesor(@RequestBody ProfesorDTO profesorDTO) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(profesorService.createProfesor(profesorDTO));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }
        
    }
    
    @PatchMapping("/{id}")
    public ResponseEntity<ProfesorDTO> addCursosToProfesor(@PathVariable Integer id, @RequestBody List<CursoDTO> cursosDTO) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(profesorService.addCursosToProfesor(id, cursosDTO));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfesorDTO> updateProfesor(@PathVariable Integer id, @RequestBody ProfesorDTO profesorDTO) {
        try {
            return ResponseEntity.status(200).body(profesorService.updateProfesor(id, profesorDTO));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProfesor(@PathVariable Integer id) {
        try {
            profesorService.deleteProfesor(id);
            return ResponseEntity.status(200).body("Profesor deleted successfuly");
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }
        
    }
}
