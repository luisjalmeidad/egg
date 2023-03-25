package com.egg.biblioteca.services;

import com.egg.biblioteca.entities.Autor;
import com.egg.biblioteca.entities.Editorial;
import com.egg.biblioteca.entities.Libro;
import com.egg.biblioteca.exceptions.MiException;
import com.egg.biblioteca.repositories.AutorRepository;
import com.egg.biblioteca.repositories.EditorialRepository;
import com.egg.biblioteca.repositories.LibroRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;
    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private EditorialRepository editorialRepository;

    private void validar(Long isbn, String titulo, Integer ejemplares, String idAutor, String idEditorial) throws MiException {
        if (isbn == null) {
            throw new MiException("Debe ingresar el isbn");
        }

        if (ejemplares == null) {
            throw new MiException("Debe ingresar la cantidad de ejemplares");
        }

        if (titulo.isEmpty() || titulo == null) {
            throw new MiException("Debe indicar un titulo");
        }

        if (idAutor.isEmpty() || idAutor == null) {
            throw new MiException("Debe indicar un autor");
        }

        if (idEditorial.isEmpty() || idEditorial == null) {
            throw new MiException("Debe indicar una editorial");
        }
    }

    @Transactional
    public void crearLibro(Long isbn, String titulo, Integer ejemplares, String idAutor, String idEditorial) throws MiException {
        validar(isbn, titulo, ejemplares, idAutor, idEditorial);

        Autor autor = autorRepository.findById(idAutor).get();
        Editorial editorial = editorialRepository.findById(idEditorial).get();

        Libro libro = new Libro();
        libro.setIsbn(isbn);
        libro.setTitulo(titulo);
        libro.setEjemplares(ejemplares);
        libro.setAlta(new Date());
        libro.setAutor(autor);
        libro.setEditorial(editorial);

        libroRepository.save(libro);
    }

    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }

    public Libro getOne(Long id) {
        return libroRepository.getOne(id);
    }

    @Transactional
    public void modificarLibro(Long isbn, String titulo, Integer ejemplares, String idAutor, String idEditorial) throws MiException {
        validar(isbn, titulo, ejemplares, idAutor, idEditorial);

        Optional<Libro> respuesta = libroRepository.findById(isbn);
        Optional<Autor> respuestaAutor = autorRepository.findById(idAutor);
        Optional<Editorial> respuestaEditorial = editorialRepository.findById(idEditorial);

        Autor autor = new Autor();
        Editorial editorial = new Editorial();

        if (respuestaAutor.isPresent()) {
            autor = respuestaAutor.get();
        }

        if (respuestaEditorial.isPresent()) {
            editorial = respuestaEditorial.get();
        }

        if (respuesta.isPresent()) {
            Libro libro = respuesta.get();
            libro.setTitulo(titulo);
            libro.setEjemplares(ejemplares);
            libro.setAutor(autor);
            libro.setEditorial(editorial);
            libroRepository.save(libro);
        }
    }

}
