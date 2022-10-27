/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapppoo;

import java.util.Scanner;
import javaapppoo.Entity.Cadena;
import javaapppoo.Services.CadenaService;

/**
 *
 * @author A309436
 */
public class Ejercicio08 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Realizar una clase llamada Cadena que tenga como atributos una frase (de tipo de String)
        //y su longitud. En el main se creará el objeto y se le pedirá al usuario que ingrese una frase
        //que puede ser una palabra o varias palabras separadas por un espacio en blanco y a
        //través de los métodos set, se guardará la frase y la longitud de manera automática según
        //la longitud de la frase ingresada. Deberá además implementar los siguientes métodos:
        //a) Método mostrarVocales(), deberá contabilizar la cantidad de vocales que tiene la frase
        //ingresada.
        //b) Método invertirFrase(), deberá invertir la frase ingresada y mostrarla por pantalla. Por
        //ejemplo: Entrada: "casa blanca", Salida: "acnalb asac".
        //c) Método vecesRepetido(String letra), recibirá un carácter ingresado por el usuario y
        //contabilizar cuántas veces se repite el carácter en la frase, por ejemplo:
        //d) Entrada: frase = "casa blanca". Salida: El carácter 'a' se repite 4 veces.
        //e) Método compararLongitud(String frase), deberá comparar la longitud de la frase que
        //compone la clase con otra nueva frase ingresada por el usuario.
        //f) Método unirFrases(String frase), deberá unir la frase contenida en la clase Cadena con
        //una nueva frase ingresada por el usuario y mostrar la frase resultante.
        //g) Método reemplazar(String letra), deberá reemplazar todas las letras “a” que se
        //encuentren en la frase, por algún otro carácter seleccionado por el usuario y mostrar la
        //frase resultante.
        //h) Método contiene(String letra), deberá comprobar si la frase contiene una letra que
        //ingresa el usuario y devuelve verdadero si la contiene y falso si no.

        Scanner leer = new Scanner(System.in);
        CadenaService cs = new CadenaService();
        Cadena c1 = new Cadena();
        Cadena c2 = new Cadena();

        System.out.println("Ingrese una palabra o frase");
        c1.setFrase(leer.nextLine());
        c1.setLongitud(c1.getFrase().length());

        cs.mostrarVocales(c1);
        cs.invertirFrase(c1);

        System.out.println("Indique la letra que desea buscar en la frase");
        cs.vecesRepetido(c1, leer.nextLine());

        System.out.println("Ingrese una segunda frase para comparar");
        c2.setFrase(leer.nextLine());
        c2.setLongitud(c2.getFrase().length());
        cs.compararLongitud(c1, c2);

        System.out.println("Ingrese una frase para unir con la primera frase");
        c2.setFrase(leer.nextLine());
        c2.setLongitud(c2.getFrase().length());
        cs.unirFrases(c1, c2);

        System.out.println("Indique una letra para ser reemplazada por las 'a' de la primera frase");
        cs.reemplazar(c1, leer.nextLine());

        System.out.println("Indique una letra para verificar si está en la primera frase");
        if (cs.contiene(c1, leer.nextLine())) {
            System.out.println("¡La frase " + c1.getFrase() + " contiene la letra!");
        } else {
            System.out.println("La frase no contiene la letra");
        }

    }

}
