package adn.edwin.generadorcitasapi.dominio.servicio.cita;

import adn.edwin.generadorcitasapi.dominio.Cita;
import adn.edwin.generadorcitasapi.dominio.exception.CitaException;
import adn.edwin.generadorcitasapi.dominio.repositorio.RepositorioCita;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioListarCitas {

    private final RepositorioCita repositorioCita;

    public ServicioListarCitas(RepositorioCita repositorioCita) {
        this.repositorioCita = repositorioCita;
    }

    public List<Cita> ejecutar() {
        return repositorioCita.listaCitas();
    }
}
