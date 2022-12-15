/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Entity.Hotel;

/**
 *
 * @author A309436
 */
public class HotelService {
    
    public void calcularPrecioHabitacion(Hotel h){
//El precio de una habitación debe calcularse de acuerdo con la siguiente fórmula: 
//PrecioHabitación = $50 + ($1 x capacidad del hotel) + (valor agregado por restaurante) + (valor 
//agregado por gimnasio) + (valor agregado por limosinas).
        
        h.setPrecioHabitacion( (double) 50 + h.getNumCamas());

    }
}
