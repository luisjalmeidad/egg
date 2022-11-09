/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioscollecciones;

import Entity.Pais;
import Services.PaisService;
import java.util.HashSet;

/**
 *
 * @author A309436
 */
public class Ejercicio05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PaisService ps = new PaisService();
        HashSet<Pais> lista = new HashSet();
        ps.agregarPaisLista(lista);
        System.out.println("Imprimo el conjunto");
        ps.imprimirListaPaises(lista);
        ps.ordenarListaPaises(lista);
        ps.borrarPaisLista(lista);
        ps.ordenarListaPaises(lista);
        
    }
    
}
