/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author A309436
 */
public class Residencia extends Extrahoteleros{
//  cantidad de habitaciones, si se hacen o no descuentos a los gremios y si posee o no  campo deportivo.      
    private boolean descGremio;
    private boolean campoDeportivo;

    public Residencia() {
    }

    public Residencia(boolean descGremio, boolean campoDeportivo, boolean privado, double metrosCuadrados, String nombre, String direccion, String localidad, String gerente) {
        super(privado, metrosCuadrados, nombre, direccion, localidad, gerente);
        this.descGremio = descGremio;
        this.campoDeportivo = campoDeportivo;
    }



    public boolean isDescGremio() {
        return descGremio;
    }

    public void setDescGremio(boolean descGremio) {
        this.descGremio = descGremio;
    }

    public boolean isCampoDeportivo() {
        return campoDeportivo;
    }

    public void setCampoDeportivo(boolean campoDeportivo) {
        this.campoDeportivo = campoDeportivo;
    }

    @Override
    public String toString() {
        return super.toString() + "Residencia{" + "descGremio=" + descGremio + ", campoDeportivo=" + campoDeportivo + '}';
    }
}
