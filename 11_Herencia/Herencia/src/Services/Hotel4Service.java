/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Entity.Hotel4;

/**
 *
 * @author A309436
 */
public class Hotel4Service extends HotelService {

    public void calcularPrecioHabitacion(Hotel4 h) {
//El precio de una habitación debe calcularse de acuerdo con la siguiente fórmula: 
//PrecioHabitación = $50 + ($1 x capacidad del hotel) + (valor agregado por restaurante) + (valor 
//agregado por gimnasio) + (valor agregado por limosinas).
        super.calcularPrecioHabitacion(h);
        double precio;
        if (h.getCapacidadRest() < 30) {
            precio = 10;
        } else if (h.getCapacidadRest() < 50) {
            precio = 30;
        } else {
            precio = 50;
        }

        if (h.getGimnasio() == 'A') {
            precio += 50;
        }
        
        if (h.getGimnasio() == 'B') {
            precio += 30;
        }        
        
        h.setPrecioHabitacion(h.getPrecioHabitacion() + precio);

    }

}
