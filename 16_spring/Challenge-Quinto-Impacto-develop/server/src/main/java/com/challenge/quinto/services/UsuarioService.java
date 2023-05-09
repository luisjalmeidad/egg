/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.challenge.quinto.services;

import com.challenge.quinto.entities.Credencial;
import com.challenge.quinto.entities.Usuario;
import com.challenge.quinto.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author santi
 */
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario loginUsuario(Credencial credencial) {
        Usuario usuario = usuarioRepository.getUsuarioByEmail(credencial.getEmail());
        BCryptPasswordEncoder crypt = new BCryptPasswordEncoder();
        if (usuario == null) {
            return null;
        }
        if (!crypt.matches(credencial.getPassword(), usuario.getPassword())) {
            return null;
        }
        return usuario;
    }

}
