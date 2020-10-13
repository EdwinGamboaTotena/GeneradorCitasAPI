package adn.edwin.generadorcitasapi.dominio.servicio.producto;

import adn.edwin.generadorcitasapi.dominio.Producto;
import adn.edwin.generadorcitasapi.dominio.exception.ProductoException;
import adn.edwin.generadorcitasapi.dominio.repositorio.RepositorioProducto;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioListarProductos {

    private RepositorioProducto repositorioProducto;

    public ServicioListarProductos(RepositorioProducto repositorioProducto) {
        this.repositorioProducto = repositorioProducto;
    }

    public List<Producto> ejecutar() {
        return this.repositorioProducto.listaProductos();
    }
}
