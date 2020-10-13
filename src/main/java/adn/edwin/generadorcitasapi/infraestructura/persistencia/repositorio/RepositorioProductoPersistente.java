package adn.edwin.generadorcitasapi.infraestructura.persistencia.repositorio;

import adn.edwin.generadorcitasapi.dominio.Producto;
import adn.edwin.generadorcitasapi.dominio.repositorio.RepositorioProducto;
import adn.edwin.generadorcitasapi.infraestructura.persistencia.builder.ProductoBuilder;
import adn.edwin.generadorcitasapi.infraestructura.persistencia.entidad.ProductoEntity;
import adn.edwin.generadorcitasapi.infraestructura.persistencia.repositorio.jpa.RepositorioProductoJPA;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositorioProductoPersistente implements RepositorioProducto, RepositorioProductoJPA {

    private static final String ID = "id";
    private static final String PRODUCTO_FIND_BY_ID = "Producto.findById";
    private static final String PRODUCTO_FIND_ALL = "Producto.findAll";

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
        obtenerProductosEntity().forEach(productoEntity -> {
            listaProductos.add(ProductoBuilder.convertirADominio(productoEntity));
        });
        return listaProductos;
    }

    @Override
    public ProductoEntity obtenerProductoEntityPorId(Long id) {
        Query query = entityManager.createNamedQuery(PRODUCTO_FIND_BY_ID);
        query.setParameter(ID, id);
        try {
            return (ProductoEntity) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public List<ProductoEntity> obtenerProductosEntity() {
        Query query = entityManager.createNamedQuery(PRODUCTO_FIND_ALL);
        return (List<ProductoEntity>) query.getResultList();
    }

}
