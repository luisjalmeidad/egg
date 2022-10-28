/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entity.Ahorcado;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author A309436
 */
public class AhorcadoService {

    Scanner leer = new Scanner(System.in);

    public Ahorcado crearJuego() {

        String palabraSecreta;
        String[] vPalabraSecreta;
        Ahorcado ahorcado = new Ahorcado();

        System.out.println("Ingrese la palabra secreta");
        palabraSecreta = leer.next();

        vPalabraSecreta = new String[palabraSecreta.length()];

        for (int i = 0; i < vPalabraSecreta.length; i++) {

            vPalabraSecreta[i] = palabraSecreta.substring(i, i + 1);

        }

        ahorcado.setPalabraSecreta(vPalabraSecreta);

        System.out.println("Indique la cantidad de intentos para este juego");
        ahorcado.setCantidadIntentos(leer.nextInt());

        return ahorcado;

    }

    public void mostrarLongitud(Ahorcado aho) {
        System.out.println("La longtiud de la palabra es: " + aho.getPalabraSecreta().length);
    }

    public void buscarLetra(Ahorcado aho, String letra) {

        for (int i = 0; i < aho.getPalabraSecreta().length; i++) {

            if (aho.getPalabraSecreta()[i].equalsIgnoreCase(letra)) {
                System.out.println("¡La letra \"" + letra + "\" se encuentra en la palabra secreta!");
                return;
            }
        }
        System.out.println("No se encuentra la letra \"" + letra + "\" en la palabra secreta...");

    }

    public boolean letrasEncontradas(Ahorcado aho, String letra) {
        int contador = 0;
        boolean bandera;
        for (int i = 0; i < aho.getPalabraSecreta().length; i++) {

            if (aho.getPalabraSecreta()[i].equalsIgnoreCase(letra)) {
                contador++;
            }
        }

        if (contador > 0) {
            aho.setCantidadLetrasEncontradas(contador);
            bandera = true;
        } else {
            bandera = false;
        }

        System.out.println("Número de letras (encontradas, faltantes): (" + aho.getCantidadLetrasEncontradas() + "," + (aho.getPalabraSecreta().length - aho.getCantidadLetrasEncontradas()) + ")");
        return bandera;
    }

    public void mostrarIntentos(Ahorcado aho) {
        System.out.println("Número de oportunidades restantes: " + aho.getCantidadIntentos());
    }

    public boolean letraRepetida(Ahorcado aho, String letra) {

        if (!aho.getLetrasEncontradas().isEmpty()) {
            return aho.getLetrasEncontradas().contains(letra);
        }

        return false;
    }

    public void juego(Ahorcado aho) {

        String letra;
        String palabra = "";

        do {

            System.out.println("Ingrese una letra");
            letra = leer.next();
            if (!letraRepetida(aho, letra)) {
                aho.setLetrasEncontradas(letra);
                mostrarLongitud(aho);
                buscarLetra(aho, letra);
                if (!letrasEncontradas(aho, letra)) {
                    aho.setCantidadIntentos(aho.getCantidadIntentos() - 1);
                }
                mostrarIntentos(aho);
            } else {
                System.out.println("La letra \"" + letra + "\" ya la has seleccionado, prueba con otra letra");
            }
        } while (aho.getCantidadIntentos() > 0 && aho.getCantidadLetrasEncontradas() < aho.getPalabraSecreta().length);

        if (aho.getCantidadIntentos() == 0) {
            System.out.println("Mensaje: Lo sentimos, no hay más oportunidades.");
        } else {
            for (int i = 0; i < aho.getPalabraSecreta().length; i++) {
                palabra += aho.getPalabraSecreta()[i];
            }
            System.out.println("Mensaje: ¡Logró descifrar la palabra \"" + palabra + "\"!");
        }

    }

}
