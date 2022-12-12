package Entity;

public class Televisor extends Electrodomestico{
    private double resolucion;
    private boolean sintonizadorTDT;    

    public Televisor() {
    }

    public Televisor(double resolucion, boolean sintonizadorTDT, double precio, String color, char consumoEnergetico, double peso) {
        super(precio, color, consumoEnergetico, peso);
        this.resolucion = resolucion;
        this.sintonizadorTDT = sintonizadorTDT;
    }

    public double getResolucion() {
        return resolucion;
    }

    public void setResolucion(double resolucion) {
        this.resolucion = resolucion;
    }

    public boolean isSintonizadorTDT() {
        return sintonizadorTDT;
    }

    public void setSintonizadorTDT(boolean sintonizadorTDT) {
        this.sintonizadorTDT = sintonizadorTDT;
    }
    
    //• Método precioFinal(): este método será heredado y se le sumará la siguiente
    //funcionalidad. Si el televisor tiene una resolución mayor de 40 pulgadas, se
    //incrementará el precio un 30% y si tiene un sintonizador TDT incorporado, aumentará
    //$500. Recuerda que las condiciones que hemos visto en la clase Electrodomestico
    //también deben afectar al precio.  
    
    @Override
    public void precioFinal() {
        super.precioFinal();
        if (resolucion > 40) {
            precio = precio * 1.3;
        }
        
        if (sintonizadorTDT) {
            precio += 500;
        }
    }

    @Override
    public String toString() {
        return "Electrodomestico{" + "precio=" + precio + ", color=" + color + ", consumoEnergetico=" + consumoEnergetico + ", peso=" + peso + "}  Televisor{" + "resolucion=" + resolucion + ", sintonizadorTDT=" + sintonizadorTDT + '}';
    }   
    
}
