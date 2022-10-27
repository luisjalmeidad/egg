/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapppoo;

import javaapppoo.Entity.Matematica;
import javaapppoo.Services.MatematicaService;

/**
 *
 * @author A309436
 */
public class Ejercicio09 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Realizar una clase llamada Matemática que tenga como atributos dos números reales con
        //los cuales se realizarán diferentes operaciones matemáticas. La clase deber tener un
        //constructor vacío, parametrizado y get y set. En el main se creará el objeto y se usará el
        //Math.random para generar los dos números y se guardaran en el objeto con su
        //respectivos set. Deberá además implementar los siguientes métodos:
        //a) Método devolverMayor() para retornar cuál de los dos atributos tiene el mayor valor
        //b) Método calcularPotencia() para calcular la potencia del mayor valor de la clase elevado
        //al menor número. Previamente se deben redondear ambos valores.
        //c) Método calculaRaiz(), para calcular la raíz cuadrada del menor de los dos valores.
        //Antes de calcular la raíz cuadrada se debe obtener el valor absoluto del número.

        Matematica m = new Matematica();
        MatematicaService ms = new MatematicaService();

        m.setPrimerNumero(Math.random() * 9 + 1);
        m.setSegundoNumero(Math.random() * 9 + 1);

        System.out.println("El primer numero es: " + m.getPrimerNumero());
        System.out.println("El segundo numero es: " + m.getSegundoNumero());

        System.out.println("El mayor de los dos números es: " + ms.devolverMayor(m));
        ms.calcularPotencia(m);
        ms.calcularRaiz(m);

    }

}
