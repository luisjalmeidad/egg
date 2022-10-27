/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapppoo.Services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javaapppoo.Entity.Persona2;

/**
 *
 * @author A309436
 */
public class PersonaService2 {

    Scanner leer = new Scanner(System.in);

    //Agregar un método de creación del objeto que respete la siguiente firma:
    //crearPersona(). Este método rellena el objeto mediante un Scanner y le pregunta al
    //usuario el nombre y la fecha de nacimiento de la persona a crear, recordemos que la
    //fecha de nacimiento debe guardarse en un Date y los guarda en el objeto.
    public Persona2 crearPersona() {

        Persona2 persona = new Persona2();

        int dia;
        int mes;
        int anio;

        System.out.println("Ingrese el nombre de la persona");
        persona.setNombre(leer.nextLine());
        System.out.println("Ingrese la fecha de nacimiento de " + persona.getNombre());
        System.out.println("Dia: ");
        dia = leer.nextInt();
        System.out.println("Mes: ");
        mes = leer.nextInt();
        System.out.println("Anio: ");
        anio = leer.nextInt();

        Date fecha = new Date(anio - 1900, mes - 1, dia);
        persona.setFechaNacimiento(fecha);

        return persona;
    }

    //• Escribir un método calcularEdad() a partir de la fecha de nacimiento ingresada. Tener
    //en cuenta que para conocer la edad de la persona también se debe conocer la fecha
    //actual.
    public int calcularEdad(Persona2 persona) {
        int edad = 0;
        Date fechaActual = new Date();

        edad = Math.abs(persona.getFechaNacimiento().getYear() - fechaActual.getYear());

        if (persona.getFechaNacimiento().getMonth() > fechaActual.getMonth()) {
            edad--;
        } else if (persona.getFechaNacimiento().getMonth() == fechaActual.getMonth()) {
            if (persona.getFechaNacimiento().getDate() > fechaActual.getDate()) {
                edad--;
            }
        }

        return edad;
    }

    //• Agregar a la clase el método menorQue(int edad) que recibe como parámetro otra
    //edad y retorna true en caso de que el receptor tenga menor edad que la persona que
    //se recibe como parámetro, o false en caso contrario.
    public boolean menorQue(Persona2 persona, int edad) {
        if (calcularEdad(persona) > edad) {
            return false;
        }
        return true;
    }

    //• Metodo mostrarPersona(): este método muestra la persona creada en el método
    //anterior.
    
    public void mostrarPersona(Persona2 persona){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.println("Nombre: " + persona.getNombre());
        
        System.out.println("Fecha de nacimiento: " + formato.format(persona.getFechaNacimiento()));
    }
}
