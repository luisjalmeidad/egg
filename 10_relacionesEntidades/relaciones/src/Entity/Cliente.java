/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author A309436
 */
public class Cliente {
    private String nombre;
    private String Apellido;
    private String documento;
    private String correo;
    private String domicilio;
    private String telefono;

    public Cliente() {
    }

    public Cliente(String nombre, String Apellido, String documento, String correo, String domicilio, String telefono) {
        this.nombre = nombre;
        this.Apellido = Apellido;
        this.documento = documento;
        this.correo = correo;
        this.domicilio = domicilio;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", Apellido=" + Apellido + ", documento=" + documento + ", correo=" + correo + ", domicilio=" + domicilio + ", telefono=" + telefono + '}';
    }
    
    
}
