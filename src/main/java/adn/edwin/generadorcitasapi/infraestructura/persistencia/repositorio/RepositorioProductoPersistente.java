package adn.edwin.generadorcitasapi.infraestructura.persistencia.repositorio;

import adn.edwin.generadorcitasapi.dominio.Producto;
import adn.edwin.generadorcitasapi.dominio.repositorio.RepositorioProducto;
import adn.edwin.generadorcitasapi.infraestructura.persistencia.builder.ProductoBuilder;
import adn.edwin.generadorcitasapi.infraestructura.persistencia.entidad.ProductoEntity;
import adn.edwin.generadorcitasapi.infraestructura.persistencia.exception.NoRecordsException;
import adn.edwin.generadorcitasapi.infraestructura.persistencia.repositorio.jpa.RepositorioProductoJPA;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Repository
public class RepositorioProductoPersistente implements RepositorioProducto, RepositorioProductoJPA {

    private static final String ID = "id";
    private static final String PRODUCTO_FIND_BY_ID = "Producto.findById";
    private static final String PRODUCTO_FIND_ALL = "Producto.findAll";
    private static final String PRODUCTO_NO_ENCONTRADO = "Este producto no se encuentra registrado.";

    private static final Logger LOGGER = LogManager.getLogger(RepositorioProductoPersistente.class);

    private EntityManager entityManager;

    public RepositorioProductoPersistente(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void agregar(Producto producto) {
        entityManager.persist(ProductoBuilder.convertirAEntity(producto));
    }

    @Override
    public Producto obtener(Long id) {
        ProductoEntity productoEntity = obtenerProductoEntityPorId(id);
        return ProductoBuilder.convertirADominio(productoEntity);
    }

    @Override
    public List<Producto> listaProductos() {
        List<Producto> listaProductos = new ArrayList<>();
        obtenerProductosEntity().forEach(productoEntity ->
                listaProductos.add(ProductoBuilder.convertirADominio(productoEntity))
        );
        return listaProductos;
    }

    @Override
    public ProductoEntity obtenerProductoEntityPorId(Long id) {
        Query query = entityManager.createNamedQuery(PRODUCTO_FIND_BY_ID);
        query.setParameter(ID, id);
        try {
            return (ProductoEntity) query.getSingleResult();
        } catch (NoResultException nre) {
            LOGGER.warn(nre.getMessage());
            throw new NoRecordsException(PRODUCTO_NO_ENCONTRADO);
        }
    }

    @Override
    public List<ProductoEntity> obtenerProductosEntity() {
        Query query = entityManager.createNamedQuery(PRODUCTO_FIND_ALL);
        return (List<ProductoEntity>) query.getResultList();
    }

}
