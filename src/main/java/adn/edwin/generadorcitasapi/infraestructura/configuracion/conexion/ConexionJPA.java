package adn.edwin.generadorcitasapi.infraestructura.configuracion.conexion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexionJPA {
    private static final String SPA = "spa";

    private static EntityManagerFactory entityManagerFactory;

    public ConexionJPA() {
        entityManagerFactory = Persistence.createEntityManagerFactory(SPA);
    }

    public EntityManager createEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}
