/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapppoo;

import java.util.Scanner;
import javaapppoo.Entity.Circunferencia;
import javaapppoo.Services.CircunferenciaService;


/**
 *
 * @author A309436
 */
public class Ejercicio02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Declarar una clase llamada Circunferencia que tenga como atributo privado el radio de
        //tipo real. A continuación, se deben crear los siguientes métodos:
        //a) Método constructor que inicialice el radio pasado como parámetro.
        //b) Métodos get y set para el atributo radio de la clase Circunferencia.
        //c) Método para crearCircunferencia(): que le pide el radio y lo guarda en el atributo del
        //objeto.
        //d) Método area(): para calcular el área de la circunferencia (𝐀𝐫𝐞𝐚 = 𝛑 ∗ 𝐫𝐚𝐝𝐢𝐨𝟐).
        //e) Método perimetro(): para calcular el perímetro (𝐏𝐞𝐫𝐢𝐦𝐞𝐭𝐫𝐨 = 𝟐 ∗ 𝛑 ∗ 𝐫𝐚𝐝𝐢𝐨).
        Scanner leer = new Scanner(System.in);
        CircunferenciaService cs = new CircunferenciaService();
        Circunferencia c1 = cs.crearCircunferencia();
        
        System.out.println("El area de la circunferencia es: " + cs.calcularArea(c1));
        System.out.println("El perimetro de la circunferencia es: " + cs.calcularPerimetro(c1));

        
    }

}
