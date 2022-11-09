/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entity.Pais;
import static Utilities.PaisComparator.compararPais;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author A309436
 */
public class PaisService {

    Scanner leer = new Scanner(System.in);

    public Pais crearPais() {
        Pais p = new Pais();

        System.out.println("Indique el nombre del pais");
        p.setNombre(leer.next());

        return p;
    }

    public void agregarPaisLista(HashSet<Pais> lista) {
        String respuesta = "S";

        do {
            lista.add(crearPais());
            System.out.println("¿Desea agregar otro pais? S/N");
            respuesta = leer.next();
        } while (respuesta.equalsIgnoreCase("S"));

    }

    public void ordenarListaPaises(HashSet<Pais> lista) {
        ArrayList<Pais> listaPaises = new ArrayList(lista);
        listaPaises.sort(compararPais);
        System.out.println("Imprimo el conjunto ordenado");
        imprimirListaPaises(listaPaises);
    }

    public void borrarPaisLista(HashSet<Pais> lista) {
        boolean bandera = false;
        System.out.println("¿Que pais desea borrar?");
        String pais = leer.next();
        
        Iterator<Pais> it = lista.iterator();
        while (it.hasNext()) {
            if (it.next().getNombre().equals(pais)) {
                bandera = true;
                it.remove();
            }
        }
        
        if (bandera) {
            System.out.println("El pais " + pais + " ha sido eliminado.");
        }else{
            System.out.println("No se encuentra el pais " + pais + " en la lista");
        }
            
    }

    public void imprimirListaPaises(HashSet<Pais> lista) {
        for (Pais pais : lista) {
            System.out.println(pais.toString());
        }

    }

    public void imprimirListaPaises(ArrayList<Pais> lista) {
        for (Pais pais : lista) {
            System.out.println(pais.toString());
        }

    }

}
