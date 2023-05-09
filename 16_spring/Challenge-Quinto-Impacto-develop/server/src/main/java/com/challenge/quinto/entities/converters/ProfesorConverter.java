/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.challenge.quinto.entities.converters;

import com.challenge.quinto.entities.Profesor;
import com.challenge.quinto.entities.dtos.ProfesorDTO;
import com.challenge.quinto.enums.Role;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author santi
 */
@Component("ProfesorConverter")
public class ProfesorConverter {
    
    @Autowired
    private CursoConverter cursoConverter;
    
    private boolean converting = false;
    
    public ProfesorDTO toDTO(Profesor profesor) {
        if(converting){
            return null;
        }
        converting= true;
        ProfesorDTO profesorDTO = new ProfesorDTO();
        profesorDTO.setId(profesor.getId());
        profesorDTO.setEmail(profesor.getEmail());
        profesorDTO.setPassword(profesor.getPassword());
        profesorDTO.setRole(profesor.getRole());
        profesorDTO.setNombre(profesor.getNombre());
        profesorDTO.setApellido(profesor.getApellido());
        profesorDTO.setCursos(cursoConverter.toDTO(profesor.getCursos()));
        converting = false;
        return profesorDTO;
    }
    public Profesor fromDTO(ProfesorDTO profesorDTO) {
        if(converting){
            return null;
        }
        converting= true;
        Profesor profesor = new Profesor();
        profesor.setId(profesorDTO.getId());
        profesor.setEmail(profesorDTO.getEmail());
        profesor.setPassword(profesorDTO.getPassword());
        profesor.setRole(profesorDTO.getRole());
        profesor.setNombre(profesorDTO.getNombre());
        profesor.setApellido(profesorDTO.getApellido());
        profesor.setCursos(cursoConverter.fromDTO(profesorDTO.getCursos()));
        converting = false;
        return profesor;
    }
    
    public List<ProfesorDTO> toDTO(List<Profesor> profesores) {
        List<ProfesorDTO> profesoresDTO = new ArrayList<>();
        for (Profesor profesor : profesores) {
            profesoresDTO.add(toDTO(profesor));
        }
        return profesoresDTO;
    }
    public List<Profesor> fromDTO(List<ProfesorDTO> profesoresDTO) {
        List<Profesor> profesores = new ArrayList<>();
        for (ProfesorDTO profesorDTO : profesoresDTO) {
            profesores.add(fromDTO(profesorDTO));
        }
        return profesores;
    }
    
}
