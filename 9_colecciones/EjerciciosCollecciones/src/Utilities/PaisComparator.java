/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;


import Entity.Pais;
import java.util.Comparator;

/**
 *
 * @author A309436
 */
public class PaisComparator {
    public static Comparator<Pais> compararPais = (Pais p1, Pais p2) -> p1.getNombre().compareTo(p2.getNombre());
}
