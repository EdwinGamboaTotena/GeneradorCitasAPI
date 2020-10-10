package adn.edwin.generadorcitasapi.testdatabuilder;

import adn.edwin.generadorcitasapi.dominio.Cita;
import adn.edwin.generadorcitasapi.dominio.Cupon;

public class CuponTestDataBuilder {

    private static final double PORCENTAJE_DESCUENTO_GENERAR = 10;
    private static final boolean USADO = false;
    private static final Cita CITA_GENERADORA = new CitaTestDataBuilder().build();

    private double porcentajeDescuento;
    private Cita citaGeneradora;
    private boolean usado;

    public CuponTestDataBuilder() {
        this.porcentajeDescuento = PORCENTAJE_DESCUENTO_GENERAR;
        this.citaGeneradora = CITA_GENERADORA;
        this.usado = USADO;
    }

    public CuponTestDataBuilder conPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
        return this;
    }

    public CuponTestDataBuilder conCitaGenerador(Cita cita) {
        this.citaGeneradora = cita;
        return this;
    }

    public CuponTestDataBuilder conInformacionUsado(boolean usado) {
        this.usado = usado;
        return this;
    }

    public Cupon build() {
        return new Cupon(null, porcentajeDescuento, citaGeneradora, usado);
    }

}
