package com.egg.biblioteca.controllers;

import com.egg.biblioteca.entities.Editorial;
import com.egg.biblioteca.exceptions.MiException;
import com.egg.biblioteca.services.EditorialService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/editorial")
public class EditorialController {

    @Autowired
    private EditorialService editorialService;

    @GetMapping("/registrar")
    public String index() {
        return "editorial_form.html";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam String nombre, ModelMap model) {

        try {
            editorialService.crearEditorial(nombre);
            model.put("exito", "Editorial creada");
        } catch (MiException ex) {
            model.put("error", ex.getMessage());
            return "editorial_form.html";
        }
        return "index.html";
    }

    @GetMapping("/lista")
    public String listar(ModelMap model) {
        List<Editorial> editoriales = editorialService.listarEditoriales();
        model.addAttribute("editoriales", editoriales);
        return "editorial_list.html";
    }

//    @GetMapping("/modificar/{id}")
//    public String modificar(@PathVariable String id, ModelMap modelo) {
//        modelo.put("editorial", editorialService.getOne(id));
//        return "editorial_modificar.html";
//    }
//
//    @PostMapping("/modificar/{id}")
//    public String modificar(@PathVariable String id, String nombre, ModelMap modelo) {
//        try {
//            editorialService.modificarEditorial(id, nombre);
//            return "redirect:../lista";
//        } catch (MiException ex) {
//            modelo.put("error", ex.getMessage());
//            return "editorial_modificar.html";
//        }
//    }
}
