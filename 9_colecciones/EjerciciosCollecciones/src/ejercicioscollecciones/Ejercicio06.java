


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioscollecciones;

import Services.ProductoService;
import java.util.HashMap;

/**
 *
 * @author A309436
 */
public class Ejercicio06 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ProductoService ps = new ProductoService();
        HashMap<String, Double> mapa = new HashMap();
        ps.menuProducto(mapa);
    
    }
    
}
