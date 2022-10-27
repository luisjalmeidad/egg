/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapppoo.Services;

import java.util.Scanner;
import javaapppoo.Entity.Cafetera;

/**
 *
 * @author A309436
 */
public class CafeteraService {
    
    Scanner leer = new Scanner(System.in);
    
    public Cafetera crearCafetera(){
        
        Cafetera c1 = new Cafetera();
        
        System.out.println("Indique la capacidad de la cafetera");
        c1.setCapacidadMaxima(leer.nextInt());
        
        return c1;
    }
    
    public void llenarCafetera(Cafetera c1){
        System.out.println("Llenando cafetera...");
        c1.setCantidadActual(c1.getCapacidadMaxima());
        System.out.println("¡Cafetera llena!");
    }
    
    public void servirTaza(Cafetera c1){
        int taza;
        
        System.out.println("Sirviendo taza de café...");
        System.out.println("");
        System.out.println("Indique el tamaño de la taza");
        taza = leer.nextInt();

        if (c1.getCantidadActual() < taza) {
            System.out.println("Sirviendo café...");
            System.out.println("La taza no está llena. Solo pudimos llenar " + c1.getCantidadActual() + "ml");
            c1.setCantidadActual(0);
        }else{
            System.out.println("Sirviendo café...");
            System.out.println("¡La taza está llena!");
            c1.setCantidadActual(c1.getCantidadActual() - taza);            
        }
    }
    
    public void vaciarCafetera(Cafetera c1){
        System.out.println("Vaciando cafetera...");
        c1.setCantidadActual(0);
        System.out.println("Cafetera vacia...");
    }
    
    public void agregarCafe(Cafetera c1){
        
        int cantidadCafe;
        
        System.out.println("Por favor ingrese la cantidad de café a ingresar");
        cantidadCafe = leer.nextInt();
        
        if (cantidadCafe > c1.getCapacidadMaxima()) {
            llenarCafetera(c1);
            System.out.println("Ups! Se derramaron " + (cantidadCafe - c1.getCapacidadMaxima()) + "ml de café");             
        }else{
            c1.setCantidadActual(cantidadCafe);            
        }
        
        
    }
}
