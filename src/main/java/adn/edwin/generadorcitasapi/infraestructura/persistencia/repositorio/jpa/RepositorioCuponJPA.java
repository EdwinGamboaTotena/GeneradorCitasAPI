package adn.edwin.generadorcitasapi.infraestructura.persistencia.repositorio.jpa;

import adn.edwin.generadorcitasapi.infraestructura.persistencia.entidad.CuponEntity;

public interface RepositorioCuponJPA {

    CuponEntity obtenerCuponEntityPorId(Long id);
}
