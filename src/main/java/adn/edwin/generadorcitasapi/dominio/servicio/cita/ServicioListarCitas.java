package adn.edwin.generadorcitasapi.dominio.servicio.cita;

import adn.edwin.generadorcitasapi.dominio.Cita;
import adn.edwin.generadorcitasapi.dominio.repositorio.RepositorioCita;

import java.util.List;

public class ServicioListarCitas {

    private final RepositorioCita repositorioCita;

    public ServicioListarCitas(RepositorioCita repositorioCita) {
        this.repositorioCita = repositorioCita;
    }

    public List<Cita> ejecutar() {
        return repositorioCita.listaCitas();
    }
}
