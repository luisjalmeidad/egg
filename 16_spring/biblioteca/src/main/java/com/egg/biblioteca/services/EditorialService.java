package com.egg.biblioteca.services;

import com.egg.biblioteca.entities.Editorial;
import com.egg.biblioteca.exceptions.MiException;
import com.egg.biblioteca.repositories.EditorialRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditorialService {

    @Autowired
    private EditorialRepository editorialRepository;

    private void validar(String nombre) throws MiException {
        if (nombre == null || nombre.isEmpty()) {
            throw new MiException("Debe ingresar un nombre");
        }
    }

    @Transactional
    public void crearEditorial(String nombre) throws MiException {
        validar(nombre);
        Editorial editorial = new Editorial();
        editorial.setNombre(nombre);
        editorialRepository.save(editorial);
    }

    public List<Editorial> listarEditoriales() {
        List<Editorial> editoriales = new ArrayList();
        editoriales = editorialRepository.findAll();
        return editoriales;
    }

    public Editorial getOne(String id) {
        return editorialRepository.getOne(id);
    }

    @Transactional
    public void modificarEditorial(String idEditorial, String nombre) throws MiException {
        validar(nombre);
        Optional<Editorial> respuesta = editorialRepository.findById(nombre);

        if (respuesta.isPresent()) {
            Editorial editorial = respuesta.get();
            editorial.setNombre(nombre);
            editorialRepository.save(editorial);
        }
    }
}
