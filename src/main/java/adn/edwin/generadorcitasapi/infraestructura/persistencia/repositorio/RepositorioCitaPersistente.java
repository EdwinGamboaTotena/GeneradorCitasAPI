package adn.edwin.generadorcitasapi.infraestructura.persistencia.repositorio;

import adn.edwin.generadorcitasapi.dominio.Cita;
import adn.edwin.generadorcitasapi.dominio.repositorio.RepositorioCita;
import adn.edwin.generadorcitasapi.infraestructura.persistencia.builder.CitaBuilder;
import adn.edwin.generadorcitasapi.infraestructura.persistencia.entidad.CitaEntity;
import adn.edwin.generadorcitasapi.infraestructura.persistencia.repositorio.jpa.RepositorioCitaJPA;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositorioCitaPersistente implements RepositorioCita {

    private final RepositorioCitaJPA repositorioCitaJPA;

    public RepositorioCitaPersistente(RepositorioCitaJPA repositorioCitaJPA) {
        this.repositorioCitaJPA = repositorioCitaJPA;
    }

    @Override
    public Cita agregar(Cita cita) {
        CitaEntity citaPersistida = repositorioCitaJPA.save(CitaBuilder.convertirAEntidad(cita));
        return CitaBuilder.convertirADominio(citaPersistida);
    }

    @Override
    public Cita obtener(Long id) {
        CitaEntity citaEntity = repositorioCitaJPA.findById(id).orElse(null);
        return CitaBuilder.convertirADominio(citaEntity);
    }

    @Override
    public List<Cita> listaCitas() {
        List<Cita> listaCitas = new ArrayList<>();
        repositorioCitaJPA.findAll().forEach(citaEntity ->
                listaCitas.add(CitaBuilder.convertirADominio(citaEntity))
        );
        return listaCitas;
    }

}
