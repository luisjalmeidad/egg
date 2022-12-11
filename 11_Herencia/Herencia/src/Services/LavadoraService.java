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
        Lavadora lavadora = new Lavadora();
        lavadora.setColor(e.getColor());
        lavadora.setConsumoEnergetico(e.getConsumoEnergetico());
        lavadora.setPeso(e.getPeso());
        lavadora.setPrecio(e.getPrecio());
        System.out.println("Ingrese la capacidad de carga en litros");
        lavadora.setCarga(leer.nextDouble());
        
        return lavadora;
    }
}
