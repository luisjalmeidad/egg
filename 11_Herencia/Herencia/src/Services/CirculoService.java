package Services;

import Entity.Circulo;
import Entity.FormaGeometrica;
import Interfaces.calculosFormas;

public class CirculoService implements calculosFormas {

    @Override
    public double calcularArea(FormaGeometrica fg) {
        Circulo c = (Circulo) fg;
        return PI * Math.pow(c.getRadio(), 2);
    }

    @Override
    public double calcularPerimetro(FormaGeometrica fg) {
        Circulo c = (Circulo) fg;
        return PI * c.getDiametro();
    }
}
