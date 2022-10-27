/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapppoo;

import javaapppoo.Entity.Persona;
import javaapppoo.Services.PersonaService;

/**
 *
 * @author A309436
 */
public class Ejercicio07 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Realizar una clase llamada Persona que tenga los siguientes atributos: nombre, edad, sexo
        //('H' hombre, 'M' mujer, 'O' otro), peso y altura. Si el alumno desea añadir algún otro
        //atributo, puede hacerlo. Los métodos que se implementarán son:
        //• Un constructor por defecto.
        //• Un constructor con todos los atributos como parámetro.
        //• Métodos getters y setters de cada atributo.
        //• Metodo crearPersona(): el método crear persona, le pide los valores de los atributos al
        //usuario y después se le asignan a sus respectivos atributos para llenar el objeto
        //Persona. Además, comprueba que el sexo introducido sea correcto, es decir, H, M o O.
        //Si no es correcto se deberá mostrar un mensaje
        //• Método calcularIMC(): calculara si la persona está en su peso ideal (peso en
        //kg/(altura^2 en mt2)). Si esta fórmula da por resultado un valor menor que 20, significa
        //que la persona está por debajo de su peso ideal y la función devuelve un -1. Si la
        //fórmula da por resultado un número entre 20 y 25 (incluidos), significa que la persona
        //está en su peso ideal y la función devuelve un 0. Finalmente, si el resultado de la
        //fórmula es un valor mayor que 25 significa que la persona tiene sobrepeso, y la
        //función devuelve un 1.
        //• Método esMayorDeEdad(): indica si la persona es mayor de edad. La función devuelve
        //un booleano.
        //A continuación, en la clase main hacer lo siguiente:
        //Crear 4 objetos de tipo Persona con distintos valores, a continuación, llamaremos todos
        //los métodos para cada objeto, deberá comprobar si la persona está en su peso ideal, tiene
        //sobrepeso o está por debajo de su peso ideal e indicar para cada objeto si la persona es
        //mayor de edad.
        //Por último, guardaremos los resultados de los métodos calcularIMC y esMayorDeEdad en
        //distintas variables, para después en el main, calcular un porcentaje de esas 4 personas
        //cuantas están por debajo de su peso, cuantas en su peso ideal y cuantos, por encima, y
        //también calcularemos un porcentaje de cuantos son mayores de edad y cuantos menores.
        PersonaService ps = new PersonaService();
        Persona p1 = ps.crearPersona();
        Persona p2 = ps.crearPersona();
        Persona p3 = ps.crearPersona();
        Persona p4 = ps.crearPersona();

        int contadorSobrePeso = 0;
        int contadorPesoIdeal = 0;
        int contadorPesoBajo = 0;
        int contadorMayorEdad = 0;
        int contadorMenorEdad = 0;

        Persona[] personas = new Persona[4];

        personas[0] = p1;
        personas[1] = p2;
        personas[2] = p3;
        personas[3] = p4;

        for (int i = 0; i < personas.length; i++) {

            switch (ps.calcularIMC(personas[i])) {
                case -1:
                    contadorPesoBajo++;
                    break;
                case 0:
                    contadorPesoIdeal++;
                    break;
                case 1:
                    contadorSobrePeso++;
                    break;
            }

            if (ps.esMayorDeEdad(personas[i])) {

                contadorMayorEdad++;

            } else {

                contadorMenorEdad++;
            }

        }

        System.out.println("El porcentaje de las personas que estan por debajo del peso ideal es: " + (contadorPesoBajo * 100 / 4) + "%");
        System.out.println("El porcentaje de las personas que estan en el peso ideal es: " + (contadorPesoIdeal * 100 / 4) + "%");
        System.out.println("El porcentaje de las personas que estan por encima del peso ideal es: " + (contadorSobrePeso * 100 / 4) + "%");
        System.out.println("El porcentaje de las personas que son mayor de edad es: " + (contadorMayorEdad * 100 / 4) + "%");
        System.out.println("El porcentaje de las personas que son menor de edad es: " + (contadorMenorEdad * 100 / 4) + "%");

    }

}
