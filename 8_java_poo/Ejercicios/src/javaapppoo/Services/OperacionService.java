/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapppoo.Services;

import java.util.Scanner;
import javaapppoo.Entity.Operacion;

/**
 *
 * @author A309436
 */
public class OperacionService {

    public Operacion crearOperacion() {

        Scanner leer = new Scanner(System.in);
        Operacion op = new Operacion();

        System.out.println("Ingrese el primer numero");
        op.setNumero1(leer.nextDouble());
        System.out.println("Ingrese el segundo numero");
        op.setNumero2(leer.nextDouble());

        return op;
    }

    public double sumar(Operacion op) {
        return op.getNumero1() + op.getNumero2();
    }

    public double restar(Operacion op) {
        return op.getNumero1() - op.getNumero2();
    }

    public double multiplicar(Operacion op) {

        if (op.getNumero1() == 0 || op.getNumero2() == 0) {
            return 0;
        }

        return op.getNumero1() * op.getNumero2();
    }

    public double dividir(Operacion op) {

        if (op.getNumero1() == 0 || op.getNumero2() == 0) {
            return 0;
        }

        return op.getNumero1() / op.getNumero2();
    }
}
