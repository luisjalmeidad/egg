/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Triangulo;
import java.util.Scanner;

/**
 *
 * @author A309436
 */
public class TrianguloService {

    Scanner leer = new Scanner(System.in);

    public Triangulo crearTriangulo() {
        Triangulo tr = new Triangulo();

        System.out.println("Indique la base del triangulo");
        tr.setBase(leer.nextDouble());
        System.out.println("Indique la altura del triangulo");
        tr.setLados(leer.nextDouble());

        return tr;
    }

    public double calcularPerimetro(Triangulo tr) {
        return 2 * tr.getLados() + tr.getBase();
    }

    public double calcularArea(Triangulo tr) {
        return (tr.getBase() * Math.sqrt(Math.pow(tr.getLados(), 2) - (Math.pow(tr.getBase(), 2) / 4))) / 2;
    }
}
