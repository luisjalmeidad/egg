package com.egg.noticia.services;

import com.egg.noticia.entities.Usuario;
import com.egg.noticia.enumeraciones.Rol;
import com.egg.noticia.exceptions.MiException;
import com.egg.noticia.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UsuarioService  implements UserDetailsService{

    @Autowired
    private UsuarioRepository usuarioRepository;


    private void validar(String nombre, String clave, String clave2) throws MiException{

        if (nombre.isEmpty() || nombre == null) {
            throw new MiException("El nombre no puede estar vacío");
        }

        if (clave.isEmpty() || clave == null || clave.length() < 3){
            throw new MiException("Debe ingresar una clave de al menos 3 digitos");
        }

        if (!clave.equals(clave2)){
            throw new MiException("Las claves deben ser iguales");
        }

    }

    @Transactional
    public void registrar(String nombre, String clave, String clave2) throws MiException{
        validar(nombre, clave, clave2);
        Usuario usuario = new Usuario();

        usuario.setNombre(nombre);
        usuario.setClave(new BCryptPasswordEncoder().encode(clave));
        usuario.setRol(Rol.USER);
        usuario.setActivo(true);
        usuario.setFechaAlta(new Date());

        usuarioRepository.save(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {

        Usuario usuario = usuarioRepository.buscarPorNombre(nombre);

        if (usuario != null){
            List<GrantedAuthority> permisos = new ArrayList();

            GrantedAuthority p = new SimpleGrantedAuthority("ROLE_" + usuario.getRol());

            permisos.add(p);

            return new User(usuario.getNombre(), usuario.getClave(), permisos);
        }

        return null;
    }
}
