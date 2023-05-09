/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.challenge.quinto.services;

import com.challenge.quinto.entities.Alumno;
import com.challenge.quinto.entities.Curso;
import com.challenge.quinto.entities.Profesor;
import com.challenge.quinto.entities.converters.AlumnoConverter;
import com.challenge.quinto.entities.converters.CursoConverter;
import com.challenge.quinto.entities.dtos.AlumnoDTO;
import com.challenge.quinto.entities.dtos.CursoDTO;
import com.challenge.quinto.enums.Role;
import com.challenge.quinto.repositories.AlumnoRepository;
import com.challenge.quinto.repositories.CursoRepository;
import com.challenge.quinto.repositories.ProfesorRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author santi
 */
@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private AlumnoConverter alumnoConverter;

    @Transactional(readOnly = true)
    public List<AlumnoDTO> getAllAlumnos() {
        List<Alumno> alumnos = alumnoRepository.getAlumnos();
        return alumnoConverter.toDTO(alumnos);
    }

    @Transactional(readOnly = true)
    public List<AlumnoDTO> getByCursoIdAndNameContaining(Integer idCurso, String nombre) {
        List<Alumno> alumnos = alumnoRepository.findByCursoIdAndNameContaining(idCurso, nombre);
        return alumnoConverter.toDTO(alumnos);
    }

    @Transactional(readOnly = true)
    public AlumnoDTO getAlumnoById(Integer id) {
        Alumno alumno = alumnoRepository.findById(id).orElse(null);
        return alumnoConverter.toDTO(alumno);
    }

    @Transactional(readOnly = true)
    public List<AlumnoDTO> getAlumnoByNombre(String nombre) {
        List<Alumno> alumnos = alumnoRepository.getAlumnoByNombre(nombre);

        return alumnoConverter.toDTO(alumnos);

    }

    @Transactional
    public AlumnoDTO addCursosToAlumno(Integer id, List<CursoDTO> cursosDTO) {
        AlumnoDTO alumnoDTO = getAlumnoById(id);
        alumnoDTO.getCursos().addAll(cursosDTO);
        Alumno alumno = alumnoConverter.fromDTO(alumnoDTO);
        alumno = alumnoRepository.save(alumno);
        return alumnoConverter.toDTO(alumno);
    }

    @Transactional
    public AlumnoDTO createAlumno(AlumnoDTO alumnoDTO) {

        alumnoDTO.setPassword(new BCryptPasswordEncoder().encode(alumnoDTO.getPassword()));
        alumnoDTO.setRole(Role.ALUMNO);
        Alumno alumno = alumnoConverter.fromDTO(alumnoDTO);
        alumno = alumnoRepository.save(alumno);
        return alumnoConverter.toDTO(alumno);
    }

    @Transactional
    public AlumnoDTO updateAlumno(Integer id, AlumnoDTO alumnoDTO) {
        Alumno alumno = alumnoRepository.findById(id).orElse(null);
        if (alumno != null) {
            alumnoDTO.setPassword(new BCryptPasswordEncoder().encode(alumnoDTO.getPassword()));
            alumnoDTO.setRole(alumno.getRole());
            alumno = alumnoConverter.fromDTO(alumnoDTO);
            alumno.setId(id);
            alumno = alumnoRepository.save(alumno);
            return alumnoConverter.toDTO(alumno);
        }
        return null;
    }

    @Transactional
    public void deleteAlumno(Integer id) {
        alumnoRepository.deleteById(id);
    }
}
