/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapppoo.Services;

import java.util.Scanner;
import javaapppoo.Entity.Rectangulo;

/**
 *
 * @author A309436
 */
public class RectanguloService {

    public Rectangulo crearRectangulo() {
        Scanner leer = new Scanner(System.in);
        Rectangulo r1 = new Rectangulo();

        System.out.println("Ingrese la base del rectangulo");
        r1.setBase(leer.nextDouble());
        System.out.println("Ingrese la altura del rectangulo");
        r1.setAltura(leer.nextDouble());

        return r1;

    }

    public double calcularSuperficie(Rectangulo r1) {
        return r1.getBase() * r1.getAltura();
    }

    public double calcularPerimetro(Rectangulo r1) {
        return (r1.getBase() + r1.getAltura()) * 2;
    }

    public void imrpimirRectangulo(Rectangulo r1) {

        System.out.println("Su rectangulo es: ");

        for (int i = 0; i < r1.getAltura(); i++) {
            for (int j = 0; j < r1.getBase(); j++) {
                if (i == 0 || i == (r1.getAltura() - 1) || j == 0 || j == (r1.getBase() - 1)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }

            }
            System.out.println("");
        }

    }

}
