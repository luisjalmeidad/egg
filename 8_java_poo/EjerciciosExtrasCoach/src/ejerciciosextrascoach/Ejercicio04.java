/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosextrascoach;

import Entity.Fecha;
import Service.FechaService;

/**
 *
 * @author A309436
 */
public class Ejercicio04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Definir la clase Fecha. La Clase entidad tendrá solo 3 atributos (día, mes, año). No se podrá utilizar
        //ningún tipo de objeto de “clase fechas”. Inicializando desde la entidad los valores en 1, 1, 1900
        //respectivamente.
        //Se deberá en métodos independientes:
        //● Verificar que el año ingresado por el usuario este entre 1900 y 2021, caso contrario, el año
        //tomara el valor por defecto.
        //● Conocer la cantidad de días totales que tiene el mes elegido por el usuario. EJ: USTED
        //INGRESO MES 10 (OCTUBRE), QUE TIENE 31 días
        //● Mostrar día anterior a la fecha ingresada (Hay que considerar que sucede con inicio de
        //cada mes)
        //Profe. Adri Bestilleiro
        //● Mostrar día posterior a la fecha ingresada (Hay que considerar que sucede con fin de cada
        //mes)
        //● Crear un método para verificar si el año ingresado es bisiesto
        
        FechaService fs = new FechaService();
        Fecha fecha = fs.ingresarFecha();
        fs.mostrarDiaAnterior(fecha);
        fs.mostrarDiaPosterior(fecha);
    }

}
