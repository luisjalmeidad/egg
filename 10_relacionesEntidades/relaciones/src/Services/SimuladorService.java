/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Entity.Alumno;
import java.util.ArrayList;

/**
 *
 * @author A309436
 */
public class SimuladorService {
    //La clase Simulador debe tener un método que genere un listado de alumnos manera
    //aleatoria y lo retorne. Las combinaciones de nombre y apellido deben ser generadas de
    //manera aleatoria. Nota: usar listas de tipo String para generar los nombres y los apellidos.
    
    public Alumno crearAlumno(){
        String nombres[] = {"Luis", "Jose", "Hernan", "Andres", "Carlos", "Daniel", "Antonio", "Pablo", "Juan"};
        String apellidos[] = {"Almeida", "Garcia", "Hernandez", "Contreras", "Herrera", "Colmenares", "Rodriguez", "Lopez"};       
        
        int posicionNombre = (int) (Math.random() * nombres.length);
        int posicionApellido = (int) (Math.random() * apellidos.length);
        int numDni = (int) ((Math.random() * 89000000)) + 10000000;
        String dni = String.valueOf(numDni);
        String nombreCompleto = nombres[posicionNombre] + " " + apellidos[posicionApellido]; 
        
        return new Alumno(nombreCompleto, dni, 0);
    }
    
    public void crearListaAlumno(ArrayList<Alumno> lista){
        
    }
    
    
    
}
