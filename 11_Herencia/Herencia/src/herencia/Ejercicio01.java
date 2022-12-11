/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package herencia;

import Entity.Animal;
import Entity.Caballo;
import Entity.Gato;
import Entity.Perro;

/**
 *
 * @author A309436
 */
public class Ejercicio01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
     //Declaración del objeto Perro
    Animal perrol = new Perro("Stich", "Carnivoro", 15, "Doberman");
    perrol.alimentar();
     //Declaración de otro objeto Perro
    Animal perro2 = new Perro("Teddy", "Croquetas", 10, "Chihuahua");
    perro2.alimentar();
     //Declaración del objeto Gato
    Animal gatol = new Gato("Pelusa", "Galletas", 15, "Siamés");
    gatol.alimentar();
     //Declaración del objeto Caballo
    Animal caballo1 = new Caballo("Spark", "Pasto", 25, "Fino");
    caballo1.alimentar();
 

        
        
        
        
        
        
        
        
        
    }
    
}
