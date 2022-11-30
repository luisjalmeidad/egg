/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.Date;

/**
 *
 * @author A309436
 */
public class Cuota {
    
    private int numCuota;
    private double monto;
    private boolean estaPaga;
    private Date fechaVto;
    private String formaPago;

    public Cuota() {
    }

    public Cuota(int numCuota, double monto, boolean estaPaga, Date fechaVto, String formaPago) {
        this.numCuota = numCuota;
        this.monto = monto;
        this.estaPaga = estaPaga;
        this.fechaVto = fechaVto;
        this.formaPago = formaPago;
    }

    public int getNumCuota() {
        return numCuota;
    }

    public void setNumCuota(int numCuota) {
        this.numCuota = numCuota;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public boolean isEstaPaga() {
        return estaPaga;
    }

    public void setEstaPaga(boolean estaPaga) {
        this.estaPaga = estaPaga;
    }

    public Date getFechaVto() {
        return fechaVto;
    }

    public void setFechaVto(Date fechaVto) {
        this.fechaVto = fechaVto;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    @Override
    public String toString() {
        return "Cuota{" + "numCuota=" + numCuota + ", monto=" + monto + ", estaPaga=" + estaPaga + ", fechaVto=" + fechaVto + ", formaPago=" + formaPago + '}';
    }

    
    
}
