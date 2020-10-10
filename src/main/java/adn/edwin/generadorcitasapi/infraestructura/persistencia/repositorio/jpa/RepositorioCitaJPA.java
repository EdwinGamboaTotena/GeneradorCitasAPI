package adn.edwin.generadorcitasapi.infraestructura.persistencia.repositorio.jpa;

import adn.edwin.generadorcitasapi.infraestructura.persistencia.entidad.CitaEntity;

import java.util.List;

public interface RepositorioCitaJPA {

    CitaEntity obtenerCitaEntityPorId(Long id);
    
    List<CitaEntity> obtenerCitasEntity();
}
