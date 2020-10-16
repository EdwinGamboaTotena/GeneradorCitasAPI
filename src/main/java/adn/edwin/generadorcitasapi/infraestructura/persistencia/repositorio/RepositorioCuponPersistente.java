package adn.edwin.generadorcitasapi.infraestructura.persistencia.repositorio;

import adn.edwin.generadorcitasapi.dominio.Cita;
import adn.edwin.generadorcitasapi.dominio.Cupon;
import adn.edwin.generadorcitasapi.dominio.repositorio.RepositorioCupon;
import adn.edwin.generadorcitasapi.infraestructura.persistencia.builder.CitaBuilder;
import adn.edwin.generadorcitasapi.infraestructura.persistencia.builder.CuponBuilder;
import adn.edwin.generadorcitasapi.infraestructura.persistencia.entidad.CuponEntity;
import adn.edwin.generadorcitasapi.infraestructura.persistencia.repositorio.jpa.RepositorioCuponJPA;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RepositorioCuponPersistente implements RepositorioCupon {

    private final RepositorioCuponJPA repositorioCuponJPA;

    public RepositorioCuponPersistente(RepositorioCuponJPA repositorioCuponJPA) {
        this.repositorioCuponJPA = repositorioCuponJPA;
    }

    @Override
    @Transactional
    public Cupon agregar(Cupon cupon) {
        CuponEntity cuponPersistido = repositorioCuponJPA.save(CuponBuilder.convertirEntity(cupon));
        return CuponBuilder.convertirADominio(cuponPersistido);
    }

    @Override
    public Cupon obtener(Long id) {
        CuponEntity cuponEntity = repositorioCuponJPA.findById(id).orElse(null);
        return CuponBuilder.convertirADominio(cuponEntity);
    }

    @Override
    public Cupon obtenerCuponConsumido(Cita cita) {
        CuponEntity cuponEntity = repositorioCuponJPA.findByCitaConsumidora(
                CitaBuilder.convertirAEntidad(cita)).stream().findFirst().orElse(null);
        return CuponBuilder.convertirADominio(cuponEntity);
    }

    @Override
    public Cupon obtenerCuponGeneradoId(Cita cita) {
        CuponEntity cuponEntity = repositorioCuponJPA.findByCitaGeneradora(
                CitaBuilder.convertirAEntidad(cita)).stream().findFirst().orElse(null);
        return CuponBuilder.convertirADominio(cuponEntity);
    }

    @Override
    public Cupon editar(Cupon cupon, Cita citaConsumidora) {
        CuponEntity cuponPersistido = CuponBuilder.convertirEntity(cupon);
        cuponPersistido.setCitaConsumidora(CitaBuilder.convertirAEntidad(citaConsumidora));
        cuponPersistido = repositorioCuponJPA.save(cuponPersistido);

        return CuponBuilder.convertirADominio(cuponPersistido);
    }
}
