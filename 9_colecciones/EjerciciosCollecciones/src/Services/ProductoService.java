/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entity.Producto;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author A309436
 */
public class ProductoService {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public Producto crearProducto() {
        Producto p = new Producto();

        System.out.println("Ingrese el nombre del producto");
        p.setNombre(leer.next());
        System.out.println("Ingrese el precio del producto: " + p.getNombre());
        p.setPrecio(leer.nextDouble());

        return p;
    }

    public void agregarProductoMapa(HashMap<String, Double> mapa) {
        String respuesta;
        Producto p;

        do {
            p = crearProducto();
            // Split de nombre y precio
            mapa.put(p.getNombre(), p.getPrecio());
            System.out.println("¿Desea agregar otro producto?");
            respuesta = leer.next();

        } while (respuesta.equalsIgnoreCase("S"));
    }

    public void modificarPrecio(HashMap<String, Double> mapa) {

        String producto;
        Double precio;
        boolean existe = false;

        System.out.println("¿A que producto desea cambiarle el precio?");
        producto = leer.next();

        for (Map.Entry<String, Double> entry : mapa.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(producto)) {
                existe = true;
                System.out.println("Ingrese el nuevo precio");
                entry.setValue(leer.nextDouble());

            }

        }

        if (existe) {
            System.out.println("Precio modificado");
        } else {
            System.out.println("El producto " + producto + " no existe");
        }

    }

    public void eliminarProducto(HashMap<String, Double> mapa) {

        System.out.println("¿Que producto desea eliminar?");
        String producto = leer.next();
        boolean existe = false;

        for (Iterator<String> iterator = mapa.keySet().iterator(); iterator.hasNext();) {
            String key = iterator.next();
            if (key.equalsIgnoreCase(producto)) {
                existe = true;
                iterator.remove();
            }
        }

        if (existe) {
            System.out.println("El producto " + producto + " fue eliminado.");
        } else {
            System.out.println(" El producto " + producto + " no existe.");
        }
    }

    public void imprimirMapaPrecio(HashMap<String, Double> mapa) {

        System.out.println("Indique el precio de referencia para mostrar productos");
        Double precio = leer.nextDouble();

        for (Map.Entry<String, Double> entry : mapa.entrySet()) {
            if (entry.getValue() == precio.doubleValue()) {
                System.out.println("Producto: " + entry.getKey() + " Precio: " + entry.getValue());
            }

        }
    }

    public void imprimirMapa(HashMap<String, Double> mapa) {
        for (Map.Entry<String, Double> entry : mapa.entrySet()) {
            System.out.println("Producto: " + entry.getKey() + " Precio: " + entry.getValue());
        }
    }

    public void menuProducto(HashMap<String, Double> mapa) {
        int opcion = 0;

        do {
            try {

                System.out.println("--------------------- MENU ---------------------");
                System.out.println("Indique la opcion con el numero que corresponda");
                System.out.println("1 - Llenar lista");
                System.out.println("2 - Modificar precio");
                System.out.println("3 - Eliminar producto");
                System.out.println("4 - Mostrar productos por precio");
                System.out.println("5 - Mostrar todos los productos");
                System.out.println("6 - Salir");
                System.out.println("--------------------- MENU ---------------------");

                opcion = leer.nextInt();
            } catch (InputMismatchException e) {
                leer.next();
            }
            switch (opcion) {
                case 1:
                    agregarProductoMapa(mapa);
                    break;
                case 2:
                    modificarPrecio(mapa);
                    break;
                case 3:
                    eliminarProducto(mapa);
                    break;
                case 4:
                    imprimirMapaPrecio(mapa);
                    break;
                case 5:
                    imprimirMapa(mapa);
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("No es una opcion valida");
                    break;
            }

        } while (opcion != 6);

        System.out.println("Gracias por usar nuestros servicios");

    }

}
