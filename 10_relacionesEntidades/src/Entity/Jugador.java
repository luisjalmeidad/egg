/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author A309436
 */
public class Jugador {
//    Clase Jugador: esta clase posee los siguientes atributos: id (representa el número del
//    //jugador), nombre (Empezara con Jugador más su ID, “Jugador 1” por ejemplo) y mojado (indica
//    //si está mojado o no el jugador). El número de jugadores será decidido por el usuario, pero
//    //debe ser entre 1 y 6. Si no está en este rango, por defecto será 6.
    
    private int id;
    private String nombre;
    private boolean Mojado;

    public Jugador() {
    }

    public Jugador(int id, String nombre, boolean estaMojado) {
        this.id = id;
        this.nombre = nombre;
        this.Mojado = estaMojado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isMojado() {
        return Mojado;
    }

    public void setEstaMojado(boolean estaMojado) {
        this.Mojado = estaMojado;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Jugador{");
        sb.append("id=").append(id);
        sb.append(", nombre=").append(nombre);
        sb.append(", estaMojado=").append(Mojado);
        sb.append('}');
        return sb.toString();
    }
    
    
    
    
}
