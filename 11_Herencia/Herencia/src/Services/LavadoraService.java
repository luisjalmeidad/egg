/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Entity.Electrodomestico;
import Entity.Lavadora;
import java.util.Scanner;

/**
 *
 * @author A309436
 */
public class LavadoraService extends ElectrodomesticoService {

//• Método crearLavadora (): este método llama a crearElectrodomestico() de la clase
//padre, lo utilizamos para llenar los atributos heredados del padre y después llenamos
//el atributo propio de la lavadora.
    public Lavadora crearLavadora() {
        Scanner leer = new Scanner(System.in);
        Electrodomestico e = super.crearElectrodomestico();

        System.out.println("Ingrese la capacidad de carga en litros");
        double carga = leer.nextDouble();

        return new Lavadora(e.getPrecio(), e.getColor(), e.getConsumoEnergetico(), e.getPeso(), carga);
    }

    public void precioFinal(Lavadora lav) {
        super.precioFinal(lav);
        if (lav.getCarga() > 30) {
            lav.setPrecio(lav.getPrecio() + 500);
        }
    }

}
