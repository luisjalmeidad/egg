/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.challenge.quinto.entities.dtos;

import com.challenge.quinto.enums.Turno;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author santi
 */
@Getter
@Setter
public class CursoDTO {
    private Integer id;
    private String nombre;
    private ProfesorDTO profesor;
    private Turno turno;
    private String horario;
    private List<AlumnoDTO> alumnos;
}
