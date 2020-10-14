package adn.edwin.generadorcitasapi.dominio.servicio.cita;

import adn.edwin.generadorcitasapi.dominio.Cita;
import adn.edwin.generadorcitasapi.dominio.repositorio.RepositorioCita;

public class ServicioObtenerCita {


    private final RepositorioCita repositorioCita;

    public ServicioObtenerCita(RepositorioCita repositorioCita) {
        this.repositorioCita = repositorioCita;
    }

    public Cita ejecutar(Long id) {
        return this.repositorioCita.obtener(id);
    }
}
