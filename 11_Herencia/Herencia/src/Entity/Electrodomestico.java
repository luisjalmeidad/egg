package Entity;

public class Electrodomestico {

    protected double precio;
    protected String color;
    protected char consumoEnergetico;
    protected double peso;

    public Electrodomestico() {
    }

    public Electrodomestico(double precio, String color, char consumoEnergetico, double peso) {
        this.precio = precio;
        this.color = comprobarColor(color);
        this.consumoEnergetico = comprobarConsumoEnergetico(consumoEnergetico);
        this.peso = peso;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public char getConsumoEnergetico() {
        return consumoEnergetico;
    }

    public void setConsumoEnergetico(char consumoEnergetico) {
        this.consumoEnergetico = consumoEnergetico;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    //• Método comprobarConsumoEnergetico(char letra): comprueba que la letra es correcta,
    //sino es correcta usara la letra F por defecto. Este método se debe invocar al crear el
    //objeto y no será visible.
    private char comprobarConsumoEnergetico(char letra) {
        char consumoEnergetico = Character.toUpperCase(letra);
        char letrasPermitidas[] = {'A', 'B', 'C', 'D', 'E', 'F'};

        for (char letrasPermitida : letrasPermitidas) {
            if (consumoEnergetico == letrasPermitida) {
                return consumoEnergetico;
            }
        }
        return 'F';
    }

    //• Método comprobarColor(String color): comprueba que el color es correcto, y si no lo es,
    //usa el color blanco por defecto. Los colores disponibles para los electrodomésticos son
    //blanco, negro, rojo, azul y gris. No importa si el nombre está en mayúsculas o en
    //minúsculas. Este método se invocará al crear el objeto y no será visible.
    private String comprobarColor(String color) {
        String coloresPermitidos[] = {"Blanco", "Negro", "Rojo", "Azul", "Gris"};

        for (String coloresPermitido : coloresPermitidos) {
            if (coloresPermitido.equalsIgnoreCase(color)) {
                return color;
            }
        }
        return "Blanco";
    }   

    @Override
    public String toString() {
        return "Electrodomestico{" + "precio=" + precio + ", color=" + color + ", consumoEnergetico=" + consumoEnergetico + ", peso=" + peso + '}';
    }    
    
}
