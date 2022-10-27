/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapppoo;

import java.util.Scanner;
import javaapppoo.Entity.Operacion;
import javaapppoo.Services.OperacionService;

/**
 *
 * @author A309436
 */
public class Ejercicio03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Crear una clase llamada Operacion que tenga como atributos privados numero1 y
        //numero2. A continuación, se deben crear los siguientes métodos:
        //a) Método constructor con todos los atributos pasados por parámetro.
        //b) Metodo constructor sin los atributos pasados por parámetro.
        //c) Métodos get y set.
        //d) Método para crearOperacion(): que le pide al usuario los dos números y los guarda en
        //los atributos del objeto.
        //e) Método sumar(): calcular la suma de los números y devolver el resultado al main.
        //f) Método restar(): calcular la resta de los números y devolver el resultado al main
        //g) Método multiplicar(): primero valida que no se haga una multiplicación por cero, si
        //fuera a multiplicar por cero, el método devuelve 0 y se le informa al usuario el error. Si
        //no, se hace la multiplicación y se devuelve el resultado al main
        //h) Método dividir(): primero valida que no se haga una división por cero, si fuera a pasar
        //una división por cero, el método devuelve 0 y se le informa al usuario el error se le
        //informa al usuario. Si no, se hace la división y se devuelve el resultado al main.
        Scanner leer = new Scanner(System.in);
        OperacionService os = new OperacionService();

        Operacion op1 = os.crearOperacion();

        System.out.println("El resultado de la suma es: " + os.sumar(op1));
        System.out.println("El resultado de la resta es: " + os.restar(op1));

        if (os.multiplicar(op1) == 0) {
            System.out.println("No se puede multiplicar por 0");
        } else {
            System.out.println("El resultado de la multiplicacion es: " + os.multiplicar(op1));
        }

        if (op1.getNumero1() == 0 || op1.getNumero2() == 0) {
            System.out.println("No se puede dividir por 0");
        } else {
            System.out.println("El resultado de la division es: " + os.dividir(op1));
        }

    }

}
