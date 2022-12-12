/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Entity.FormaGeometrica;

/**
 *
 * @author Luis Almeida
 */
public interface calculosFormas {
    
    double PI = 3.14;
    
    double calcularArea(FormaGeometrica fg);
    double calcularPerimetro(FormaGeometrica fg);
}
