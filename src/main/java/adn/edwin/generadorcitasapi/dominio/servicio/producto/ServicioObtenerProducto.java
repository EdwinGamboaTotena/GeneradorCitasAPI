package adn.edwin.generadorcitasapi.dominio.servicio.producto;

import adn.edwin.generadorcitasapi.dominio.Producto;
import adn.edwin.generadorcitasapi.dominio.exception.ProductoException;
import adn.edwin.generadorcitasapi.dominio.repositorio.RepositorioProducto;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

@Component
public class ServicioObtenerProducto {

    public static final String PRODUCTO_NO_ENCONTRADO = "Este producto no se encuentra registrado.";

    private RepositorioProducto repositorioProducto;

    public ServicioObtenerProducto(RepositorioProducto repositorioProducto) {
        this.repositorioProducto = repositorioProducto;
    }

    public Producto ejecutar(Long id) {
        try {
            return this.repositorioProducto.obtener(id);
        } catch (EmptyResultDataAccessException erd) {
            throw new ProductoException(PRODUCTO_NO_ENCONTRADO);
        }
    }
}
