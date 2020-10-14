package adn.edwin.generadorcitasapi.infraestructura.persistencia.repositorio;

import adn.edwin.generadorcitasapi.dominio.Cupon;
import adn.edwin.generadorcitasapi.dominio.repositorio.RepositorioCupon;
import adn.edwin.generadorcitasapi.infraestructura.persistencia.builder.CuponBuilder;
import adn.edwin.generadorcitasapi.infraestructura.persistencia.entidad.CuponEntity;
import adn.edwin.generadorcitasapi.infraestructura.persistencia.repositorio.jpa.RepositorioCuponJPA;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioCuponPersistente implements RepositorioCupon {

    private RepositorioCuponJPA repositorioCuponJPA;

    public RepositorioCuponPersistente(RepositorioCuponJPA repositorioCuponJPA) {
        this.repositorioCuponJPA = repositorioCuponJPA;
    }

    @Override
    public Cupon agregar(Cupon cupon) {
        CuponEntity cuponPersistido = repositorioCuponJPA.save(CuponBuilder.convertirEntity(cupon));
        return CuponBuilder.convertirADominio(cuponPersistido);
    }

    @Override
    public Cupon obtener(Long id) {
        CuponEntity cuponEntity = repositorioCuponJPA.findById(id).orElse(null);
        return CuponBuilder.convertirADominio(cuponEntity);
    }

}
