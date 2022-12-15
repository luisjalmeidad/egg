/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package herencia;

import Entity.Alojamiento;
import Entity.Camping;
import Entity.Hotel;
import static Entity.Hotel.compararPrecio;
import Entity.Hotel4;
import Entity.Hotel5;
import Entity.Residencia;
import Services.Hotel4Service;
import Services.Hotel5Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author A309436
 */
public class EjercicioExtra03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        ArrayList<Alojamiento> alojamientos = new ArrayList();
        ArrayList<Hotel> hoteles = new ArrayList<>();
        Hotel5Service h5s = new Hotel5Service();
        Hotel4Service h4s = new Hotel4Service();
        int opcion = 0;

        alojamientos.add(new Hotel4('B', "LucioFood", 40, 200, 400, 10, 0, "LucioParadise", "Cerca del obelisco", "San Nicolas", "Lucio"));
        alojamientos.add(new Hotel4('A', "AmigoFood", 20, 100, 250, 20, 0, "LucioLand", "Bosques de Palermo", "Palermo", "Lucio"));

        alojamientos.add(new Hotel5(1, 5, 4, 'A', "LuisFood", 40, 200, 400, 10, 0, "LuisParadise", "Cerca del obelisco", "San Nicolas", "Luis"));
        alojamientos.add(new Hotel5(2, 10, 8, 'B', "Food&Food", 15, 50, 100, 5, 0, "Luisland", "Once", "Balvanera", "Luis"));

        alojamientos.add(new Camping(7, 2, true, true, 34.4, "HectorTravel", "Cerca de Cordoba", "Cordoba", "Hector"));
        alojamientos.add(new Camping(14, 4, false, false, 68.8, "HectorAdventure", "Cerca de Cordoba", "Cordoba", "Hector"));

        alojamientos.add(new Residencia(false, false, false, 25.6,  "Fabriland", "Cerca de Cordoba", "Cordoba", "Fabricio"));
        alojamientos.add(new Residencia(true, true, true, 25.6, "FabriAdventure", "Cerca de Cordoba", "Cordoba", "Fabricio"));

        //Calculamos los precios de los hoteles
        for (Alojamiento alojamiento : alojamientos) {
            if (alojamiento instanceof Hotel5) {
                h5s.calcularPrecioHabitacion((Hotel5) alojamiento);
                continue;
            }
            
            if (alojamiento instanceof Hotel4) {
                h4s.calcularPrecioHabitacion((Hotel4) alojamiento);
            }            
        }
        
        
        do {
            System.out.println("---------------------------- Menu ----------------------------");
            System.out.println("1 - Imprimir todos los alojamientos");
            System.out.println("2 - Imprimir todos los hoteles");
            System.out.println("3 - Imprimir todos los campings con restaurante");
            System.out.println("4 - Imprimir todas las residencias con descuento");
            System.out.println("5 - Salir");
            System.out.println("---------------------------- Menu ----------------------------");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    for (Alojamiento alojamiento : alojamientos) {
                        System.out.println(alojamiento.toString());
                    }
                    break;
                case 2:
                    for (Alojamiento alojamiento : alojamientos) {
                        if (alojamiento instanceof Hotel) {                            
                            hoteles.add((Hotel) alojamiento); 
                        }                        
                    }
                    
                    hoteles.sort(compararPrecio);
                    
                    for (Hotel hotel : hoteles) {
                        System.out.println(hotel.toString());
                    }
                    break;
                     case 3:
                    for (Alojamiento alojamiento : alojamientos) {
                        if (alojamiento instanceof Camping) {
                            if ( ((Camping)alojamiento).isRestaurante() ) {
                                System.out.println(alojamiento.toString());
                            }
                        }                        
                    }
                    break;
                     case 4:
                    for (Alojamiento alojamiento : alojamientos) {
                        if (alojamiento instanceof Residencia) {
                            if ( ((Residencia)alojamiento).isDescGremio()) {
                                System.out.println(alojamiento.toString());
                            }
                        }                        
                    }
                    break;
                default:
                    opcion = 5;
            }

        } while (opcion != 5);

    }

}
