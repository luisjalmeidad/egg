/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioscollecciones;

import Entity.Perro;
import Services.PerroService;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author A309436
 */
public class Ejercicio01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        ArrayList<Perro> razaPerro = new ArrayList();
        PerroService ps = new PerroService();
        
        ps.llenarLista(razaPerro);
        ps.imprimirLista(razaPerro);
        ps.eliminarPerro(razaPerro);

    }

}
