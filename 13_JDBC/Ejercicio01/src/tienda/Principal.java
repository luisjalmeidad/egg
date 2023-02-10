/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tienda;

import static java.lang.Character.toLowerCase;
import java.util.Scanner;
import tienda.services.ProductoService;

/**
 *
 * @author A309436
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Scanner leer = new Scanner(System.in);
        char op;
        ProductoService ps = new ProductoService();

        System.out.println("---------------------------- MENU ----------------------------");
        System.out.println("a) Lista el nombre de todos los productos que hay en la tabla producto.");
        System.out.println("b) Lista los nombres y los precios de todos los productos de la tabla producto.");
        System.out.println("c) Listar aquellos productos que su precio esté entre 120 y 202.");
        System.out.println("d) Buscar y listar todos los Portátiles de la tabla producto.");
        System.out.println("e) Listar el nombre y el precio del producto más barato.");
        System.out.println("f) Ingresar un producto a la base de datos.");
        System.out.println("g) Ingresar un fabricante a la base de datos");
        System.out.println("h) Editar un producto con datos a elección.");
        System.out.println("---------------------------- MENU ----------------------------");
        op = toLowerCase(leer.nextLine().charAt(0));

        switch (op) {
            case 'a':
                ps.imprimirNombreProductos();
                break;
            case 'b':
                ps.imprimirNombrePrecioProductos();
                break;
            case 'c':
                ps.imprimirProductosPorRangoPrecio();
                break;
            case 'd':
                ps.imprimirProductosPortatiles();
                break;
            case 'e':
                ps.imprimirProductoPrecioMin();
                break;
            case 'f':
                
                break;
            case 'g':
                
                break;
            case 'h':
                
                break;
            default:
                throw new AssertionError();
        }
    }

}
