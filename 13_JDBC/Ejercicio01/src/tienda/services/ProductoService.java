/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda.services;

import java.util.ArrayList;
import tienda.entities.Producto;
import tienda.persistencia.ProductoDao;

/**
 *
 * @author A309436
 */
public class ProductoService {

    private ProductoDao dao;

    public ProductoService() {
        this.dao = new ProductoDao();
    }
    //    a) Lista el nombre de todos los productos que hay en la tabla producto.  

    public void imprimirNombreProductos() throws Exception {

        try {
            Producto producto;
            ArrayList<Producto> productos = dao.selectProductos();
            for (int i = 0; i < productos.size(); i++) {
                producto = productos.get(i);
                System.out.println((i + 1) + " - " + producto.getNombre());
            }

        } catch (Exception e) {
            throw e;
        }
    }

//b) Lista los nombres y los precios de todos los productos de la tabla producto.
    public void imprimirNombrePrecioProductos() throws Exception {

        try {
            Producto producto;
            ArrayList<Producto> productos = dao.selectProductos();
            for (int i = 0; i < productos.size(); i++) {
                producto = productos.get(i);
                System.out.println((i + 1) + " - " + producto.getNombre() + " - " + producto.getPrecio());
            }

        } catch (Exception e) {
            throw e;
        }
    }

//c) Listar aquellos productos que su precio esté entre 120 y 202. 
        public void imprimirProductosPorRangoPrecio() throws Exception {

        try {
            Producto producto;
            ArrayList<Producto> productos = dao.selectProductos();
            for (int i = 0; i < productos.size(); i++) {
                producto = productos.get(i);
                if (producto.getPrecio() >= 120 && producto.getPrecio() <= 202) {
                    System.out.println((i + 1) + " - " + producto.getNombre() + " - " + producto.getPrecio());
                }                
            }

        } catch (Exception e) {
            throw e;
        }
    }
        
//d) Buscar y listar todos los Portátiles de la tabla producto. 
    public void imprimirProductosPortatiles() throws Exception {

        try {
            Producto producto;
            ArrayList<Producto> productos = dao.selectProductosPortatiles();
            for (int i = 0; i < productos.size(); i++) {
                producto = productos.get(i);
                System.out.println((i + 1) + " - " + producto.getNombre());
            }

        } catch (Exception e) {
            throw e;
        }
    }
    
//e) Listar el nombre y el precio del producto más barato.  
    public void imprimirProductoPrecioMin() throws Exception {

        try {
            Producto producto;
            ArrayList<Producto> productos = dao.selectProductos();
            int indice = 0;
            double precio = Double.MAX_VALUE;
            
            for (int i = 0; i < productos.size(); i++) {
                producto = productos.get(i);
                if (producto.getPrecio() < precio) {
                    precio = producto.getPrecio();
                    indice = i;
                }                
            }
            
            producto = productos.get(indice);
            
            System.out.println("1 - " + producto.getNombre() + " - " + producto.getPrecio());
        } catch (Exception e) {
            throw e;
        }
    }   
    
//f) Ingresar un producto a la base de datos.
//g) Ingresar un fabricante a la base de datos
//h) Editar un producto con datos a elección.
}
