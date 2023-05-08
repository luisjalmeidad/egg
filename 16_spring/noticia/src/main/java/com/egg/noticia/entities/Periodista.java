package com.egg.noticia.entities;

import com.egg.noticia.enumeraciones.Rol;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="periodistas")
@PrimaryKeyJoinColumn(name="usuarioId")
public class Periodista extends Usuario{
    @OneToMany(mappedBy="periodista")
    private List<Noticia> misNoticias;
    private Integer sueldoMensual;
    public Periodista(String nombre, String clave, Rol rol, List<Noticia> misNoticias, Integer sueldoMensual) {
        super(nombre, clave, rol);
        this.misNoticias = misNoticias;
        this.sueldoMensual = sueldoMensual;
    }

    public Periodista(Usuario usuario, List<Noticia> misNoticias, Integer sueldoMensual) {
        super(usuario.getNombre(), usuario.getClave(), usuario.getRol());
        this.misNoticias = misNoticias;
        this.sueldoMensual = sueldoMensual;
    }

    public List<Noticia> getMisNoticias() {
        return misNoticias;
    }

    public void setMisNoticias(List<Noticia> misNoticias) {
        this.misNoticias = misNoticias;
    }

    public Integer getSueldoMensual() {
        return sueldoMensual;
    }

    public void setSueldoMensual(Integer sueldoMensual) {
        this.sueldoMensual = sueldoMensual;
    }
}
