package adn.edwin.generadorcitasapi.dominio.servicio.cupon;

import adn.edwin.generadorcitasapi.dominio.Cupon;
import adn.edwin.generadorcitasapi.dominio.repositorio.RepositorioCupon;

public class ServicioAgregarCupon {

    private final RepositorioCupon repositorioCupon;

    public ServicioAgregarCupon(RepositorioCupon repositorioCupon) {
        this.repositorioCupon = repositorioCupon;
    }

    public void ejecutar(Cupon cupon) {
        this.repositorioCupon.agregar(cupon);
    }
}
