package adn.edwin.generadorcitasapi.dominio.servicio.cupon;

import adn.edwin.generadorcitasapi.dominio.Cita;
import adn.edwin.generadorcitasapi.dominio.Cupon;
import adn.edwin.generadorcitasapi.dominio.repositorio.RepositorioCupon;

public class ServicioObtenerCuponConsumido {

    private RepositorioCupon repositorioCupon;

    public ServicioObtenerCuponConsumido(RepositorioCupon repositorioCupon) {
        this.repositorioCupon = repositorioCupon;
    }

    public Cupon ejecutar(Cita cita) {
        return this.repositorioCupon.obtenerCuponConsumido(cita);
    }
}
