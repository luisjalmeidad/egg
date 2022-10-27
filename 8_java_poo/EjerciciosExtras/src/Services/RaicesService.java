/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entity.Raices;
import java.util.Scanner;

/**
 *
 * @author A309436
 */
public class RaicesService {

    Scanner leer = new Scanner(System.in);

    public Raices crearRaiz() {

        double a;
        double b;
        double c;

        System.out.println("Ingrese el valor A");
        a = leer.nextDouble();
        System.out.println("Ingrese el valor B");
        b = leer.nextDouble();
        System.out.println("Ingrese el valor C");
        c = leer.nextDouble();

        Raices raiz = new Raices(a, b, c);

        return raiz;
    }

    public double getDiscriminante(Raices raiz) {
        //Método getDiscriminante(): devuelve el valor del discriminante (double). El
        //discriminante tiene la siguiente formula: (b^2)-4*a*c

        return Math.pow(raiz.getB(), 2) - 4 * raiz.getA() * raiz.getC();
    }

    public double calcularEcuacion(Raices raiz, String signo) {

        if (signo.equals("+")) {
            return -raiz.getB() + Math.sqrt(getDiscriminante(raiz) / (2 * raiz.getA()));
        }

        return -raiz.getB() - Math.sqrt(getDiscriminante(raiz) / (2 * raiz.getA()));
    }

    public boolean tieneRaices(Raices raiz) {
        //Método tieneRaices(): devuelve un booleano indicando si tiene dos soluciones, para
        //que esto ocurra, el discriminante debe ser mayor que 0.

        if (getDiscriminante(raiz) > 0) {
            return true;
        }

        return false;
    }

    public boolean tieneRaiz(Raices raiz) {
        //Método tieneRaiz(): devuelve un booleano indicando si tiene una única solución, para
        //que esto ocurra, el discriminante debe ser igual que 0.
        if (getDiscriminante(raiz) == 0) {
            return true;
        }

        return false;
    }

    public void obtenerRaices(Raices raiz) {
        //Método obtenerRaices(): llama a tieneRaíces() y si devolvió́ true, imprime las 2 posibles
        //soluciones.
        if (tieneRaices(raiz)) {
            System.out.println("Tiene dos soluciones");
            System.out.println("La solucion al sumar es: " + calcularEcuacion(raiz, "+"));
            System.out.println("La solucion al restar es: " + calcularEcuacion(raiz, "-"));
        }
    }

    public void obtenerRaiz(Raices raiz) {
        //Método obtenerRaiz(): llama a tieneRaiz() y si devolvió́ true imprime una única raíz. Es
        //en el caso en que se tenga una única solución posible.
        if (tieneRaiz(raiz)) {
            System.out.println("Tiene una solución");
            System.out.println("La solucion es: " + calcularEcuacion(raiz, "+"));
        }
    }

    public void calcular(Raices raiz) {
        //Método calcular(): esté método llamará tieneRaices() y a tieneRaíz(), y mostrará por
        //pantalla las posibles soluciones que tiene nuestra ecuación con los métodos
        //obtenerRaices() o obtenerRaiz(), según lo que devuelvan nuestros métodos y en caso
        //de no existir solución, se mostrará un mensaje.

        if (tieneRaiz(raiz)) {
            obtenerRaiz(raiz);
        } else if (tieneRaices(raiz)) {
            obtenerRaices(raiz);
        } else {
            System.out.println("El resultado del discriminante es " + getDiscriminante(raiz) + " por ello, no tiene solución.");
        }

    }

}
