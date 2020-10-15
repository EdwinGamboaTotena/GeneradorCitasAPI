package adn.edwin.generadorcitasapi.testdatabuilder;

import adn.edwin.generadorcitasapi.dominio.Cita;
import adn.edwin.generadorcitasapi.dominio.Cupon;

public class CuponTestDataBuilder {

    private static final Long ID = 50L;
    private static final double PORCENTAJE_DESCUENTO_GENERAR = 10;
    private static final boolean USADO = false;
    private static final Cita CITA_GENERADORA = new CitaTestDataBuilder().build();

    private Long id;
    private double porcentajeDescuento;
    private Cita citaGeneradora;
    private boolean usado;

    public CuponTestDataBuilder() {
        this.id = ID;
        this.porcentajeDescuento = PORCENTAJE_DESCUENTO_GENERAR;
        this.citaGeneradora = CITA_GENERADORA;
        this.usado = USADO;
    }

    public CuponTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
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
        return new Cupon(this.id, porcentajeDescuento, citaGeneradora, usado);
    }

}
