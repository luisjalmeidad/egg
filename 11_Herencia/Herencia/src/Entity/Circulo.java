/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Luis Almeida
 */
public class Circulo extends FormaGeometrica{
    private double radio;
    private double diametro;

    public Circulo() {
    }

    public Circulo(double radio) {
        this.radio = radio;
        diametro = radio * 2;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;        
    }

    public double getDiametro() {
        return diametro;
    }

    public void setDiametro(double diametro) {
        this.diametro = diametro;
    }
    
    
    
}
