/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author A309436
 */
public class Hotel4 extends Hotel {

    protected char Gimnasio;
    protected String nombreRest;
    protected int capacidadRest;

    public Hotel4() {
    }

    public Hotel4(char Gimnasio, String nombreRest, int capacidadRest, int cantHabitaciones, int numCamas, int cantPisos, double precioHabitacion, String nombre, String direccion, String localidad, String gerente) {
        super(cantHabitaciones, numCamas, cantPisos, precioHabitacion, nombre, direccion, localidad, gerente);
        this.Gimnasio = Gimnasio;
        this.nombreRest = nombreRest;
        this.capacidadRest = capacidadRest;
    }

    public char getGimnasio() {
        return Gimnasio;
    }

    public void setGimnasio(char Gimnasio) {
        this.Gimnasio = Gimnasio;
    }

    public String getNombreRest() {
        return nombreRest;
    }

    public void setNombreRest(String nombreRest) {
        this.nombreRest = nombreRest;
    }

    public int getCapacidadRest() {
        return capacidadRest;
    }

    public void setCapacidadRest(int capacidadRest) {
        this.capacidadRest = capacidadRest;
    }

    @Override
    public String toString() {
        return super.toString() + "Hotel4{" + "Gimnasio=" + Gimnasio + ", nombreRest=" + nombreRest + ", capacidadRest=" + capacidadRest + '}';
    }

    
    
}
