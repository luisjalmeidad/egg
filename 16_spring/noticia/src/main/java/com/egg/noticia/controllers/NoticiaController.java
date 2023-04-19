
package com.egg.noticia.controllers;

import com.egg.noticia.entities.Noticia;
import com.egg.noticia.exceptions.MiException;
import com.egg.noticia.services.NoticiaService;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/noticia")
public class NoticiaController {

    @Autowired
    private NoticiaService noticiaService;

    @GetMapping("/registrar")
    public String index() {
        return "noticia_form.html";
    }

    @PostMapping("/registro")
    public String crearNoticia(
            @RequestParam String titulo,
            @RequestParam String cuerpo,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fecha,
            ModelMap model) {
        try {
            noticiaService.crearNoticia(titulo, cuerpo, fecha);
            model.put("exito", "Noticia registrada");
            return "noticia_form.html";
        } catch (MiException ex) {
            model.put("error", ex.getMessage());
            return "noticia_form.html";
        }
    }
    @GetMapping("{id}")
    public String verNoticia(@PathVariable String id, ModelMap model) {
        Noticia noticia = noticiaService.getOne(id);
        model.addAttribute("noticia", noticia);
        return "noticia.html";
    }
    @GetMapping("/lista")
    public String listarNoticias(ModelMap model) {
        List<Noticia> noticias = noticiaService.listarNoticias();
        model.addAttribute("noticias", noticias);
        return "noticia_list.html";
    }
    @GetMapping("/modificar/{id}")
    public String modificarNoticia(@PathVariable String id, ModelMap model) {
        model.put("noticia", noticiaService.getOne(id));
        return "noticia_modificar.html";
    }
    @PostMapping("/modificar/{id}")
    public String modificarNoticia(
            @PathVariable String id,
            String titulo,
            String cuerpo,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fecha,
            ModelMap model) {

        try {
            noticiaService.modificarNoticia(id, titulo, cuerpo, fecha);
            model.put("exito", "Registro modificado con éxito");
            return "redirect:../lista";
        } catch (MiException e) {
            model.put("error", e.getMessage());
            return "noticia_modificar.html";
        }
    }
    @PostMapping("/baja/{id}")
    public String bajaNoticia(@PathVariable String id, ModelMap model) {
        try {
            noticiaService.bajaNoticia(id);
            model.put("exito", "Noticia eliminada con éxito");
            return "redirect:../lista";
        } catch (MiException e) {
            model.put("error", e.getMessage());
            return "redirect:../lista";
        }
    }
}
