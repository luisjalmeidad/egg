/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosextrascoach;

import Entity.Triangulo;
import Service.TrianguloService;

/**
 *
 * @author A309436
 */
public class Ejercicio05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Definir una clase triangulo que modelara triángulos isósceles . Definir los atributos necesarios para
        //operar. Crear los métodos correspondientes a la clase Entidad.
        //Crear un arreglo con 4 objetos de la clase
        //Crear los siguientes métodos:
        //● Calcular área
        //● Calcular perímetro
        //● Mostrar los datos del triangulo que tenga el área de mayor superficie
        
        TrianguloService ts = new TrianguloService();
        Triangulo vTriangulo[] = new Triangulo[4];
        double superficie = 0;
        double superficieAnt = 0;
        int mayorSuperficie = 0;
        
        for (int i = 0; i < vTriangulo.length; i++) {
            System.out.println("Triangulo " + (i + 1));
            vTriangulo[i] = ts.crearTriangulo();
            System.out.println("");
            
            superficie = ts.calcularArea(vTriangulo[i]); 
                    
            if (superficie > superficieAnt) {
               mayorSuperficie = i;
            }
            
            superficieAnt = superficie;            
        }
        
        System.out.println("El triangulo con mayor superficie es el " + mayorSuperficie);
        System.out.println("Sus datos son:");
        System.out.println("Area: " + ts.calcularArea(vTriangulo[mayorSuperficie]));
        System.out.println("Perimetro: " + ts.calcularPerimetro(vTriangulo[mayorSuperficie]));
       
    }
    
}
