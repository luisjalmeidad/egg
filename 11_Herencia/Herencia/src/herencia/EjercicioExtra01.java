/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package herencia;

import Entity.Alquiler;
import Entity.Barco;
import Entity.BarcoMotor;
import Entity.Velero;
import Entity.Yate;
import Services.AlquilerService;
import java.util.ArrayList;

/**
 *
 * @author Luis Almeida
 */
public class EjercicioExtra01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //1. En un puerto se alquilan amarres para barcos de distinto tipo. Para cada Alquiler se guarda: el
        //nombre, documento del cliente, la fecha de alquiler, fecha de devolución, la posición del
        //amarre y el barco que lo ocupará.
        //Un Barco se caracteriza por: su matrícula, su eslora en metros y año de fabricación.
        //Sin embargo, se pretende diferenciar la información de algunos tipos de barcos especiales:
        //• Número de mástiles para veleros.
        //• Potencia en CV para barcos a motor.
        //• Potencia en CV y número de camarotes para yates de lujo.
        //Un alquiler se calcula multiplicando el número de días de ocupación (calculado con la fecha de
        //alquiler y devolución), por un valor módulo de cada barco (obtenido simplemente
        //multiplicando por 10 los metros de eslora).

        //En los barcos de tipo especial el módulo de cada barco se calcula sacando el módulo normal y
        //sumándole el atributo particular de cada barco. En los veleros se suma el número de mástiles,
        //en los barcos a motor se le suma la potencia en CV y en los yates se suma la potencia en CV y
        //el número de camarotes.
        //Utilizando la herencia de forma apropiada, deberemos programar en Java, las clases y los
        //métodos necesarios que permitan al usuario elegir el barco que quiera alquilar y mostrarle el
        //precio final de su alquiler.
        AlquilerService as = new AlquilerService();
        ArrayList<Barco> barcos = new ArrayList();

        barcos.add(new Barco("GGH48FHF", 2.4, 2022));
        barcos.add(new Velero(10, "FAS8FHF", 2.4, 2022));
        barcos.add(new BarcoMotor(2356.80, "WQRTFX45", 2.4, 2022));
        barcos.add(new Yate(6, 3956.80, "PCMC56", 2.4, 2022));

        Alquiler a = as.crearAlquiler(barcos);

        System.out.println(a.toString());
        System.out.println("Precio: " + as.calcularAlquiler(a));
        
    }

}
