
package com.egg.noticia.controllers;

import com.egg.noticia.exceptions.MiException;
import com.egg.noticia.services.NoticiaService;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fecha){        
        try {
            noticiaService.crearNoticia(titulo, cuerpo, fecha);
            return "noticia_form.html";
        } catch (MiException ex) {
            Logger.getLogger(NoticiaController.class.getName()).log(Level.SEVERE, null, ex);
            return "noticia_form.html";
        }       
        
    }
    
    
    
}
