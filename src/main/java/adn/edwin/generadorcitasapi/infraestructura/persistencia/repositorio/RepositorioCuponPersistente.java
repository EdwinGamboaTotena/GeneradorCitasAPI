package adn.edwin.generadorcitasapi.infraestructura.persistencia.repositorio;

import adn.edwin.generadorcitasapi.dominio.Cupon;
import adn.edwin.generadorcitasapi.dominio.repositorio.RepositorioCupon;
import adn.edwin.generadorcitasapi.infraestructura.persistencia.builder.CuponBuilder;
import adn.edwin.generadorcitasapi.infraestructura.persistencia.entidad.CuponEntity;
import adn.edwin.generadorcitasapi.infraestructura.persistencia.repositorio.jpa.RepositorioCuponJPA;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Repository
public class RepositorioCuponPersistente implements RepositorioCupon, RepositorioCuponJPA {

    private static final String ID = "id";
    private static final String CUPON_FIND_BY_ID = "Cita.findById";

    private EntityManager entityManager;

    public RepositorioCuponPersistente(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void agregar(Cupon cupon) {
        entityManager.persist(CuponBuilder.convertirEntity(cupon));
    }

    @Override
    public Cupon obtener(Long id) {
        CuponEntity cuponEntity = obtenerCuponEntityPorId(id);
        return CuponBuilder.convertirADominio(cuponEntity);
    }

    @Override
    public CuponEntity obtenerCuponEntityPorId(Long id) {
        Query query = entityManager.createNamedQuery(CUPON_FIND_BY_ID);
        query.setParameter(ID, id);
        try {
            return (CuponEntity) query.getSingleResult();
        } catch (
                NoResultException nre) {
            return null;
        }
    }
}
