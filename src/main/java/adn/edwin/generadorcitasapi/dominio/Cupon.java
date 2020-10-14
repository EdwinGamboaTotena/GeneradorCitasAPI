package adn.edwin.generadorcitasapi.dominio;

import adn.edwin.generadorcitasapi.dominio.exception.CuponException;

public class Cupon {

    public static final String PORCENTAJE_DESCUENTO_RANGO_INVALIDO =
            "El procentaje de descuento del cupon debe estar entre 0 y 100.";
    public static final String CITA_GENERADORA_NO_PUEDE_SER_VACIA =
            "La cita que genera el cupon no puede estar vacia";

    private Long id;
    private double porcentajeDescuento;
    private Cita citaGeneradora;
    private boolean usado;

    public Cupon(Long id, double porcentajeDescuento, Cita citaGeneradora, boolean usado) {
        validarPorcentajeCupon(porcentajeDescuento);
        validarCita(citaGeneradora);
        this.id = id;
        this.porcentajeDescuento = porcentajeDescuento;
        this.citaGeneradora = citaGeneradora;
        this.usado = usado;
    }

    private void validarPorcentajeCupon(double procentaje) {
        if (procentaje < 0.0 || procentaje > 100) {
            throw new CuponException(PORCENTAJE_DESCUENTO_RANGO_INVALIDO);
        }
    }

    private void validarCita(Cita citaGeneradora) {
        if (citaGeneradora == null) {
            throw new CuponException(CITA_GENERADORA_NO_PUEDE_SER_VACIA);
        }
    }

    public Long getId() {
        return id;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public Cita getCitaGeneradora() {
        return citaGeneradora;
    }

    public boolean isUsado() {
        return usado;
    }

    public void setUsado(boolean usado) {
        this.usado = usado;
    }
}
