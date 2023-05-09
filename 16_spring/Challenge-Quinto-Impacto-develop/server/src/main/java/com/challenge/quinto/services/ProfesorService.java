/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.challenge.quinto.services;

import com.challenge.quinto.entities.Curso;
import com.challenge.quinto.entities.Profesor;
import com.challenge.quinto.entities.converters.CursoConverter;
import com.challenge.quinto.entities.converters.ProfesorConverter;
import com.challenge.quinto.entities.dtos.CursoDTO;
import com.challenge.quinto.entities.dtos.ProfesorDTO;
import com.challenge.quinto.enums.Role;
import com.challenge.quinto.repositories.ProfesorRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author santi
 */
@Service
public class ProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;

    @Autowired
    private ProfesorConverter profesorConverter;

    @Autowired
    private CursoConverter cursoConverter;
    
    @Autowired
    private CursoService cursoService;
    

    @Transactional(readOnly = true)
    public List<ProfesorDTO> getAllProfesores() {
        List<Profesor> profesores = profesorRepository.getProfesores();
        return profesorConverter.toDTO(profesores);
    }

    @Transactional(readOnly = true)
    public List<ProfesorDTO> getProfesoresByNombre(String nombre) {
        List<Profesor> profesores = profesorRepository.getProfesoresByNombre(nombre);
        return profesorConverter.toDTO(profesores);
    }

    @Transactional
    public ProfesorDTO addCursosToProfesor(Integer id, List<CursoDTO> cursosDTO) {
        Profesor profesor = profesorRepository.findById(id).get();
        List<Curso> cursos = cursoConverter.fromDTO(cursosDTO);
        for (Curso curso : cursos) {
            curso.setProfesor(profesor);
        }
        profesor.getCursos().addAll(cursos);
        profesorRepository.save(profesor);
        return profesorConverter.toDTO(profesor);
    }
    
    @Transactional
    public ProfesorDTO deleteCursoFromProfesor(Integer idProfesor, Integer idCurso){
        Profesor profesor = profesorRepository.findById(idProfesor).get();
        CursoDTO cursoDTO = cursoService.getCursoById(idCurso);
        cursoDTO.setProfesor(null);
        cursoDTO = cursoService.updateCurso(idCurso, cursoDTO);
        Curso curso = cursoConverter.fromDTO(cursoDTO);
        profesor.getCursos().remove(curso);
        profesorRepository.saveAndFlush(profesor);
        return profesorConverter.toDTO(profesor);
    }

    @Transactional(readOnly = true)
    public ProfesorDTO getProfesorById(Integer id) {
        Profesor profesor = profesorRepository.findById(id).orElse(null);
        return profesorConverter.toDTO(profesor);
    }

    @Transactional
    public ProfesorDTO createProfesor(ProfesorDTO profesorDTO) {
        profesorDTO.setPassword(new BCryptPasswordEncoder().encode(profesorDTO.getPassword()));
        profesorDTO.setRole(Role.PROFESOR);
        Profesor profesor = profesorConverter.fromDTO(profesorDTO);
        profesor = profesorRepository.save(profesor);
        return profesorConverter.toDTO(profesor);
    }

    @Transactional
    public ProfesorDTO updateProfesor(Integer id, ProfesorDTO profesorDTO) {
        Profesor profesor = profesorRepository.findById(id).orElse(null);
        if (profesor != null) {
            profesorDTO.setPassword(new BCryptPasswordEncoder().encode(profesorDTO.getPassword()));
            profesorDTO.setRole(profesor.getRole());
            profesor = profesorConverter.fromDTO(profesorDTO);
            profesor.setId(id);
            profesor = profesorRepository.save(profesor);
            return profesorConverter.toDTO(profesor);
        }
        return null;
    }

    @Transactional
    public void deleteProfesor(Integer id) {
        profesorRepository.deleteById(id);
    }

}
