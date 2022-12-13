/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Luis Almeida
 */
public class Velero extends Barco {
    private int numMastiles;

    public Velero() {
        
    }

    public Velero(int numMastiles, String matricula, double metros, int anio) {
        super(matricula, metros, anio);
        this.numMastiles = numMastiles;
    }

    public int getNumMastiles() {
        return numMastiles;
    }

    public void setNumMastiles(int numMastiles) {
        this.numMastiles = numMastiles;
    }

    @Override
    public String toString() {
        return super.toString() + " Veleros{" + "numMastiles=" + numMastiles + '}';
    }
}
