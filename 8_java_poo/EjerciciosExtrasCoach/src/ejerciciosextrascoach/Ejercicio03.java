/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosextrascoach;

import Entity.Pass;
import Service.PassService;
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
        //Crear una clase Pass, donde declaremos los siguientes atributos:
        //● pass : Del tipo String
        //● nombre: Del tipo String
        //● dni: Del tipo int.
        //Métodos para desarrollar:
        //● Ingresar datos de usuarios (usando el constructor. HACER INGRESO DE DATOS FIJOS (no por
        //teclado)
        //● Crear un método para ingresar una contraseña (crearPass). En este método, debemos
        //validar que la longitud sea correcta. (10). En caso de ser correcto, almaceno la contraseña.
        //Si ingreso a esta opción del menú, indefectiblemente deberá dejar su contraseña asignada.
        //● Crear un método para analizar la contraseña(analizarPass). Donde:
        //o SI Existe al menos una letra z : Es nivel MEDIO
        //o Si Existe al menos una letra z y al menos 2 letras a: Es nivel ALTO
        //o Si ninguna condición se cumple es nivel BAJO
        //● Crear los métodos correspondientes para modificar el nombre o DNI. Atención! Primero
        //debe ingresar el pass para poder realizar dicha gestión. Caso contrario se impedirá el
        //acceso a modificar los datos.
        //● A través de un menú de opciones:
        //o A) ingresar la contraseña, recordar que antes de guardarla debe ser ingresada una
        //contraseña valida).
        //o B) Mensaje al usuario que tipo de NIVEL es su contraseña
        //o C) Modificar contraseña, donde primero debe poner su contraseña anterior para
        //dar permiso
        //o C) Modificar nombre, donde primero debe poner su contraseña para dar permiso,
        //SINO impedir cambios
        //o D) Modificar DNI, donde primero debe poner su contraseña para dar permiso,
        //SINO impedir cambios
        Scanner leer = new Scanner(System.in);
        PassService ps = new PassService();
        Pass pas = ps.crearUsuario();
        int opcion = 0;

        System.out.println("Seleccione alguna opción con el número correspondiente");
        do {
            System.out.println("");
            System.out.println("----------------- MENU ------------------");
            System.out.println("| 1 -> Ingresar contraseña              |");
            System.out.println("| 2 -> Mostrar nivel de la contraseña   |");
            System.out.println("| 3 -> Modificar contraseña             |");
            System.out.println("| 4 -> Modificar nombre                 |");
            System.out.println("| 5 -> Modificar dni                    |");
            System.out.println("| 6 -> Salir                            |");
            System.out.println("-----------------------------------------");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    ps.crearPass(pas);
                    break;
                case 2:
                    System.out.println("Su contraseña es de nivel " + ps.analizarPass(pas));
                    break;
                case 3:
                    System.out.println("Ingrese su contraseña anterior");
                    if (pas.getPass().equalsIgnoreCase(leer.next())) {
                        ps.crearPass(pas);                        
                    }else{
                        System.out.println("Contraseña incorrecta");
                    }
                    break;
                case 4:
                    ps.modificarNombre(pas);
                    break;
                case 5:
                    ps.modificarDni(pas);
                    break;
                case 6:
                    System.out.println("¡Gracias por operar con nosotros!");
                default:
                    System.out.println("ERROR: \"" + opcion + "\" no es una opcion permitida.");
            }

        } while (opcion != 6);

    }

}
