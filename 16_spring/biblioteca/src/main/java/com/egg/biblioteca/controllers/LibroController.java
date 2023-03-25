package com.egg.biblioteca.controllers;

import com.egg.biblioteca.entities.Autor;
import com.egg.biblioteca.entities.Editorial;
import com.egg.biblioteca.entities.Libro;
import com.egg.biblioteca.exceptions.MiException;
import com.egg.biblioteca.services.AutorService;
import com.egg.biblioteca.services.EditorialService;
import com.egg.biblioteca.services.LibroService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/libro")
public class LibroController {

    @Autowired
    private LibroService libroService;
    @Autowired
    private AutorService autorService;
    @Autowired
    private EditorialService editorialService;

    @GetMapping("/registrar")
    public String index(ModelMap model) {
        List<Autor> autores = autorService.listarAutores();
        List<Editorial> editoriales = editorialService.listarEditoriales();

        model.addAttribute("autores", autores);
        model.addAttribute("editoriales", editoriales);

        return "libro_form.html";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam(required = false) Long isbn, @RequestParam String titulo,
            @RequestParam(required = false) Integer ejemplares, @RequestParam String idAutor,
            @RequestParam String idEditorial, ModelMap model) {

        try {
            libroService.crearLibro(isbn, titulo, ejemplares, idAutor, idEditorial);
            model.put("exito", "Libro creado");
        } catch (MiException ex) {
            List<Autor> autores = autorService.listarAutores();
            List<Editorial> editoriales = editorialService.listarEditoriales();

            model.addAttribute("autores", autores);
            model.addAttribute("editoriales", editoriales);
            model.put("error", ex.getMessage());
            return "libro_form.html";
        }
        return "index.html";
    }
    
    @GetMapping("/lista")
    public String listar(ModelMap model){
        List<Libro> libros = libroService.listarLibros();
        model.addAttribute("libros", libros);
        return "libro_list.html";
    }
}
