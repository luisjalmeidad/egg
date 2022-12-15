/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Entity.Polideportivo;
import java.util.Scanner;

/**
 *
 * @author A309436
 */
public class PolideportivoService {
    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public Polideportivo crearPolideportivo(){
        double ancho = Math.round(((Math.random() * 9) + 5) *100)/100;
        double alto = ancho;
        double largo = ancho * 2;
        String tipoInstalacion;
        
        System.out.println("Indique el nombre del polideportivo");
        String nombre = leer.next();        
        System.out.println("Indique el tipo de instalacion");
        System.out.println("1 - Techado");
        System.out.println("2 - Abierto");
        int opcion = leer.nextInt();
        
        if (opcion == 1) {
            tipoInstalacion = "Techado";
        }else{
            tipoInstalacion = "Abierto";
        }
        return new Polideportivo(nombre, tipoInstalacion, ancho, alto, largo);
        
    }
    
    
}
