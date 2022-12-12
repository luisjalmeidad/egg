package Services;

import Entity.Electrodomestico;
import Entity.Televisor;
import java.util.Scanner;

public class TelevisorService extends ElectrodomesticoService {

    public Televisor crearTelevisor() {
        Scanner leer = new Scanner(System.in);
        Electrodomestico e = super.crearElectrodomestico();

        System.out.println("Ingrese la resolucion en pulgadas");
        double resolucion = leer.nextDouble();
        System.out.println("¿Tiene sintonizador? S/N");
        boolean sintonizador = leer.next().equalsIgnoreCase("S");

        return new Televisor(resolucion, sintonizador, e.getPrecio(), e.getColor(), e.getConsumoEnergetico(), e.getPeso());
    }

    public void precioFinal(Televisor tele) {
        super.precioFinal(tele);
        if (tele.getResolucion() > 40) {
            tele.setPrecio(tele.getPrecio() * 1.3);
        }
        if (tele.isSintonizadorTDT()) {
            tele.setPrecio(tele.getPrecio() + 500);
        }
    }
}
