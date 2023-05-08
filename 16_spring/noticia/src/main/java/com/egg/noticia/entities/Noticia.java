package com.egg.noticia.entities;

import java.util.Date;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name ="noticias")
public class Noticia {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String titulo;
    private String cuerpo;
    @OneToOne
    private Imagen imagen;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    private Boolean hab = Boolean.TRUE;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Periodista periodista;

    public Noticia() {
    }

    public Noticia(String titulo, String cuerpo, Date fecha, Periodista periodista) {
        this.titulo = titulo;
        this.cuerpo = cuerpo;
        this.fecha = fecha;
        this.periodista = periodista;
    }

    public Noticia(String titulo, String cuerpo, Imagen imagen, Date fecha, Periodista periodista) {
        this.titulo = titulo;
        this.cuerpo = cuerpo;
        this.imagen = imagen;
        this.fecha = fecha;
        this.periodista = periodista;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public Boolean getHab() {
        return hab;
    }

    public void setHab(Boolean hab) {
        this.hab = hab;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = new Date(fecha.getTime() + (1000 * 60 * 60 * 24));
    }

    public Imagen getImagen() {
        return imagen;
    }

    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }

    public Periodista getPeriodista() {
        return periodista;
    }

    public void setPeriodista(Periodista periodista) {
        this.periodista = periodista;
    }
}
