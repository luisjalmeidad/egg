
package com.egg.noticia.controllers;

import com.egg.noticia.entities.Noticia;
import com.egg.noticia.exceptions.MiException;
import com.egg.noticia.services.NoticiaService;
import com.egg.noticia.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class PortalController {

    @Autowired
    private NoticiaService noticiaService;
    @Autowired
    private UsuarioService usuarioService;

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_JOURNALIST', 'ROLE_ADMIN')")
    @GetMapping("/")
    public String index(ModelMap model) {
        List<Noticia> noticias = noticiaService.listarNoticias();
        model.addAttribute("noticias", noticias);
        return "index.html";
    }

    @GetMapping("/registrar")
    public String registrar() {
        return "registro.html";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam String nombre,
                           @RequestParam String clave,
                           @RequestParam String clave2,
                           ModelMap model) {
        try {
            usuarioService.registrar(nombre, clave, clave2);
            model.put("exito", "Usuario registrado correctamente");
            return "redirect:../";
        } catch (MiException e) {
            model.put("error", e.getMessage());
            model.put("nombre", nombre);
            return "registro.html";
        }
    }

    @GetMapping("/login")
    public String login(@RequestParam(required = false) String error, ModelMap model) {
        if (error != null) {
            model.put("error", "usuario o contraseña invalida");
        }
        return "login.html";
    }


}
