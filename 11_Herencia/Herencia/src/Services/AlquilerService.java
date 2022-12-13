/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Entity.Alquiler;
import Entity.Barco;
import Entity.BarcoMotor;
import Entity.Velero;
import Entity.Yate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Luis Almeida
 */
public class AlquilerService {
    //Un alquiler se calcula multiplicando el número de días de ocupación (calculado con la fecha de
    //alquiler y devolución), por un valor módulo de cada barco (obtenido simplemente
    //multiplicando por 10 los metros de eslora).

    Scanner leer = new Scanner(System.in);

    public Alquiler crearAlquiler(ArrayList<Barco> barcos) {
        Date fechaLiq = new Date();

        System.out.println("Ingrese su nombre");
        String nombre = leer.nextLine();
        System.out.println("Ingrese su documento");
        String documento = leer.nextLine();
        System.out.println("Indique la cantidad de dias que desea alquilar el barco");
        int dia = leer.nextInt();
        long mili = (fechaLiq.getTime() + (dia * 86400000));
        Date fechaDev = new Date(mili);
        System.out.println("Selecciona el barco que desea alquilar");
        for (int i = 0; i < barcos.size(); i++) {
            System.out.println(i + ")" + " " + barcos.get(i).toString());
        }
        int opcion = leer.nextInt();
        Barco barco = barcos.get(opcion);

        return new Alquiler(nombre, documento, fechaLiq, fechaDev, barco);
    }

    public double calcularAlquiler(Alquiler a) {
        double dias = (double) Math.abs(Math.round((a.getFechaDev().getTime() - a.getFechaLiq().getTime()) / 86400000));
        double precio = dias * (10 * a.getBarco().getEslora());

        if (a.getBarco() instanceof Velero) {
            Velero object = (Velero) a.getBarco();
            precio = dias * ((10 * a.getBarco().getEslora()) + (double) object.getNumMastiles());
        }

        if (a.getBarco() instanceof BarcoMotor) {
            BarcoMotor object = (BarcoMotor) a.getBarco();
            precio = dias * ((10 * a.getBarco().getEslora()) + object.getPotencia());
        }

        if (a.getBarco() instanceof Yate) {
            Yate object = (Yate) a.getBarco();
            precio = dias * ((10 * a.getBarco().getEslora()) + object.getPotencia() + (double) object.getNumCamarotes());
        }

        return precio;

    }
}
