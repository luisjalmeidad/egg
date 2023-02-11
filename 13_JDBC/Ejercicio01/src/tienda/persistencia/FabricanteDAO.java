/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda.persistencia;

import java.util.ArrayList;
import tienda.entities.Fabricante;

/**
 *
 * @author A309436
 */
public class FabricanteDao extends DAO {

    public void insertFabricante(Fabricante fabricante) throws Exception {
        try {
            if (fabricante == null) {
                throw new Exception("Debe indicar el fabricante");
            }
            String sql = "INSERT INTO fabricante (codigo, nombre) "
                    + "VALUES ( "
                    + fabricante.getCodigo() + " , '"
                    + fabricante.getNombre()
                    + "');";

            System.out.println(sql);
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
    
    public ArrayList<Fabricante> selectFabricantes() throws Exception {
        try {
            String sql = "SELECT * FROM Fabricante ";
            consultarBase(sql);

            Fabricante fabricante;

            ArrayList<Fabricante> fabricantes = new ArrayList();
            while (resultado.next()) {
                fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getLong(1));
                fabricante.setNombre(resultado.getString(2));              
                fabricantes.add(fabricante);
            }
            desconectarBase();
            return fabricantes;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error al obtener fabricantes");
        }
    }
}
