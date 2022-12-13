/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.Date;

/**
 *
 * @author Luis Almeida
 */
public class Alquiler {
    //nombre, documento del cliente, la fecha de alquiler, fecha de devolución, la posición del
    //amarre y el barco que lo ocupará.
    private String nombre;
    private String documento;
    private Date fechaLiq;
    private Date fechaDev;
    private int posicionAmarre;
    private Barco barco;

    public Alquiler() {
    }

    public Alquiler(String nombre, String documento, Date fechaLiq, Date fechaDev, Barco barco) {
        this.nombre = nombre;
        this.documento = documento;
        this.fechaLiq = fechaLiq;
        this.fechaDev = fechaDev;
        this.posicionAmarre = 5;
        this.barco = barco;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Date getFechaLiq() {
        return fechaLiq;
    }

    public void setFechaLiq(Date fechaLiq) {
        this.fechaLiq = fechaLiq;
    }

    public Date getFechaDev() {
        return fechaDev;
    }

    public void setFechaDev(Date fechaDev) {
        this.fechaDev = fechaDev;
    }

    public int getPosicionAmarre() {
        return posicionAmarre;
    }

    public void setPosicionAmarre(int posicionAmarre) {
        this.posicionAmarre = posicionAmarre;
    }

    public Barco getBarco() {
        return barco;
    }

    public void setBarco(Barco barco) {
        this.barco = barco;
    }

    @Override
    public String toString() {
        return "Alquiler{" + "nombre=" + nombre + ", documento=" + documento + ", fechaLiq=" + fechaLiq + ", fechaDev=" + fechaDev + ", posicionAmarre=" + posicionAmarre + ", barco=" + barco + '}';
    }     
    
}
