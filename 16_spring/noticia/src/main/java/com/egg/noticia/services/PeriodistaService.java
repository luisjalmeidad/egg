package com.egg.noticia.services;

import com.egg.noticia.entities.Periodista;
import com.egg.noticia.exceptions.MiException;
import com.egg.noticia.repositories.PeriodistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class PeriodistaService {

    @Autowired
    PeriodistaRepository periodistaRepository;

    public Periodista buscarPeriodistaById(String id) throws MiException {
        Optional<Periodista> respuesta = periodistaRepository.findById(id);

        if(respuesta.isPresent()){
            Periodista periodista = respuesta.get();
            return periodista;
        }else{
            throw new MiException("No se encontró al periodista con el ID: " + id);
        }
    }

}
