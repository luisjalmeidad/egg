/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapppoo.Services;

import java.util.Scanner;
import javaapppoo.Entity.Cuenta;

/**
 *
 * @author A309436
 */
public class CuentaService {

    Scanner leer = new Scanner(System.in);

    public Cuenta crearCuenta() {

        Cuenta c1 = new Cuenta();

        System.out.println("Ingrese el numero de cuenta");
        c1.setNumeroCuenta(leer.nextInt());
        System.out.println("Ingrese el DNI sin puntos");
        c1.setDni(leer.nextInt());
        System.out.println("Ingrese su saldo");
        c1.setSaldoActual(leer.nextInt());

        return c1;
    }

    public void ingresarSaldo(Cuenta c1) {
        System.out.println("Ingrese el monto del deposito");
        c1.setSaldoActual(c1.getSaldoActual() + leer.nextInt());

    }

    public void retirarSaldo(Cuenta c1) {
        int retiro;

        System.out.println("Indique el monto del retiro");
        retiro = leer.nextInt();

        if (c1.getSaldoActual() > retiro) {

            c1.setSaldoActual(c1.getSaldoActual() - retiro);

        } else {

            c1.setSaldoActual(0);
        }

    }

    public void extraccionRapida(Cuenta c1) {
        System.out.println("Extraccion rapida");

        if (c1.getSaldoActual() == 0) {
            System.out.println("Ups! no hay saldo para retirar.");
        } else {
            c1.setSaldoActual((int) (c1.getSaldoActual() * 0.8));
        }

    }

    public void consultarSaldo(Cuenta c1) {
        System.out.println("Su saldo es: " + c1.getSaldoActual());
    }

    public void consultarDatos(Cuenta c1) {
        System.out.println("Su numero de cuenta es: " + c1.getNumeroCuenta());
        System.out.println("Su DNI es: " + c1.getDni());
        System.out.println("Su saldo es: " + c1.getSaldoActual());
    }

}
