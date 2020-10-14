package adn.edwin.generadorcitasapi.infraestructura.persistencia.repositorio;

import adn.edwin.generadorcitasapi.dominio.Cita;
import adn.edwin.generadorcitasapi.dominio.repositorio.RepositorioCita;
import adn.edwin.generadorcitasapi.infraestructura.persistencia.builder.CitaBuilder;
import adn.edwin.generadorcitasapi.infraestructura.persistencia.entidad.CitaEntity;
import adn.edwin.generadorcitasapi.infraestructura.persistencia.exception.NoRecordsException;
import adn.edwin.generadorcitasapi.infraestructura.persistencia.repositorio.jpa.RepositorioCitaJPA;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Repository
public class RepositorioCitaPersistente implements RepositorioCita, RepositorioCitaJPA {

    private static final String ID = "id";
    private static final String CITA_FIND_BY_ID = "Cita.findById";
    private static final String CITA_FIND_ALL = "Cita.findAll";
    private static final String CITA_NO_ENCONTRADA = "Esta cita no se encuentra registrada.";

    private static final Logger LOGGER = LogManager.getLogger(RepositorioCitaPersistente.class);

    private EntityManager entityManager;

    public RepositorioCitaPersistente(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void agregar(Cita cita) {
        entityManager.persist(CitaBuilder.convertirAEntidad(cita));
    }

    @Override
    public Cita obtener(Long id) {
        CitaEntity citaEntity = obtenerCitaEntityPorId(id);
        return CitaBuilder.convertirADominio(citaEntity);
    }

    @Override
    public List<Cita> listaCitas() {
        List<Cita> listaCitas = new ArrayList<>();
        obtenerCitasEntity().forEach(citaEntity ->
                listaCitas.add(CitaBuilder.convertirADominio(citaEntity))
        );
        return listaCitas;
    }

    @Override
    public CitaEntity obtenerCitaEntityPorId(Long id) {
        Query query = entityManager.createNamedQuery(CITA_FIND_BY_ID);
        query.setParameter(ID, id);
        try {
            return (CitaEntity) query.getSingleResult();
        } catch (NoResultException nre) {
            LOGGER.warn(nre.getMessage());
            throw new NoRecordsException(CITA_NO_ENCONTRADA);
        }
    }

    @Override
    public List<CitaEntity> obtenerCitasEntity() {
        Query query = entityManager.createNamedQuery(CITA_FIND_ALL);
        return (List<CitaEntity>) query.getResultList();
    }
}
