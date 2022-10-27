/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapppoo.Services;

import javaapppoo.Entity.Cadena;

/**
 *
 * @author A309436
 */
public class CadenaService {

//    a) Método mostrarVocales(), deberá contabilizar la cantidad de vocales que tiene la frase
//    ingresada.
    public void mostrarVocales(Cadena c1) {

        int contador = 0;
        String subFrase = "";

        for (int i = 0; i < c1.getLongitud(); i++) {

            subFrase = c1.getFrase().substring(i, i + 1);
            if (subFrase.equalsIgnoreCase("a") || subFrase.equalsIgnoreCase("e") || subFrase.equalsIgnoreCase("i") || subFrase.equalsIgnoreCase("o") || subFrase.equalsIgnoreCase("u")) {
                contador++;
            }
        }
        if (contador > 1) {
            System.out.println("La frase tiene " + contador + " vocales.");
        }else if(contador == 1){
            System.out.println("La frase tiene " + contador + " vocal.");
        }else{
            System.out.println("la frase no contiene vocales");
        }
            
        
    }

//    b) Método invertirFrase(), deberá invertir la frase ingresada y mostrarla por pantalla. Por
//    ejemplo: Entrada: "casa blanca", Salida: "acnalb asac".
    public void invertirFrase(Cadena c1) {
        String fraseInvertida = "";

        for (int i = c1.getLongitud() - 1; i > -1; i--) {

            fraseInvertida += c1.getFrase().substring(i, i + 1);

        }

        System.out.println("Frase invertida: " + fraseInvertida);
    }
//    c) Método vecesRepetido(String letra), recibirá un carácter ingresado por el usuario y
//    contabilizar cuántas veces se repite el carácter en la frase, por ejemplo:
//    d) Entrada: frase = "casa blanca". Salida: El carácter 'a' se repite 4 veces.

    public void vecesRepetido(Cadena c1, String letra) {

        int contador = 0;
        String subFrase = "";

        for (int i = 0; i < c1.getLongitud(); i++) {

            subFrase = c1.getFrase().substring(i, i + 1);
            if (subFrase.equalsIgnoreCase(letra)) {
                contador++;
            }
        }

        if (contador > 1) {
            System.out.println("La letra '" + letra + "' está contenida en la frase " + contador + " veces.");
        } else if (contador == 1) {
            System.out.println("La letra '" + letra + "' está contenida en la frase " + contador + " vez.");
        } else {
            System.out.println("La letra '" + letra + "' no está contenida en la frase");
        }

    }

//    e) Método compararLongitud(String frase), deberá comparar la longitud de la frase que
//    compone la clase con otra nueva frase ingresada por el usuario.
    public void compararLongitud(Cadena c1, Cadena c2) {

        if (c1.getLongitud() > c2.getLongitud()) {
            System.out.println("La longitud de la frase '" + c1.getFrase() + "'  es mayor a la frase '" + c2.getFrase() + "'");
        } else if (c1.getLongitud() < c2.getLongitud()) {
            System.out.println("La longitud de la frase '" + c1.getFrase() + "'  es menor a la frase '" + c2.getFrase() + "'");
        } else {
            System.out.println("La longitud de la frase '" + c1.getFrase() + "'  es igual a la frase '" + c2.getFrase() + "'");
        }

    }

//    f) Método unirFrases(String frase), deberá unir la frase contenida en la clase Cadena con
//    una nueva frase ingresada por el usuario y mostrar la frase resultante.
    public void unirFrases(Cadena c1, Cadena c2) {

        System.out.println("Al unir las frases obtenemos: " + c1.getFrase().concat(" " + c2.getFrase()));

    }

//    g) Método reemplazar(String letra), deberá reemplazar todas las letras “a” que se
//    encuentren en la frase, por algún otro carácter seleccionado por el usuario y mostrar la
//    frase resultante.
    public void reemplazar(Cadena c1, String letra) {

        String subFrase = "";
        boolean contieneLetra = false;
        
        for (int i = 0; i < c1.getLongitud(); i++) {

            if (c1.getFrase().substring(i, i + 1).equalsIgnoreCase("a")) {
                subFrase += letra;
                contieneLetra = true;
            } else {
                subFrase += c1.getFrase().substring(i, i + 1);
            }
        }
        if (contieneLetra) {
            System.out.println("La frase resultante es " + subFrase);
        }else{
            System.out.println("La frase no tiene letras 'a' para reemplazar");
        }
                
        

    }

//    h) Método contiene(String letra), deberá comprobar si la frase contiene una letra que
//    ingresa el usuario y devuelve verdadero si la contiene y falso si no.
    public boolean contiene(Cadena c1, String letra) {

        boolean contieneLetra = false;

        for (int i = 0; i < c1.getLongitud(); i++) {

            if (c1.getFrase().substring(i, i + 1).equalsIgnoreCase(letra)) {
                contieneLetra = true;
            }
        }

        return contieneLetra;

    }

}
