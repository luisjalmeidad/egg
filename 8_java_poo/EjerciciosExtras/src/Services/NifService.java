/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entity.Nif;
import java.util.Scanner;

/**
 *
 * @author A309436
 */
public class NifService {
    
    Scanner leer = new Scanner(System.in);
    
    public Nif crearNif(){
        Nif nif = new Nif();
        
        System.out.println("Ingrese su DNI");
        nif.setDni(leer.nextInt());
        
        nif.setLetra(calcularLetra(nif));
        
        return nif;
    }
    
    public void mostrar(Nif nif){
        
        System.out.println("El nif es: " + nif.getDni() + "-" + nif.getLetra());
        
    }
    
    public String calcularLetra(Nif nif){
        
        String letra[] = {"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};        
        int resto = (int) nif.getDni() % 23;        
        return letra[resto];
    }
    
}
