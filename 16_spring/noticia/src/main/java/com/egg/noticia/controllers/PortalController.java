
package com.egg.noticia.controllers;

import com.egg.noticia.entities.Noticia;
import com.egg.noticia.services.NoticiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class PortalController {

    @Autowired
    private NoticiaService noticiaService;

    @GetMapping("/")
    public String index(ModelMap model){

        List<Noticia> noticias = noticiaService.listarNoticias();

        model.addAttribute("noticias", noticias);

        return "index.html";
    }
}
