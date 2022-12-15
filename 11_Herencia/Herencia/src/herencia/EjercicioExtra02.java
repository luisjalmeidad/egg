/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package herencia;

import Entity.Edificio;
import Entity.EdificioDeOficinas;
import Entity.Polideportivo;
import Services.EdificioDeOficinaService;
import Services.PolideportivoService;
import java.util.ArrayList;

/**
 *
 * @author A309436
 */
public class EjercicioExtra02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Crear una superclase llamada Edificio con los siguientes atributos: ancho, alto y largo. La clase
        //edificio tendrá como métodos:
        //• Método calcularSuperficie(): calcula la superficie del edificio.
        //• Método calcularVolumen(): calcula el volumen del edifico.
        //Estos métodos serán abstractos y los implementarán las siguientes clases:
        //• Clase Polideportivo con su nombre y tipo de instalación que puede ser Techado o
        //Abierto, esta clase implementará los dos métodos abstractos y los atributos del padre.
        //• Clase EdificioDeOficinas con sus atributos número de oficinas, cantidad de personas
        //por oficina y número de pisos. Esta clase implementará los dos métodos abstractos y
        //los atributos del padre.

        //De esta clase nos interesa saber cuántas personas pueden trabajar en todo el edificio, el
        //usuario dirá cuántas personas entran en cada oficina, cuantas oficinas y el número de piso
        //(suponiendo que en cada piso hay una oficina). Crear el método cantPersonas(), que muestre
        //cuantas personas entrarían en un piso y cuantas en todo el edificio.
        //Por último, en el main vamos a crear un ArrayList de tipo Edificio. El ArrayList debe contener
        //dos polideportivos y dos edificios de oficinas. Luego, recorrer este array y ejecutar los
        //métodos calcularSuperficie y calcularVolumen en cada Edificio. Se deberá mostrar la
        //superficie y el volumen de cada edificio.
        //Además de esto, para la clase Polideportivo nos interesa saber cuántos polideportivos son
        //techados y cuantos abiertos. Y para la clase EdificioDeOficinas deberemos llamar al método
        //cantPersonas() y mostrar los resultados de cada edificio de oficinas.
        ArrayList<Edificio> listaEdificios = new ArrayList();
        PolideportivoService ps = new PolideportivoService();
        EdificioDeOficinaService es = new EdificioDeOficinaService();
        int contadorTechado = 0;
        int contadorabierto = 0;

//        listaEdificios.add(ps.crearPolideportivo());
//        listaEdificios.add(ps.crearPolideportivo());
//        listaEdificios.add(es.crearEdificioDeOficinas());                
        listaEdificios.add(es.crearEdificioDeOficinas());

        for (Edificio listaEdificio : listaEdificios) {
            if (listaEdificio instanceof Polideportivo) {
                Polideportivo p = (Polideportivo) listaEdificio;
                System.out.println(p.toString());
                System.out.println("Superficie: " + p.calcularSuperficie());
                System.out.println("Volumen: " + p.calcularVolumen());
                if (p.getTipoInstalacion().equalsIgnoreCase("Techado")) {
                    contadorTechado += 1;
                }else{
                    contadorabierto += 1;
                }
                
            }

            if (listaEdificio instanceof EdificioDeOficinas) {
                EdificioDeOficinas e = (EdificioDeOficinas) listaEdificio;
                System.out.println(e.toString());
                System.out.println("Superficie: " + e.calcularSuperficie());
                System.out.println("Volumen: " + e.calcularVolumen());
                es.cantPersonas(e);

            }
            
            System.out.println("");
            System.out.println("-----------------------------");
            System.out.println("");

        }

        System.out.println("Polideportivos techados: " + contadorTechado);
        System.out.println("Polideportivos abiertos: " + contadorabierto);   

    }

}
