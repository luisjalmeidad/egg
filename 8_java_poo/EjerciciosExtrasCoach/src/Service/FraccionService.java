/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Fraccion;
import java.util.Scanner;

/**
 *
 * @author A309436
 */
public class FraccionService {

    Scanner leer = new Scanner(System.in);

    public Fraccion crearFraccion() {
        Fraccion fr = new Fraccion();

        System.out.println("Ingresar el numerador de la primera fraccion");
        fr.setNumerador1(leer.nextInt());
        System.out.println("Ingresar el denominador de la primera fraccion");
        fr.setDenominador1(leer.nextInt());
        System.out.println("Ingresar el numerador de la segunda fraccion");
        fr.setNumerador2(leer.nextInt());
        System.out.println("Ingresar el denominador de la segunda fraccion");
        fr.setDenominador2(leer.nextInt());

        return fr;
    }

    public void sumarFraccion(Fraccion fr) {
        System.out.println("Mensaje: El resultado de la suma es " + (fr.getNumerador1() * fr.getDenominador2() + fr.getNumerador2() * fr.getDenominador1()) + "/" + fr.getDenominador1() * fr.getDenominador2());
    }

    public void restarFraccion(Fraccion fr) {
        System.out.println("Mensaje: El resultado de la resta es " + (fr.getNumerador1() * fr.getDenominador2() - fr.getNumerador2() * fr.getDenominador1()) + "/" + fr.getDenominador1() * fr.getDenominador2());
    }

    public void multiplicarFraccion(Fraccion fr) {
        System.out.println("Mensaje: El resultado de la multiplicacion es " + fr.getNumerador1() * fr.getNumerador2() + "/" + fr.getDenominador1() * fr.getDenominador2());
    }

    public void dividirFraccion(Fraccion fr) {
        System.out.println("Mensaje: El resultado de la division es " + fr.getNumerador1() * fr.getDenominador2() + "/" + fr.getNumerador2() * fr.getDenominador1());
    }

    public void operar(Fraccion fr) {
        int opcion = 0;

        System.out.println("Seleccione alguna opción con el número correspondiente");
        do {
            System.out.println("-------------- MENU -------------");
            System.out.println("| 1 -> Sumar fracciones          |");
            System.out.println("| 2 -> Restar fracciones         |");
            System.out.println("| 3 -> Multiplicar fracciones    |");
            System.out.println("| 4 -> Dividir fracciones        |");
            System.out.println("| 5 -> Salir                     |");
            System.out.println("---------------------------------");
            opcion = leer.nextInt();
            
            switch (opcion) {
                case 1:
                    sumarFraccion(fr);
                    break;
                case 2:
                    restarFraccion(fr);
                    break;
                case 3:
                    multiplicarFraccion(fr);
                    break;
                case 4:
                    dividirFraccion(fr);
                    break;
                case 5:
                    System.out.println("Mensaje: ¡Gracias por operar con nosotros!");
                    break;
                default:
                    System.out.println("ERROR: \"" + opcion + "\" no es una opcion permitida.");                    
            }

        } while (opcion != 5);

    }

}
