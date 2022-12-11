/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Entity.Cine;
import Entity.Espectador;
import Entity.Pelicula;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author A309436
 */
public class CineService {

    Scanner leer = new Scanner(System.in);

    public Espectador crearEspectador() {

        int nombre = (int) (Math.random() * 100) + 1;
        int edad = (int) (Math.random() * 100) + 1;
        double dinero = Math.round((((Math.random() * 100) + 1) * 100)*100.0)/100.0;

        Espectador e = new Espectador(nombre, edad, dinero);

        return e;
    }

    public void crearListaEspectadores(ArrayList<Espectador> lista) {
        int numEspectadores = (int) (Math.random() * 29) + 20;

        System.out.println("Tenemos " + numEspectadores + " espectadores.");

        for (int i = 0; i < numEspectadores; i++) {
            lista.add(crearEspectador());
        }
    }

    public void crearListaPeliculas(ArrayList<Pelicula> lista) {
        lista.add(new Pelicula("It", 2.5, 50, "Joaquin"));
        lista.add(new Pelicula("ElAro", 2, 80, "Luis"));
        lista.add(new Pelicula("Barney", 2.5, 20, "Karen"));
    }

    public Cine crearCine() {
        Cine c = new Cine();        
        double precio = Math.round((((Math.random() * 10) + 5) * 100)*100.0)/100.0;
        String sala[][] = new String[8][6];
        
        inicializarSala(sala);
        
        c.setPrecio(precio);
        c.setSala(sala);  
        
        System.out.println("Cine abierto - Entrada en " + precio + "$.");
        
        return c;
    }

    public void inicializarSala(String sala[][]) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                sala[i][j] = " ";
            }
        }
    }

    public void imprimirListaEspectador(ArrayList<Espectador> lista) {
        System.out.println("");
        System.out.println("------------ Espectadores ------------");
        for (Espectador espectador : lista) {
            System.out.println(espectador.toString());
        }
        System.out.println("------------ Espectadores ------------");
    }

    public void imprimirListaPelicula(ArrayList<Pelicula> lista) {
        System.out.println("");
        System.out.println("------------ Peliculas ------------");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println((i + 1) + " - " + lista.get(i).toString());
        }
        System.out.println("------------ Peliculas ------------");
    }

    public void llenarSala(ArrayList<Espectador> espectadores, Cine cine) {

        String sala[][] = cine.getSala();
        boolean estaSentado = false;
        int fila;
        int columna;

        for (int i = 0; i < espectadores.size(); i++) {

            estaSentado = false;

            if (espectadores.get(i).getDinero() < cine.getPrecio()) {
                System.out.println("El " + espectadores.get(i).getNombre() + " No tiene fondos para costear la entrada");
                continue;
            }

            if (espectadores.get(i).getEdad() < cine.getPelicula().getEdadMin()) {
                System.out.println("El " + espectadores.get(i).getNombre() + " No cumple con la edad minima.");
                continue;
            }

            do {
                System.out.println("Buscando lugar para " + espectadores.get(i).toString());

                //Asiento aleatorio
                fila = (int) (Math.random() * 8);
                columna = (int) (Math.random() * 6);

                System.out.println("Coordenadas seleccionadas [" + fila + "," + columna + "]");

                if (sala[fila][columna] != "X") {
                    sala[fila][columna] = "X";
                    estaSentado = true;
                    System.out.println("Se pudo sentar");
                } else {
                    System.out.println("El lugar esta ocupado, buscaremos otro lugar");
                    estaSentado = false;
                }
            } while (!estaSentado);
        }
        cine.setSala(sala);
    }

    public void imprimirSala(Cine cine) {
        System.out.println("");
        System.out.println("------------ Sala ------------");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(" [" + cine.getSala()[i][j] + "] ");
            }
            System.out.println("");
        }
        System.out.println("------------ Sala ------------");
    }

    public void abrirCine() {
        int opcion = 0;
        int pelicula = 0;
        int opcionSalir = 5;
        ArrayList<Espectador> listaEspectadores = new ArrayList();
        ArrayList<Pelicula> listaPeliculas = new ArrayList();
        Cine cine = crearCine();

        crearListaEspectadores(listaEspectadores);
        crearListaPeliculas(listaPeliculas);

        do {
            System.out.println("");
            System.out.println("------------ Menu ------------");
            System.out.println("1 - Seleccionar pelicula");
            System.out.println("2 - Asignar asientos");
            System.out.println("3 - Ver sala");
            System.out.println("4 - Ver espectadores");
            System.out.println("5 - Salir");
            System.out.println("------------ Menu ------------");

            try {
                opcion = leer.nextInt();

                if (opcion > opcionSalir || opcion < 1) {
                    System.out.println("Error: Opcion fuera de rango");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Error: Ingreso un valor invalido");
                leer.next();
                continue;
            }

            switch (opcion) {
                case 1:
                    imprimirListaPelicula(listaPeliculas);
                    try {
                        pelicula = leer.nextInt();

                        if (pelicula > (listaPeliculas.size()) || pelicula < 1) {
                            System.out.println("Error: Opcion fuera de rango");
                            continue;
                        }
                        
                        cine.setPelicula(listaPeliculas.get(pelicula - 1));                        

                    } catch (Exception e) {
                        System.out.println("Error: Ingreso un valor invalido");
                        leer.next();
                        continue;
                    }
                    break;
                case 2:
                    if (cine.getPelicula() == null) {
                        System.out.println("");
                        System.out.println("Aviso: Primero debe seleccionar una pelicula");
                        continue;
                    }
                    llenarSala(listaEspectadores, cine);
                    break;
                case 3:
                    imprimirSala(cine);
                    break;
                case 4:
                    imprimirListaEspectador(listaEspectadores);
                    break;
            }
        } while (opcion != opcionSalir);
    }
}
