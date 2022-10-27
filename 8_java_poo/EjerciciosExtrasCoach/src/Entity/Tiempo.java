/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author A309436
 */
public class Tiempo {

    private String hora;
    private String minuto;
    private String segundo;

    public Tiempo() {
    }

    public Tiempo(String hora, String minuto, String segundo) {
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        int numHora = Integer.parseInt(hora.trim());
        if (numHora >= 0 && numHora < 24) {
            if (hora.trim().length() < 2) {
                hora = "0" + hora;
            }
            this.hora = hora;
        }
    }

    public String getMinuto() {
        return minuto;
    }

    public void setMinuto(String minuto) {
        int numMinuto = Integer.parseInt(minuto.trim());
        if (numMinuto >= 0 && numMinuto < 60) {
            if (minuto.trim().length() < 2) {
                minuto = "0" + minuto;
            }
            this.minuto = minuto;
        }
    }

    public String getSegundo() {
        return segundo;
    }

    public void setSegundo(String segundo) {

        int numSegundo = Integer.parseInt(segundo.trim());
        if (numSegundo >= 0 && numSegundo < 60) {
            if (segundo.trim().length() < 2) {
                segundo = "0" + segundo;
            }
            this.segundo = segundo;
        }

    }

    public void imprimirHoraCompleta() {
        if (hora == null) {
            System.out.println("No ingresaste una hora entre el 0 y las 23 inclusive");
            return;
        }

        if (minuto == null) {
            System.out.println("No ingresaste minutos entre el 0 y el 59 inclusive");
            return;
        }

        if (segundo == null) {
            System.out.println("No ingresaste segundos entre el 0 y el 59 inclusive");
            return;
        }
        System.out.println("Hora: " + hora + ":" + minuto + ":" + segundo);
    }

}
