package adn.edwin.generadorcitasapi.infraestructura.persistencia.repositorio.jpa;

import adn.edwin.generadorcitasapi.infraestructura.persistencia.entidad.CuponEntity;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioCuponJPA extends CrudRepository<CuponEntity, Long> {

}
