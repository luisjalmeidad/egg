/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapppoo.Services;

import javaapppoo.Entity.Matematica;

/**
 *
 * @author A309436
 */
public class MatematicaService {

    //a) Método devolverMayor() para retornar cuál de los dos atributos tiene el mayor valor
    public double devolverMayor(Matematica m) {

        if (m.getPrimerNumero() > m.getSegundoNumero()) {

            return m.getPrimerNumero();

        } else if (m.getPrimerNumero() < m.getSegundoNumero()) {

            return m.getSegundoNumero();
        } else {
            return 0;
        }

    }

    public double devolverMenor(Matematica m) {

        if (m.getPrimerNumero() > m.getSegundoNumero()) {

            return m.getSegundoNumero();

        } else if (m.getPrimerNumero() < m.getSegundoNumero()) {

            return m.getPrimerNumero();
        } else {
            return 0;
        }

    }

    //b) Método calcularPotencia() para calcular la potencia del mayor valor de la clase elevado
    //al menor número. Previamente se deben redondear ambos valores.
    public void calcularPotencia(Matematica m) {

        System.out.println("La potencia de " + Math.round(devolverMayor(m)) +" es: " + Math.pow(Math.round(devolverMayor(m)), Math.round(devolverMenor(m))));

    }

    //c) Método calculaRaiz(), para calcular la raíz cuadrada del menor de los dos valores.
    //Antes de calcular la raíz cuadrada se debe obtener el valor absoluto del número.
    
    public void calcularRaiz(Matematica m){
        
        System.out.println("La raiz cuadrada de " + Math.abs(devolverMenor(m)) + " es: " + Math.sqrt(Math.abs(devolverMenor(m))));        
    }
}
