/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author A309436
 */
public class Triangulo {
    private double base;
    private double lados;

    public Triangulo() {
    }

    public Triangulo(double base, double lados) {
        this.base = base;
        this.lados = lados;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getLados() {
        return lados;
    }

    public void setLados(double lados) {
        this.lados = lados;
    }
}
