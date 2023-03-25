package com.egg.biblioteca.services;

import com.egg.biblioteca.entities.Autor;
import com.egg.biblioteca.exceptions.MiException;
import com.egg.biblioteca.repositories.AutorRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    private void validar(String nombre) throws MiException {
        if (nombre == null || nombre.isEmpty()) {
            throw new MiException("Debe ingresar un nombre");
        }
    }

    @Transactional
    public void crearAutor(String nombre) throws MiException {
        validar(nombre);
        Autor autor = new Autor();
        autor.setNombre(nombre);
        autorRepository.save(autor);
    }

    public List<Autor> listarAutores() {
        List<Autor> autores = new ArrayList();
        autores = autorRepository.findAll();
        return autores;
    }
    
    public Autor getOne(String id){
        return autorRepository.getOne(id);
    }

    @Transactional
    public void modificarAutor(String idAutor, String nombre) throws MiException {
        validar(nombre);
        Optional<Autor> respuesta = autorRepository.findById(idAutor);

        if (respuesta.isPresent()) {
            Autor autor = respuesta.get();
            autor.setNombre(nombre);
            autorRepository.save(autor);
        }
    }
}
