/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author A309436
 */
public class EdificioDeOficinas extends Edificio {
    
    private int numOficinas;
    private int cantPersonas;
    private int numPisos;

    public EdificioDeOficinas() {        
    }

    public EdificioDeOficinas(int numOficinas, int cantPersonas, int numPisos, double ancho, double alto, double largo) {
        super(ancho, alto, largo);
        this.numOficinas = numOficinas;
        this.cantPersonas = cantPersonas;
        this.numPisos = numPisos;
    }

    public int getNumOficinas() {
        return numOficinas;
    }

    public void setNumOficinas(int numOficinas) {
        this.numOficinas = numOficinas;
    }

    public int getCantPersonas() {
        return cantPersonas;
    }

    public void setCantPersonas(int cantPersonas) {
        this.cantPersonas = cantPersonas;
    }

    public int getNumPisos() {
        return numPisos;
    }

    public void setNumPisos(int numPisos) {
        this.numPisos = numPisos;
    }    
    
    @Override
    public double calcularSuperficie() {
         return 2*((ancho * largo) + (ancho * alto) + (largo * alto));
    }

    @Override
    public double calcularVolumen() {
        return largo * ancho * alto;
    }

    @Override
    public String toString() {
        return "EdificioDeOficinas{" + "numOficinas=" + numOficinas + ", cantPersonas=" + cantPersonas + ", numPisos=" + numPisos + '}';
    }
    
    
}
