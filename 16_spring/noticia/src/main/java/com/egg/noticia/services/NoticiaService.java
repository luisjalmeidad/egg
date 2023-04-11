package com.egg.noticia.services;

import com.egg.noticia.entities.Noticia;
import com.egg.noticia.exceptions.MiException;
import com.egg.noticia.repositories.NoticiaRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticiaService {

    @Autowired
    private NoticiaRepository noticiaRepository;

    private void validar(String titulo, String cuerpo, Date fecha) throws MiException {
        if (titulo.isEmpty() || titulo == null) {
            throw new MiException("Debe ingresar el titulo.");
        }

        if (cuerpo.isEmpty() || cuerpo == null) {
            throw new MiException("Debe ingresar el cuerpo.");
        }

        if (fecha == null) {
            throw new MiException("Debe indicar la fecha de la noticia.");
        }
        
        if (fecha.before(new Date("01/01/2023"))) {
            throw new MiException("Ingrese noticias posterior a la fecha 01/01/2023.");
        }

    }

    @Transactional
    public void crearNoticia(String titulo, String cuerpo, Date fecha) throws MiException {
        validar(titulo, cuerpo, fecha);
        System.out.println("Paso el validar");
        Noticia noticia = new Noticia(titulo, cuerpo, new Date(fecha.getTime() + (1000 * 60 * 60 * 24)));
        noticiaRepository.save(noticia);
    }

    public List<Noticia> listarNoticias() {
        return noticiaRepository.findAll();
    }

    public Noticia getOne(String id) {
        return noticiaRepository.getOne(id);
    }

    @Transactional
    public void modificarNoticia(String id, String titulo, String cuerpo, Date fecha) throws MiException {
        validar(titulo, cuerpo, fecha);
        Optional<Noticia> respuesta = noticiaRepository.findById(id);

        if (respuesta.isPresent()) {
            Noticia noticia = respuesta.get();
            noticia.setTitulo(titulo);
            noticia.setCuerpo(cuerpo);
            noticia.setFecha(fecha);
            noticiaRepository.save(noticia);
        }
    }

    @Transactional
    public void bajaNoticia(String id) {
        Optional<Noticia> respuesta = noticiaRepository.findById(id);

        if (respuesta.isPresent()) {
            Noticia noticia = respuesta.get();
            noticia.setHab(Boolean.FALSE);
            noticiaRepository.save(noticia);
        }
    }
}
