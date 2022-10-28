/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author A309436
 */
public class Ahorcado {

    private String palabraSecreta[];
    private int cantidadLetrasEncontradas;
    private int cantidadIntentos;
    private List<String> letrasEncontradas;

    public Ahorcado() {
        letrasEncontradas = new ArrayList<String>();
    }

    public Ahorcado(String[] palabraSecreta, int cantidadLetrasEncontradas, int cantidadIntentos, List<String> letrasEncontradas) {
        this.palabraSecreta = palabraSecreta;
        this.cantidadLetrasEncontradas = cantidadLetrasEncontradas;
        this.cantidadIntentos = cantidadIntentos;
        this.letrasEncontradas = letrasEncontradas;
    }

    public List<String> getLetrasEncontradas() {
        return letrasEncontradas;
    }

    public void setLetrasEncontradas(List<String> letrasEncontradas) {
        this.letrasEncontradas = letrasEncontradas;
    }
    
    public void setLetrasEncontradas(String letrasEncontradas) {
        this.letrasEncontradas.add(letrasEncontradas);
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
