
package com.egg.noticia.controllers;

import com.egg.noticia.entities.Noticia;
import com.egg.noticia.exceptions.MiException;
import com.egg.noticia.services.NoticiaService;
import java.util.Date;
import java.util.List;
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
    public String index(){
        return "noticia_form.html";
    }
    
    @PostMapping("/registro")
    public String crearNoticia(
            @RequestParam String titulo, 
            @RequestParam String cuerpo, 
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fecha,
            ModelMap model){
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
    public String verNoticia(@PathVariable String id, ModelMap model){

        Noticia noticia = noticiaService.getOne(id);

        model.addAttribute("noticia", noticia);

        return "noticia.html";
    }

    
    
    
}
