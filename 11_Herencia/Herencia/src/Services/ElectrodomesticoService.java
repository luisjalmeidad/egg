/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Entity.Electrodomestico;
import java.util.Scanner;

/**
 *
 * @author A309436
 */
public class ElectrodomesticoService {
//• Metodo crearElectrodomestico(): le pide la información al usuario y llena el
//electrodoméstico, también llama los métodos para comprobar el color y el consumo. Al
//precio se le da un valor base de $1000.

    protected Electrodomestico crearElectrodomestico() {
        Scanner leer = new Scanner(System.in);

        System.out.println("¿Que color tiene su electrodomestico?");
        String color = leer.next();

        System.out.println("¿Que peso tiene su electrodomestico?");
        double peso = leer.nextDouble();

        System.out.println("Indique el consumo energetico de A a la F");
        char consumoEnergetico = leer.next().charAt(0);

        double precio = 1000;

        return new Electrodomestico(precio, color, consumoEnergetico, peso);

    }

    protected void precioFinal(Electrodomestico e) {
        char letras[] = {'A', 'B', 'C', 'D', 'E', 'F'};
        double precios[] = {1000, 800, 600, 500, 300, 100};

        for (int i = 0; i < letras.length; i++) {
            if (letras[i] == e.getConsumoEnergetico()) {
                e.setPrecio(e.getPrecio() + precios[i]);
            }
        }

        if (e.getPeso() >= 1 && e.getPeso() <= 19) {
            e.setPrecio(e.getPrecio() + 100);
        } else if (e.getPeso() <= 49) {
            e.setPrecio(e.getPrecio() + 500);
        } else if (e.getPeso() <= 79) {
            e.setPrecio(e.getPrecio() + 800);
        } else {
            e.setPrecio(e.getPrecio() + 1000);
        }
    }
}
