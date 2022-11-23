/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Entity.Juego;
import Entity.Jugador;
import Entity.Revolver;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author A309436
 */
public class JuegoService {

    Scanner leer = new Scanner(System.in);

    //• llenarRevolver(): le pone los valores de posición actual y de posición del agua. Los valores
    //deben ser aleatorios.
    public void llenarRevolver(Revolver r) {
        r.setPosicionActual((int) (Math.random() * 6) + 1);
        r.setPosicionAgua((int) (Math.random() * 6) + 1);
    }

    //• mojar(): devuelve true si la posición del agua coincide con la posición actual
    public boolean mojar(Revolver r) {
        System.out.println("El revolver esta en la posicion " + r.getPosicionActual());
        System.out.println("Posicion de la bala " + r.getPosicionAgua());
        if (r.getPosicionActual() == r.getPosicionAgua()) {
            return true;
        }

        return false;

    }

    //• siguienteChorro(): cambia a la siguiente posición del tambor
    public void siguienteChorro(Revolver r) {

        if (r.getPosicionActual() == 6) {
            r.setPosicionActual(1);
            return;
        }

        r.setPosicionActual(r.getPosicionActual() + 1);
    }

    //disparo(Revolver r): el método, recibe el revolver de agua y llama a los métodos de
    //mojar() y siguienteChorro() de Revolver. El jugador se apunta, aprieta el gatillo y si el
    //revolver tira el agua, el jugador se moja. El atributo mojado pasa a false y el método
    //devuelve true, sino false.
    public boolean disparo(Revolver r, Jugador j) {

        if (mojar(r)) {
            j.setEstaMojado(true);
        } else {
            j.setEstaMojado(false);
        }

        siguienteChorro(r);

        return j.isMojado();
    }

    public Jugador crearJugador(int id) {

        Jugador j = new Jugador();

        j.setId(id);
        j.setNombre("Jugador" + id);
        j.setEstaMojado(false);

        return j;
    }

    public void llenarListaJugadores(ArrayList<Jugador> jugadores) {
        int cantidadJugadores;
        System.out.println("Indique la cantidad de jugadores del 1 al 6");

        try {
            cantidadJugadores = leer.nextInt();
        } catch (Exception e) {
            cantidadJugadores = 6;
        }

        if (cantidadJugadores < 1 || cantidadJugadores > 6) {
            cantidadJugadores = 6;
        }

        for (int i = 0; i < cantidadJugadores; i++) {
            jugadores.add(crearJugador(i + 1));
        }
    }

    //• llenarJuego(ArrayList<Jugador>jugadores, Revolver r): este método recibe los jugadores
    //y el revolver para guardarlos en los atributos del juego.
    //10
    public Juego llenarJuego(ArrayList<Jugador> jugadores, Revolver r) {

        Juego juego = new Juego();

        // Metodo llenar jugadores
        llenarListaJugadores(jugadores);

        juego.setJugadores(jugadores);
        juego.setRevolver(r);

        return juego;

    }

    //ronda(): cada ronda consiste en un jugador que se apunta con el revolver de agua y
    //aprieta el gatillo. Sí el revolver tira el agua el jugador se moja y se termina el juego, sino se
    //moja, se pasa al siguiente jugador hasta que uno se moje. Si o si alguien se tiene que
    //mojar. Al final del juego, se debe mostrar que jugador se mojó.
    //Pensar la lógica necesaria para realizar esto, usando los atributos de la clase Juego.
    public void ronda(Juego juego) {
        boolean bandera;
        int contador = 0;

        do {
            System.out.println(juego.getJugadores().get(contador).getNombre() + " Va a disparar");
            bandera = disparo(juego.getRevolver(), juego.getJugadores().get(contador));

            if (!bandera) {
                contador += 1;
            }

            if (contador == juego.getJugadores().size()) {
                contador = 0;
            }

        } while (!bandera);

        System.out.println("El " + juego.getJugadores().get(contador) + " ha perdido");
        System.out.println("Fin del juego");

    }

}
