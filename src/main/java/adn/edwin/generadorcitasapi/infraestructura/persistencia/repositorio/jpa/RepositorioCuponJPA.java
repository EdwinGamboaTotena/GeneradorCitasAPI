package adn.edwin.generadorcitasapi.infraestructura.persistencia.repositorio.jpa;

import adn.edwin.generadorcitasapi.infraestructura.persistencia.entidad.CitaEntity;
import adn.edwin.generadorcitasapi.infraestructura.persistencia.entidad.CuponEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RepositorioCuponJPA extends CrudRepository<CuponEntity, Long> {

    List<CuponEntity> findByCitaConsumidora(CitaEntity citaConsumidora);

    List<CuponEntity> findByCitaGeneradora(CitaEntity citaGeneradora);

}
