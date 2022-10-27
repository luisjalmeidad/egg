/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosextrascoach;

import Entity.Sopa;
import Service.SopaService;

/**
 *
 * @author A309436
 */
public class Ejercicio06 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Ejercicio 6
        //Crear una clase Sopa de letras que contenga un atributo matriz, y otro palabra a encontrar.
        //Llenar una matriz de 10x10 con palabras de 5 caracteres (todas de forma horizontal, en orden)
        //inicializándola por defecto con “palabras preestablecidas”.
        //Crear métodos:
        //● Que el usuario ingrese una palabra y la busque en la matriz. Deberá retornar en que
        //posición de la matriz inicia la palabra.
        //● Imprimir la sopa de letras en pantalla
        //● Que el usuario pueda reemplazar una palabra especifica de la matriz ya pre -cargada (Es
        //decir, por ejemplo, que si en posición 0.0 estaba perro, cambiarla a polo). Para realizar esta
        //gestión, el método recibirá la palabra a buscar y a reemplazar sus datos
        //● Imprimir la sopa de letras, invertida (es decir, filas por columnas)

        SopaService ss = new SopaService();
        Sopa sopa = ss.llenarMatriz();
        
        ss.imprimirSopa(sopa);        
        ss.imprimirSopaInvertida(sopa);        
        ss.reemplazarPalabra(sopa);
        ss.imprimirSopa(sopa);
    }

}
