/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Auto;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author A309436
 */
public class AutoService {
    
    Scanner leer = new Scanner(System.in);
    
    public Auto crearAuto(){
        Auto a = new Auto();
        int dia;
        int mes;
        int anio;
        
        
        System.out.println("Ingrese el nombre del titular del auto");
        a.setNombre(leer.next());
        
        System.out.println("Ingrese la fecha de vencimiento del carnet");
        System.out.println("Anio");
        anio = leer.nextInt();
        System.out.println("Mes");
        mes = leer.nextInt();
        System.out.println("Dia");
        dia = leer.nextInt();
        
        Date fecha = new Date(anio-1900, mes-1, dia);
        a.setFechaVencimiento(fecha);
        
        System.out.println("Indique el color del auto");
        a.setColor(leer.next());
        
        System.out.println("Ingrese el modelo del auto");
        a.setModelo(leer.next());
        
        return a;
        
    }
    
    public void modificarTitular(Auto a){
        System.out.println("Indique el nombre del nuevo titular");
        a.setNombre(leer.next());
    }
    
    public void actualizarRecorrido(Auto a){
        System.out.println("Indique la cantidad de KM recorridos");
        a.setKm(a.getKm() + leer.nextInt());        
    }
    
    public void alertaService(Auto a){
        if (a.getKm() >= 10000) {
            System.out.println("Es necesario realizar Service al auto");
        }else{
            System.out.println("Puede seguir conduciendo sin problemas");
        }
    }
    
}
