/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entity.Mes;
import java.util.Scanner;

/**
 *
 * @author A309436
 */
public class MesService {

    Scanner leer = new Scanner(System.in);

    public void AdivinarMes() {
        Mes mes = new Mes();
        boolean bandera = true;

        do {
            System.out.println("Adivina el mes secreto");
            if (mes.getMesSecreto().equalsIgnoreCase(leer.nextLine())) {
                System.out.println("¡Acertaste!");
                bandera = false;
            } else {
                System.out.println("No es el mes secreto, vuelve a intentarlo");
            }
        } while (bandera);

    }

}
