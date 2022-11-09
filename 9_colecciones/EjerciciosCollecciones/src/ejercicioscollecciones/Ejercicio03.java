/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioscollecciones;

import Entity.Alumno;
import Services.AlumnoService;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author A309436
 */
public class Ejercicio03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        AlumnoService as = new AlumnoService();
        ArrayList<Alumno> listaAlumno = new ArrayList();
        String alumno;
        as.llenarListaAlumnos(listaAlumno);

        System.out.println("¿A que alumno desea calcularle la nota final?");
        alumno = leer.next();
        if (as.existeAlumno(listaAlumno, alumno)) {
            as.notaFinal(listaAlumno, alumno);
        }

    }

}
