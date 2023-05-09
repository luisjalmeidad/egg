/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.challenge.quinto.entities.dtos;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author santi
 */
@Getter
@Setter
public class ProfesorDTO extends UsuarioDTO{
    private String nombre;
    private String apellido;
    private List<CursoDTO> cursos;
}
