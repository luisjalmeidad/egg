/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Pass;
import java.util.Scanner;

/**
 *
 * @author A309436
 */
public class PassService {

    Scanner leer = new Scanner(System.in);

    public Pass crearUsuario() {
        Pass usuario = new Pass("Luis", 95895);

        return usuario;
    }

    public void crearPass(Pass usuario) {
        String pass;

        do {
            System.out.println("Ingrese la nueva contraseña de 10 caracteres");
            pass = leer.next();
            if (pass.length() == 10) {
                usuario.setPass(pass);
            } else {
                System.out.println("La contraseña debe tener 10 caracteres");
            }

        } while (pass.length() != 10);

    }

    public String analizarPass(Pass usuario) {
        int contZ = 0;
        int contA = 0;
        String letra = "";

        for (int i = 0; i < usuario.getPass().length(); i++) {

            letra = usuario.getPass().substring(i, i + 1);

            if (letra.equalsIgnoreCase("a")) {
                contA++;
            }

            if (letra.equalsIgnoreCase("z")) {
                contZ++;
            }
        }

        if (contZ > 0 && contA > 1) {
            return "ALTO";
        }

        if (contZ > 0) {
            return "MEDIO";
        }

        return "BAJO";
    }

    public void modificarNombre(Pass usuario) {

        System.out.println("Ingrese la contraseña para continuar");
        if (usuario.getPass().equalsIgnoreCase(leer.next())) {
            System.out.println("Contraseña correcta");
            System.out.println("Ingrese el nuevo nombre");
            usuario.setNombre(leer.next());
        } else {
            System.out.println("Contraseña incorrecta");
        }
    }

    public void modificarDni(Pass usuario) {

        System.out.println("Ingrese la contraseña para continuar");
        if (usuario.getPass().equalsIgnoreCase(leer.next())) {
            System.out.println("Contraseña correcta");
            System.out.println("Ingrese el nuevo DNI");
            usuario.setDni(leer.nextInt());
        } else {
            System.out.println("Contraseña incorrecta");
        }
    }
}
