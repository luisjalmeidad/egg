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
public class Sopa {
    private String sopa[][];
    private String palabraEcontrar;

    public Sopa() {
    }

    public Sopa(String[][] sopa, String palabraEcontrar) {
        this.sopa = sopa;
        this.palabraEcontrar = palabraEcontrar;
    }

    public String[][] getSopa() {
        return sopa;
    }

    public void setSopa(String[][] sopa) {
        this.sopa = sopa;
    }

    public String getPalabraEcontrar() {
        return palabraEcontrar;
    }

    public void setPalabraEcontrar(String palabraEcontrar) {
        this.palabraEcontrar = palabraEcontrar;
    }
}
