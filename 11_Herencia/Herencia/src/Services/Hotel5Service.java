/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Entity.Hotel5;

/**
 *
 * @author A309436
 */
public class Hotel5Service extends Hotel4Service {

    
    public void calcularPrecioHabitacion(Hotel5 h) {
        super.calcularPrecioHabitacion(h);
        
        double precio = (double) (15 * h.getCantLimosinas());
        
        h.setPrecioHabitacion(h.getPrecioHabitacion() + precio);
    }
    
}
