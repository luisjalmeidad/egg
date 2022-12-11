/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Entity.Carta;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author A309436
 */
public class BarajaService {

    Scanner leer = new Scanner(System.in);

    public Carta crearCarta(int numero, String palo) {
        return new Carta(numero, palo);
    }

    public void armarBaraja(ArrayList<Carta> baraja) {
        int listaNumneros[] = {1, 2, 3, 4, 5, 6, 7, 10, 11, 12};
        String listaPalos[] = {"Espada", "Oro", "Baston", "Copa"};

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 10; j++) {
                baraja.add(crearCarta(listaNumneros[j], listaPalos[i]));
            }
        }
    }

    public void imprimirBaraja(ArrayList<Carta> baraja) {
        for (Carta carta : baraja) {
            System.out.println(carta.toString());
        }
    }

    //• barajar(): cambia de posición todas las cartas aleatoriamente.
    public void barajar(ArrayList<Carta> baraja) {
        Collections.shuffle(baraja);
    }

    //• siguienteCarta(): devuelve la siguiente carta que está en la baraja, cuando no haya más o
    //se haya llegado al final, se indica al usuario que no hay más cartas.
    public Carta siguienteCarta(ArrayList<Carta> baraja, ArrayList<Carta> monton) {
        Carta c = new Carta();
        Iterator<Carta> it = baraja.iterator();
        c = it.next();
        it.remove();
        monton.add(new Carta(c.getNumero(), c.getPalo()));
        return c;
    }

//• cartasDisponibles(): indica el número de cartas que aún se puede repartir.
    public int cartasDisponibles(ArrayList<Carta> baraja) {
        return baraja.size();
    }
//• darCartas(): dado un número de cartas que nos pidan, le devolveremos ese número de
//cartas. En caso de que haya menos cartas que las pedidas, no devolveremos nada, pero
//debemos indicárselo al usuario.

    public ArrayList<Carta> darCartas(ArrayList<Carta> baraja, ArrayList<Carta> monton, int cantidadCartas) {
        ArrayList<Carta> cartas = new ArrayList();

        for (int i = 0; i < cantidadCartas; i++) {
            cartas.add(siguienteCarta(baraja, monton));
        }

        return cartas;
    }

//• cartasMonton(): mostramos aquellas cartas que ya han salido, si no ha salido ninguna
//indicárselo al usuario
    public void mostrarMonton(ArrayList<Carta> monton) {
        if (monton.size() > 0) {
            for (Carta carta : monton) {
                System.out.println(carta.toString());
            }
        } else {
            System.out.println("No hay cartas");
        }

    }
////• mostrarBaraja(): muestra todas las cartas hasta el final. Es decir, si se saca una carta y
//    //luego se llama al método, este no mostrara esa primera carta.
//    public void mostrarBaraja(ArrayList<Carta> baraja) {
//        if (baraja.size() > 0) {
//            for (Carta carta : baraja) {
//                System.out.println(carta.toString());
//            }
//        } else {
//            System.out.println("No hay cartas");
//        }
//    }

    public void iniciarJuego() {
        ArrayList<Carta> baraja = new ArrayList();
        ArrayList<Carta> monton = new ArrayList();
        ArrayList<Carta> cartas = new ArrayList();
        int cantidadCartas = 0;
        int opcion = 0;

        System.out.println("Creando baraja de cartas...");
        armarBaraja(baraja);
        barajar(baraja);

        System.out.println("------------- Baraja -------------");
        
        do {
            System.out.println("------------- MENU -------------");
            System.out.println("1 - Mezclar cartas");
            System.out.println("2 - Pedir cartas");
            System.out.println("3 - Siguiente carta");
            System.out.println("4 - Mostrar cartas de la baraja");
            System.out.println("5 - Mostrar cartas del monton");
            System.out.println("6 - Cantidad de cartas disponible");
            System.out.println("7 - Cantidad de cartas en el monton");
            System.out.println("8 - Reiniciar Juego");
            System.out.println("9 - Salir");
            System.out.println("------------- MENU -------------");

            try {
                opcion = leer.nextInt();
            } catch (Exception e) {
                System.out.println("ERROR: Ingreso un valor invalido.");
                opcion = 9;
                leer.next();
            }

            switch (opcion) {
                case 1:
                    System.out.println("");
                    System.out.println("Mezclando cartas...");
                    barajar(baraja);
                    break;
                case 2:
                    System.out.println("");
                    System.out.println("Indique la cantidad de cartas a tomar.");
                    cantidadCartas = leer.nextInt();

                    System.out.println("");
                    if (cartasDisponibles(baraja) >= cantidadCartas) {
                        System.out.println("Repartiendo " + cantidadCartas + " cartas.");
                        cartas = darCartas(baraja, monton, cantidadCartas);
                    } else {
                        System.out.println("Solo tienes " + cartasDisponibles(baraja) + " cartas disponibles.");
                    }

                    System.out.println("");
                    System.out.println("------------- Cartas entregadas -------------");
                    mostrarMonton(cartas);
                    break;
                case 3:
                    System.out.println("");
                    if (cartasDisponibles(baraja) >= 1) {
                        System.out.println(siguienteCarta(baraja, monton).toString());
                    } else {
                        System.out.println("No tienes cartas disponibles.");
                    }
                    break;
                case 4:
                    System.out.println("Cartas en la baraja.");
                    mostrarMonton(baraja);
                    break;
                case 5:
                    System.out.println("Cartas en el monton.");
                    mostrarMonton(monton);
                    break;
                case 6:
                    System.out.println("Quedan " + cartasDisponibles(baraja) + " cartas disponibles.");
                    break;
                case 7:
                    System.out.println("Hay " + cartasDisponibles(monton) + " cartas en el monton.");
                    break;
                case 8:
                    System.out.println("Reiniciando juego...");
                    baraja.clear();
                    monton.clear();
                    cartas.clear();
                    armarBaraja(baraja);
                    barajar(baraja);
                    break;
                default:
                    opcion = 9;
            }

        } while (opcion != 9);
        
        System.out.println("Fin del juego");       

    }
}
