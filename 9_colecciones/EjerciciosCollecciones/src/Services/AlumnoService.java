/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entity.Alumno;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author A309436
 */
public class AlumnoService {

    Scanner leer = new Scanner(System.in);

    public Alumno crearAlumno() {
        Alumno a = new Alumno();
        ArrayList<Integer> notas = new ArrayList();

        System.out.println("Ingrese el nombre del alumno");
        a.setNombre(leer.next());

        System.out.println("Ingrese la nota 1");
        notas.add(leer.nextInt());
        System.out.println("Ingrese la nota 2");
        notas.add(leer.nextInt());
        System.out.println("Ingrese la nota 3");
        notas.add(leer.nextInt());

        a.setNotas(notas);

        return a;
    }

    public void llenarListaAlumnos(ArrayList<Alumno> lista) {
        String respuesta = "S";

        do {
            lista.add(crearAlumno());
            System.out.println("¿Desea agregar otro alumno?");
            respuesta = leer.next();
        } while (respuesta.equalsIgnoreCase("S"));
    }

    public boolean existeAlumno(ArrayList<Alumno> lista, String alumno) {
        Iterator<Alumno> it = lista.iterator();

        while (it.hasNext()) {
            if (it.next().getNombre().equalsIgnoreCase(alumno)) {
                return true;
            }

        }
        System.out.println("El alumno " + alumno + " no existe en la lista");
        return false;
    }

    public void notaFinal(ArrayList<Alumno> lista, String alumno) {

        Integer notaTotal = 0;

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getNombre().equalsIgnoreCase(alumno)) {
                for (int j = 0; j < lista.get(i).getNotas().size(); j++) {
                    notaTotal += lista.get(i).getNotas().get(j);
                }

            }

        }

        System.out.println("La nota final de " + alumno + " es: " + notaTotal.doubleValue() / 3);

    }

}
