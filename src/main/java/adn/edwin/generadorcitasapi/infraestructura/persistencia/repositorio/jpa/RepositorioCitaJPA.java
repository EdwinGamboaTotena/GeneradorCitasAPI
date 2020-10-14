package adn.edwin.generadorcitasapi.infraestructura.persistencia.repositorio.jpa;

import adn.edwin.generadorcitasapi.infraestructura.persistencia.entidad.CitaEntity;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioCitaJPA extends CrudRepository<CitaEntity, Long> {


}
