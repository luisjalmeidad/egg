/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.challenge.quinto.entities.dtos;

import com.challenge.quinto.enums.Role;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author santi
 */
@Getter
@Setter
public class UsuarioDTO {
    protected Integer id;
    protected String email;
    protected String password;
    protected Role role;
}
