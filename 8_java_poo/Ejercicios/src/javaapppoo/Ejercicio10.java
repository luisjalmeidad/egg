/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapppoo;

import java.util.Arrays;

/**
 *
 * @author A309436
 */
public class Ejercicio10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Realizar un programa en Java donde se creen dos arreglos: el primero será un arreglo A
        //de 50 números reales, y el segundo B, un arreglo de 20 números, también reales. El
        //programa deberá inicializar el arreglo A con números aleatorios y mostrarlo por pantalla.
        //Luego, el arreglo A se debe ordenar de menor a mayor y copiar los primeros 10 números
        //ordenados al arreglo B de 20 elementos, y rellenar los 10 últimos elementos con el valor
        //0.5. Mostrar los dos arreglos resultantes: el ordenado de 50 elementos y el combinado de
        //20.

        double[] arregloA = new double[50];
        double[] arregloB = new double[20];
        
        //"Llenamos el arreglo A"
        llenarArreglo(arregloA);        

        //"Ordenamos el arreglo A"
        Arrays.sort(arregloA);        

        //"Constuimos el arreglo B"
        Arrays.fill(arregloB, 0.5);        

        //"Reemplazamos los primeros valores del Arreglo B con los 10 primeros valores del arreglo A"
        for (int i = 0; i < 10; i++) {
            arregloB[i] = arregloA[i];
        }
        
        System.out.println("Arreglo A");
        imprimirArreglo(arregloA);
        System.out.println("Arreglo B");
        imprimirArreglo(arregloB);

    }

    public static void llenarArreglo(double[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = Math.random() * 9;
        }
    }

    public static void imprimirArreglo(double[] arreglo) {

        for (int i = 0; i < arreglo.length; i++) {
            System.out.print("[ " + arreglo[i] + " ]");
        }
        System.out.println("");

    }

}
