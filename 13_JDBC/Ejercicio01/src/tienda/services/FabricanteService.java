/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda.services;

import java.util.ArrayList;
import tienda.entities.Fabricante;
import tienda.persistencia.FabricanteDao;

/**
 *
 * @author A309436
 */
public class FabricanteService {

    private FabricanteDao dao;

    public FabricanteService() {
        this.dao = new FabricanteDao();
    }
    
    public void imprimirFabricantes() throws Exception{
        ArrayList<Fabricante> fabricantes = dao.selectFabricantes();
        
        System.out.println("Codigo - Fabricante");
        
        for (Fabricante fabricante : fabricantes) {
            System.out.println(fabricante.getCodigo() + " - " + fabricante.getNombre());            
        }
        
        
    }
}
