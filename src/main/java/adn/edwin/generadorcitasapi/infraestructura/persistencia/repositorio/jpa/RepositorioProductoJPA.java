package adn.edwin.generadorcitasapi.infraestructura.persistencia.repositorio.jpa;

import adn.edwin.generadorcitasapi.infraestructura.persistencia.entidad.ProductoEntity;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioProductoJPA extends CrudRepository<ProductoEntity, Long> {

}
