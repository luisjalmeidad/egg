/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Sopa;
import java.util.Scanner;

/**
 *
 * @author A309436
 */
public class SopaService {

    Scanner leer = new Scanner(System.in);

    public Sopa llenarMatriz() {
        Sopa sopa = new Sopa();
        String mSopa[][] = new String[10][10];
        String vPalabra[] = {"perro", "raton", "canto", "retar", "balsa", "callo", "campo", "curso", "danza", "gorra", "mango", "lucha", "malta", "manco", "mover", "ovulo", "playa", "resto", "santa", "sueco"};
        int posicion = 0;
        int posicionCadena = 0;

        for (int i = 0; i < mSopa.length; i++) {
            for (int j = 0; j < mSopa.length; j++) {

                mSopa[i][j] = vPalabra[posicion].substring(posicionCadena, posicionCadena + 1);
                posicionCadena++;

                if (j == 4 || j == 9) {
                    posicionCadena = 0;
                    posicion++;
                }

            }
            System.out.println("");
        }

        sopa.setSopa(mSopa);

        return sopa;

    }

    public int[] buscarPalabra(Sopa sopa) {

        int posicionCadena = 0;
        int cantidadAciertos = 0;
        int posicion[] = new int[2];

        System.out.println("Ingrese la palabra a buscar");
        sopa.setPalabraEcontrar(leer.next());

        for (int i = 0; i < sopa.getSopa().length; i++) {
            for (int j = 0; j < sopa.getSopa().length; j++) {

                if (sopa.getSopa()[i][j].equalsIgnoreCase(sopa.getPalabraEcontrar().substring(posicionCadena, posicionCadena + 1))) {
                    cantidadAciertos++;
                }

                if (cantidadAciertos == 5) {
                    posicion[0] = i;
                    posicion[1] = (j - 4);
                    System.out.println("La posicion de la palabra es: (" + posicion[0] + "," + posicion[1] + ")");
                    return posicion;
                }

                posicionCadena++;

                if (j == 4 || j == 9) {
                    posicionCadena = 0;
                    cantidadAciertos = 0;
                }

            }
        }
        System.out.println("No se encontro la palabra");
        return posicion;
    }

    public void reemplazarPalabra(Sopa sopa) {
        String palabraNueva;
        String sopaNueva[][];
        int posicion[];

        posicion = buscarPalabra(sopa);

        System.out.println("Indique la palabra nueva");
        palabraNueva = leer.next();

        sopaNueva = sopa.getSopa();

        for (int i = 0; i < palabraNueva.length(); i++) {
            sopaNueva[posicion[0]][posicion[1] + i] = palabraNueva.substring(i, i + 1);
        }

        sopa.setSopa(sopaNueva);

    }

    public void imprimirSopa(Sopa sopa) {
        for (int i = 0; i < sopa.getSopa().length; i++) {
            for (int j = 0; j < sopa.getSopa().length; j++) {
                System.out.print("| " + sopa.getSopa()[i][j] + " |");
            }
            System.out.println("");
        }
    }

    public void imprimirSopaInvertida(Sopa sopa) {
        System.out.println("");
        System.out.println(" ---------------- SOPA INVERTIDA -------------------");

        for (int i = 0; i < sopa.getSopa().length; i++) {
            for (int j = 0; j < sopa.getSopa().length; j++) {
                System.out.print("| " + sopa.getSopa()[j][i] + " |");
            }
            System.out.println("");
        }

        System.out.println(" ---------------- SOPA INVERTIDA -------------------");
        System.out.println("");
    }

}
