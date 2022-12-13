/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Luis Almeida
 */
public class Yate extends BarcoMotor{
    private int numCamarotes;

    public Yate() {
    }

    public Yate(int numCamarotes, double potencia, String matricula, double metros, int anio) {
        super(potencia, matricula, metros, anio);
        this.numCamarotes = numCamarotes;
    }

    public int getNumCamarotes() {
        return numCamarotes;
    }

    public void setNumCamarotes(int numCamarotes) {
        this.numCamarotes = numCamarotes;
    }

    @Override
    public String toString() {
        return super.toString() + " Yate{" + "numCamarotes=" + numCamarotes + '}';
    }
}
