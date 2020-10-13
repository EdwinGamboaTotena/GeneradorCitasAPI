package adn.edwin.generadorcitasapi.dominio.servicio.cita;

import adn.edwin.generadorcitasapi.dominio.Cita;
import adn.edwin.generadorcitasapi.dominio.exception.CitaException;
import adn.edwin.generadorcitasapi.dominio.repositorio.RepositorioCita;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

@Component
public class ServicioObtenerCita {

    public static final String CITA_NO_ENCONTRADA = "Esta cita no se encuentra registrada.";

    private final RepositorioCita repositorioCita;

    public ServicioObtenerCita(RepositorioCita repositorioCita) {
        this.repositorioCita = repositorioCita;
    }

    public Cita ejecutar(Long id) {
        try {
            return this.repositorioCita.obtener(id);
        } catch (EmptyResultDataAccessException erd) {
            throw new CitaException(CITA_NO_ENCONTRADA);
        }
    }
}
