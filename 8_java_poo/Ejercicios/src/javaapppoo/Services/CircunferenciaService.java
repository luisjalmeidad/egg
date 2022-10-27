/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapppoo.Services;

import java.util.Scanner;
import javaapppoo.Entity.Circunferencia;

/**
 *
 * @author A309436
 */
public class CircunferenciaService {

    public Circunferencia crearCircunferencia() {

        Circunferencia circun = new Circunferencia();
        Scanner leer = new Scanner(System.in);

        System.out.println("Ingrese el radio de la circunferencia");
        circun.setRadio(leer.nextDouble());

        return circun;

    }

    public double calcularArea(Circunferencia circun) {
        return Math.pow(circun.getRadio(), 2) * Math.PI;
    }

    public double calcularPerimetro(Circunferencia circun) {
        return 2 * circun.getRadio() * Math.PI;
    }

}
