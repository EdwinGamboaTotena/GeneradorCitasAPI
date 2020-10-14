package adn.edwin.generadorcitasapi.dominio.servicio.cita;

import adn.edwin.generadorcitasapi.dominio.Cita;
import adn.edwin.generadorcitasapi.dominio.exception.CitaException;
import adn.edwin.generadorcitasapi.dominio.repositorio.RepositorioCita;

public class ServicioObtenerCita {

    private static final String CITA_NO_ENCONTRADA = "Esta cita no se encuentra registrada.";

    private final RepositorioCita repositorioCita;

    public ServicioObtenerCita(RepositorioCita repositorioCita) {
        this.repositorioCita = repositorioCita;
    }

    public Cita ejecutar(Long id) {
        Cita cita = this.repositorioCita.obtener(id);
        if (cita == null)
            throw new CitaException(CITA_NO_ENCONTRADA);
        return cita;
    }
}
