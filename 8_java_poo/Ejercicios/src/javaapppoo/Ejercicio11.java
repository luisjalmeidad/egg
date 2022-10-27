/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapppoo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


/**
 *
 * @author A309436
 */
public class Ejercicio11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Pongamos de lado un momento el concepto de POO, ahora vamos a trabajar solo con la
        //clase Date. En este ejercicio deberemos instanciar en el main, una fecha usando la clase
        //Date, para esto vamos a tener que crear 3 variables, dia, mes y anio que se le pedirán al
        //usuario para poner el constructor del objeto Date. Una vez creada la fecha de tipo Date,
        //deberemos mostrarla y mostrar cuantos años hay entre esa fecha y la fecha actual, que se
        //puede conseguir instanciando un objeto Date con constructor vacío.
        //Ejemplo fecha: Date fecha = new Date(anio, mes, dia);
        //Ejemplo fecha actual: Date fechaActual = new Date();

        Scanner leer = new Scanner(System.in);
        int dia;
        int mes;
        int anio;

        System.out.println("Por favor ingrese el anio");
        anio = leer.nextInt();
        System.out.println("Por favor ingrese el mes");
        mes = leer.nextInt();
        System.out.println("Por favor ingrese el dia");
        dia = leer.nextInt();
        
        //Clase LocalD1ate para manipular fechas y clase DateTimeFormatter para darle formato
        LocalDate fechaActual = LocalDate.now();        
        LocalDate fecha = LocalDate.of(anio, mes, dia);
        DateTimeFormatter formatoDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");        
        
        System.out.println("fecha: " + fecha.format(formatoDate));        
        System.out.println("fechaActual: " + fechaActual.format(formatoDate));
        
        System.out.println("El resultado de la resta es: " + Math.abs(fecha.getYear() - fechaActual.getYear()));
        
        
        //Clase Date para manipular fechas y clase SimpleDateFormat para darle formato
        
//        Date fecha = new Date(anio-1900, mes-1, dia);
//        Date fechaActual = new Date();
//        
//        System.out.println("fecha: " + fecha);        
//        System.out.println("fechaActual: " + fechaActual);
//        
//        System.out.println("El resultado de la resta es: " + Math.abs(fecha.getYear() - fechaActual.getYear()));        
        
        
        

    }

}
