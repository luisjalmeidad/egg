/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Fecha;
import java.util.Scanner;

/**
 *
 * @author A309436
 */
public class FechaService {

    Scanner leer = new Scanner(System.in);

    public boolean esBisiesto(int anio) {

        if (anio % 4 == 0) {
            return true;
        }

        return false;
    }

    public int diasMes(int mes, int anio) {
        int dia = 0;

        switch (mes) {
            case 1:
                dia = 31;
                break;
            case 2:
                if (esBisiesto(anio)) {
                    dia = 29;
                } else {
                    dia = 28;
                }
                break;
            case 3:
                dia = 31;
                break;
            case 4:
                dia = 30;
                break;
            case 5:
                dia = 31;
                break;
            case 6:
                dia = 30;
                break;
            case 7:
                dia = 31;
                break;
            case 8:
                dia = 31;
                break;
            case 9:
                dia = 30;
                break;
            case 10:
                dia = 31;
                break;
            case 11:
                dia = 30;
                break;
            case 12:
                dia = 31;
                break;
            case 0:
                dia = 31;
                break;
            default:
                System.out.println("ERROR: \"" + mes + "\" no es un mes valido");
                throw new AssertionError();
        }

        return dia;
    }

    public Fecha ingresarFecha() {
        Fecha fecha = new Fecha();
        System.out.println("Ingrese una fecha valida");
        int anio = 0;
        int mes = 0;
        int dia = 0;
        // Maximo día del mes
        int maxDia = 0;

        do {
            System.out.println("Ingrese el año");
            System.out.println("Mensaje: El año debe estar entre 1900 y 2021 inclusive");
            anio = leer.nextInt();

            if (anio >= 1900 && anio <= 2021) {
                fecha.setAnio(anio);
                System.out.println("Mensaje: Año guardado con éxito");
            } else {
                System.out.println("Mensaje: No es un año permitido.");
            }
        } while (anio < 1900 || anio > 2021);

        do {
            System.out.println("Ingrese el mes");
            mes = leer.nextInt();
            if (mes >= 1 && mes <= 12) {
                fecha.setMes(mes);
                System.out.println("Mensaje: Mes guardado con éxito");
            } else {
                System.out.println("Mensaje: No es un mes permitido.");
            }
        } while (mes < 1 || mes > 12);

        maxDia = diasMes(mes, anio);

        do {
            System.out.println("ingrese el dia");
            dia = leer.nextInt();

            if (dia >= 1 && dia <= maxDia) {
                fecha.setDia(dia);
                System.out.println("Mensaje: Día guardado con éxito");

            } else {
                System.out.println("Mensaje: No es un día permitido.");
            }
        } while (dia < 1 || dia > maxDia);
        
        return fecha;

    }

    public void mostrarDiaAnterior(Fecha fecha) {
        //Maximo dia del mes anterior
        int maxDiaAnt = diasMes(fecha.getMes() - 1, fecha.getAnio());

        if (fecha.getDia() > 1) {
            System.out.println("Fecha del día anterior: " + (fecha.getDia() - 1) + "/" + fecha.getMes() + "/" + fecha.getAnio());
        } else if (fecha.getMes() > 1) {
            System.out.println("Fecha del día anterior: " + maxDiaAnt + "/" + (fecha.getMes() - 1) + "/" + fecha.getAnio());
        } else {
            System.out.println("Fecha del día anterior: " + maxDiaAnt + "/" + 12 + "/" + (fecha.getAnio() - 1));
        }

    }

    public void mostrarDiaPosterior(Fecha fecha) {
        //Maximo dia del mes actual
        int maxDia = diasMes(fecha.getMes(), fecha.getAnio());

        if (fecha.getDia() == maxDia && fecha.getMes() == 12) {
            System.out.println("Fecha del día posterior: " + 1 + "/" + 1 + "/" + (fecha.getAnio() + 1));
        } else if (fecha.getDia() == maxDia) {
            System.out.println("Fecha del día posterior: " + 1 + "/" + (fecha.getMes() + 1) + "/" + fecha.getAnio());
        } else {
            System.out.println("Fecha del día posterior: " + (fecha.getDia() + 1) + "/" + fecha.getMes() + "/" + fecha.getAnio());
        }

    }

}
