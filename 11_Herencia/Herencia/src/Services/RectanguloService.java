package Services;

import Entity.FormaGeometrica;
import Entity.Rectangulo;
import Interfaces.calculosFormas;

public class RectanguloService implements calculosFormas {

    @Override
    public double calcularArea(FormaGeometrica fg) {
        Rectangulo rec = (Rectangulo) fg;
        return rec.getBase() * rec.getAltura();
    }

    @Override
    public double calcularPerimetro(FormaGeometrica fg) {
        Rectangulo rec = (Rectangulo) fg;
        return (rec.getBase() + rec.getAltura()) * 2;
    }

}
