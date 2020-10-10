package adn.edwin.generadorcitasapi.infraestructura.configuracion.sistema;

import adn.edwin.generadorcitasapi.dominio.repositorio.RepositorioCita;
import adn.edwin.generadorcitasapi.dominio.repositorio.RepositorioCupon;
import adn.edwin.generadorcitasapi.dominio.repositorio.RepositorioProducto;
import adn.edwin.generadorcitasapi.infraestructura.configuracion.conexion.ConexionJPA;
import adn.edwin.generadorcitasapi.infraestructura.persistencia.repositorio.RepositorioCitaPersistente;
import adn.edwin.generadorcitasapi.infraestructura.persistencia.repositorio.RepositorioCuponPersistente;
import adn.edwin.generadorcitasapi.infraestructura.persistencia.repositorio.RepositorioProductoPersistente;

import javax.persistence.EntityManager;

public class SistemaDePersistencia {

    private EntityManager entityManager;

    public SistemaDePersistencia() {
        this.entityManager = new ConexionJPA().createEntityManager();
    }

    public RepositorioProducto obtenerRepositorioProductos() {
        return new RepositorioProductoPersistente(entityManager);
    }

    public RepositorioCupon obtenerRepositorioCupon() {
        return new RepositorioCuponPersistente(entityManager);
    }

    public RepositorioCita obtenerRepositorioCita() {
        return new RepositorioCitaPersistente(entityManager);
    }

    public void iniciar() {
        entityManager.getTransaction().begin();
    }

    public void terminar() {
        entityManager.getTransaction().commit();
    }
}
