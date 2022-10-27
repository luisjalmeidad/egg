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
public class Ahorcado {
    
    private String palabraSecreta[];
    private int cantidadLetrasEncontradas = 0;
    private int cantidadIntentos;

    public Ahorcado() {
        
    }

    public Ahorcado(String[] palabraSecreta, int cantidadLetrasEncontradas, int cantidadIntentos) {
        this.palabraSecreta = palabraSecreta;
        this.cantidadLetrasEncontradas = cantidadLetrasEncontradas;
        this.cantidadIntentos = cantidadIntentos;
    }

    public String[] getPalabraSecreta() {
        return palabraSecreta;
    }

    public void setPalabraSecreta(String[] palabraSecreta) {
        this.palabraSecreta = palabraSecreta;
    }

    public int getCantidadLetrasEncontradas() {
        return cantidadLetrasEncontradas;
    }

    public void setCantidadLetrasEncontradas(int cantidadLetrasEncontradas) {
        this.cantidadLetrasEncontradas += cantidadLetrasEncontradas;
    }

    public int getCantidadIntentos() {
        return cantidadIntentos;
    }

    public void setCantidadIntentos(int cantidadIntentos) {
        this.cantidadIntentos = cantidadIntentos;
    }
    
    
    
    
    
}
