/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author A309436
 */
public class Hotel5 extends Hotel4{
    
    protected int cantSalones;
    protected int cantSuites;
    protected int cantLimusinas;

    public Hotel5() {
    }
    
    public Hotel5(int cantSalones, int cantSuites, int cantLimusinas, char Gimnasio, String nombreRest, int capacidadRest, int cantHabitaciones, int numCamas, int cantPisos, double precioHabitacion, String nombre, String direccion, String localidad, String gerente) {
        super(Gimnasio, nombreRest, capacidadRest, cantHabitaciones, numCamas, cantPisos, precioHabitacion, nombre, direccion, localidad, gerente);
        this.cantSalones = cantSalones;
        this.cantSuites = cantSuites;
        this.cantLimusinas = cantLimusinas;
    }

    public int getCantSalones() {
        return cantSalones;
    }

    public void setCantSalones(int cantSalones) {
        this.cantSalones = cantSalones;
    }

    public int getCantSuites() {
        return cantSuites;
    }

    public void setCantSuites(int cantSuites) {
        this.cantSuites = cantSuites;
    }

    public int getCantLimosinas() {
        return cantLimusinas;
    }

    public void setCantLimosinas(int cantLimusinas) {
        this.cantLimusinas = cantLimusinas;
    }

    @Override
    public String toString() {
        return super.toString() + "Hotel5{" + "cantSalones=" + cantSalones + ", cantSuites=" + cantSuites + ", cantLimusinas=" + cantLimusinas + '}';
    }

    
}
