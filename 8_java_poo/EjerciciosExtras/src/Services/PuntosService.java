/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entity.Puntos;
import java.util.Scanner;

/**
 *
 * @author A309436
 */
public class PuntosService {

    Scanner leer = new Scanner(System.in);

    public Puntos crearPunto() {

        Puntos punto = new Puntos();

        System.out.println("Ingrese la coordenada X del primero punto");
        punto.setX1(leer.nextDouble());
        System.out.println("Ingrese la coordenada Y del primero punto");
        punto.setY1(leer.nextDouble());
        System.out.println("Ingrese la coordenada X del segundo punto");
        punto.setX2(leer.nextDouble());
        System.out.println("Ingrese la coordenada Y del segundo punto");
        punto.setY2(leer.nextDouble());

        return punto;

    }

    public double calcularDistancia(Puntos punto) {
        return Math.sqrt(Math.pow(punto.getX2() - punto.getX1(), 2) + Math.pow(punto.getY2() - punto.getY1(), 2));
    }

}
