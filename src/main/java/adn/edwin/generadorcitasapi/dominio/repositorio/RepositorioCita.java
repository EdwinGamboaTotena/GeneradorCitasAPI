package adn.edwin.generadorcitasapi.dominio.repositorio;

import adn.edwin.generadorcitasapi.dominio.Cita;

import java.util.List;

public interface RepositorioCita {

    Cita agregar(Cita cita);

    Cita obtener(Long id);

    List<Cita> listaCitas();
}
