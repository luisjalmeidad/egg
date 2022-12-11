/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package herencia;

import Entity.Lavadora;
import Services.LavadoraService;

/**
 *
 * @author A309436
 */
public class Ejercicio02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LavadoraService ls = new LavadoraService();
        Lavadora lavadora = ls.crearLavadora();
        lavadora.precioFinal();
        System.out.println(lavadora.toString());
        
        
    }
    
}
