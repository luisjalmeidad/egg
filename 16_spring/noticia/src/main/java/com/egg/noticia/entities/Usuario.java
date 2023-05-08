package com.egg.noticia.entities;

import com.egg.noticia.enumeraciones.Rol;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="usuarios")
@Inheritance(strategy=InheritanceType.JOINED)
public class Usuario {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    protected String id;
    protected String nombre;
    protected String clave;
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date fechaAlta;
    @Enumerated(EnumType.STRING)
    protected Rol rol;
    protected Boolean activo;

    public Usuario() {
    }

    public Usuario(String nombre, String clave, Rol rol) {
        this.nombre = nombre;
        this.clave = clave;
        this.fechaAlta = new Date();
        this.rol = rol;
        this.activo = true;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}
