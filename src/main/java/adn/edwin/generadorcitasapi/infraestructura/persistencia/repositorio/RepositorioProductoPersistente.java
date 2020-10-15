package adn.edwin.generadorcitasapi.infraestructura.persistencia.repositorio;

import adn.edwin.generadorcitasapi.dominio.Producto;
import adn.edwin.generadorcitasapi.dominio.repositorio.RepositorioProducto;
import adn.edwin.generadorcitasapi.infraestructura.persistencia.builder.ProductoBuilder;
import adn.edwin.generadorcitasapi.infraestructura.persistencia.entidad.ProductoEntity;
import adn.edwin.generadorcitasapi.infraestructura.persistencia.repositorio.jpa.RepositorioProductoJPA;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositorioProductoPersistente implements RepositorioProducto {

    private final RepositorioProductoJPA repositorioProductoJPA;

    public RepositorioProductoPersistente(RepositorioProductoJPA repositorioProductoJPA) {
        this.repositorioProductoJPA = repositorioProductoJPA;
    }

    @Override
    public Producto agregar(Producto producto) {
        ProductoEntity productoPersistido = repositorioProductoJPA.save(ProductoBuilder.convertirAEntity(producto));
        return ProductoBuilder.convertirADominio(productoPersistido);
    }

    @Override
    public Producto obtener(Long id) {
        ProductoEntity productoEntity = repositorioProductoJPA.findById(id).orElse(null);
        return ProductoBuilder.convertirADominio(productoEntity);
    }

    @Override
    public List<Producto> listaProductos() {
        List<Producto> listaProductos = new ArrayList<>();
        repositorioProductoJPA.findAll().forEach(productoEntity ->
                listaProductos.add(ProductoBuilder.convertirADominio(productoEntity))
        );
        return listaProductos;
    }

}
