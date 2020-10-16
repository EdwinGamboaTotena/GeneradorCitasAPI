package adn.edwin.generadorcitasapi.dominio.servicio.cupon;

import adn.edwin.generadorcitasapi.dominio.Cita;
import adn.edwin.generadorcitasapi.dominio.Cupon;
import adn.edwin.generadorcitasapi.dominio.repositorio.RepositorioCupon;

public class ServicioObtenerCuponPorCita {

    private RepositorioCupon repositorioCupon;

    public ServicioObtenerCuponPorCita(RepositorioCupon repositorioCupon) {
        this.repositorioCupon = repositorioCupon;
    }

    public Cupon ejecutar(Cita cita) {
        return this.repositorioCupon.obtenerCuponGeneradoId(cita);
    }
}
