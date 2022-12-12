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

    //• Método precioFinal(): según el consumo energético y su tamaño, aumentará el valor del
    //precio. Esta es la lista de precios:
    protected void precioFinal() {
        char letras[] = {'A', 'B', 'C', 'D', 'E', 'F'};
        double precios[] = {1000, 800, 600, 500, 300, 100};

        for (int i = 0; i < letras.length; i++) {
            if (letras[i] == consumoEnergetico) {
                precio += precios[i];
            }
        }

        if (peso >= 1 && peso <= 19) {
            precio += 100;
        } else if (peso <= 49) {
            precio += 500;
        } else if (peso <= 79) {
            precio += 800;
        } else {
            precio += 1000;
        }
    }

    @Override
    public String toString() {
        return "Electrodomestico{" + "precio=" + precio + ", color=" + color + ", consumoEnergetico=" + consumoEnergetico + ", peso=" + peso + '}';
    }    
    
}
