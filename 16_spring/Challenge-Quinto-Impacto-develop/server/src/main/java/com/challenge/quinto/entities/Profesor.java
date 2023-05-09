/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.challenge.quinto.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author santi
 */
@Entity
@Getter
@Setter
public class Profesor extends Usuario{
    
    
    private String nombre;
    private String apellido;
    
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "profesor", fetch = FetchType.EAGER)
    private List<Curso> cursos;
    
}
