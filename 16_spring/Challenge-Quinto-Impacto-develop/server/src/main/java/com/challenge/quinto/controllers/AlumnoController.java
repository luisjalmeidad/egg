/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.challenge.quinto.controllers;

import com.challenge.quinto.entities.dtos.AlumnoDTO;
import com.challenge.quinto.entities.dtos.CursoDTO;
import com.challenge.quinto.services.AlumnoService;
import com.challenge.quinto.services.CursoService;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("/alumnos")
@CrossOrigin(origins = "*")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<AlumnoDTO>> getAllAlumnos() {
        try {
            return ResponseEntity.status(200).body(alumnoService.getAllAlumnos());
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<AlumnoDTO>> getAlumnosByNombre(@RequestParam String nombre) {
        try {
            return ResponseEntity.status(200).body(alumnoService.getAlumnoByNombre(nombre));
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return ResponseEntity.status(400).body(null);
        }
    }

    @GetMapping("/search/{idCurso}/{letter}")
    public ResponseEntity<List<AlumnoDTO>> getByCursoIdAndNameContaining(@PathVariable Integer idCurso, @PathVariable String letter) {
        try {
            return ResponseEntity.status(200).body(alumnoService.getByCursoIdAndNameContaining(idCurso, letter));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }
    }

    @GetMapping("/search/{idCurso}")
    public ResponseEntity<List<AlumnoDTO>> getAlumnosFromCursoById(@PathVariable Integer idCurso) {
        try {

            return ResponseEntity.status(200).body(cursoService.getCursoById(idCurso).getAlumnos());
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlumnoDTO> getAlumnoById(@PathVariable Integer id) {
        try {

            return ResponseEntity.status(200).body(alumnoService.getAlumnoById(id));
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return ResponseEntity.status(400).body(null);
        }

    }

    @PostMapping
    public ResponseEntity<AlumnoDTO> createAlumno(@RequestBody AlumnoDTO alumnoDTO) {
        try {

            return ResponseEntity.status(HttpStatus.CREATED).body(alumnoService.createAlumno(alumnoDTO));
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return ResponseEntity.status(400).body(null);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<AlumnoDTO> updateAlumno(@PathVariable Integer id, @RequestBody AlumnoDTO alumnoDTO) {
        try {
            return ResponseEntity.status(200).body(alumnoService.updateAlumno(id, alumnoDTO));
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return ResponseEntity.status(400).body(null);
        }

    }
    
    @PatchMapping("/{id}")
    public ResponseEntity<AlumnoDTO> addCursosToAlumno(@PathVariable Integer id, @RequestBody List<CursoDTO> cursosDTO) {
        try {
            return ResponseEntity.status(200).body(alumnoService.addCursosToAlumno(id, cursosDTO));
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return ResponseEntity.status(400).body(null);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAlumno(@PathVariable Integer id) {
        try {
            alumnoService.deleteAlumno(id);
            return ResponseEntity.ok("Alumno deleted successfuly");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return ResponseEntity.status(400).body(null);
        }

    }
}
