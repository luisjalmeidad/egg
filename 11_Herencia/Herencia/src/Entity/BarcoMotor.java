/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Luis Almeida
 */
public class BarcoMotor extends Barco{
    protected double potencia;

    public BarcoMotor() {
    }

    public BarcoMotor(double potencia, String matricula, double metros, int anio) {
        super(matricula, metros, anio);
        this.potencia = potencia;
    }

    public double getPotencia() {
        return potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    @Override
    public String toString() {
        return super.toString() + " BarcoMotor{" + "potencia=" + potencia + '}';
    }
    
    
}
