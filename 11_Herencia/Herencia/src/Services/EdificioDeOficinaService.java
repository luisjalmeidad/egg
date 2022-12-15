/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Entity.EdificioDeOficinas;
import java.util.Scanner;

/**
 *
 * @author A309436
 */
public class EdificioDeOficinaService {
    Scanner leer = new Scanner(System.in);
//De esta clase nos interesa saber cuántas personas pueden trabajar en todo el edificio, el
//usuario dirá cuántas personas entran en cada oficina, cuantas oficinas y el número de piso
//(suponiendo que en cada piso hay una oficina). Crear el método cantPersonas(), que muestre
//cuantas personas entrarían en un piso y cuantas en todo el edificio.
    public EdificioDeOficinas crearEdificioDeOficinas(){
        double ancho = Math.round(((Math.random() * 9) + 5) *100)/100;
        double alto = Math.round(((Math.random() * 30) + 100) *100)/100;
        double largo = ancho;
        
        System.out.println("Indique las personas por oficina");
        int cantPersonas = leer.nextInt();
        
        System.out.println("Indique la cantidad de oficinas");
        int numOficinas = leer.nextInt();
        
        System.out.println("Ingrese la cantidad de pisos que tiene el edificio");
        int numPisos = leer.nextInt();
        
        return new EdificioDeOficinas (numOficinas, cantPersonas, numPisos, ancho, alto, largo);
    }
    
    public void cantPersonas(EdificioDeOficinas e){
        double personasPorPiso = (e.getNumOficinas() * e.getCantPersonas());
        double totalPersonas = e.getNumPisos() * personasPorPiso;       
        
        System.out.println("Cantidad de personas por piso: " + personasPorPiso);
        System.out.println("Cantidad de personas en el edificio: " + totalPersonas);
    }       
    
}
