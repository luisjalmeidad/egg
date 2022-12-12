package herencia;

import Entity.Electrodomestico;
import Entity.Lavadora;
import Entity.Televisor;
import Services.LavadoraService;
import Services.TelevisorService;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio02 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        ArrayList<Electrodomestico> electrodomesticos = new ArrayList();
        LavadoraService ls = new LavadoraService();
        TelevisorService ts = new TelevisorService();
        double totalLav = 0;
        double totalTele = 0;

        System.out.println("Cargando lista de electrodomesticos...");
        electrodomesticos.add(new Lavadora(1000, "Negro", 'A', 90, 35));
        electrodomesticos.add(new Lavadora(1000, "Rojo", 'B', 55, 15));
        electrodomesticos.add(new Televisor(55, false, 1000, "Azul", 'C', 10));
        electrodomesticos.add(new Televisor(24, true, 1000, "Gris", 'E', 85));        
        
        System.out.println("Calculando precios...");
        for (Electrodomestico electrodomestico : electrodomesticos) {
            if (electrodomestico instanceof Lavadora) {
                Lavadora lav = (Lavadora) electrodomestico;
                ls.precioFinal(lav);
                totalLav += lav.getPrecio();
                System.out.println("Lavadora: " + lav.getColor() + " Precio: " + lav.getPrecio());
            }
            if (electrodomestico instanceof Televisor) {
                Televisor tele = (Televisor) electrodomestico;
                ts.precioFinal(tele);                               
                totalTele += tele.getPrecio();
                System.out.println("Televisor: " + tele.getColor() + " Precio: " + tele.getPrecio());
            }
        }

        System.out.println("");
        System.out.println("Monto total en lavadoras: " + totalLav);
        System.out.println("Monto total en televisores: " + totalTele);
        System.out.println("Monto total: " + (totalLav + totalTele));
        
    }
}
