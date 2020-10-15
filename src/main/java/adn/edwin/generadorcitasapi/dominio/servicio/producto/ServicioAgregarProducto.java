package adn.edwin.generadorcitasapi.dominio.servicio.producto;

import adn.edwin.generadorcitasapi.dominio.Producto;
import adn.edwin.generadorcitasapi.dominio.exception.ProductoException;
import adn.edwin.generadorcitasapi.dominio.repositorio.RepositorioProducto;

public class ServicioAgregarProducto {

    public static final String ID_NO_DEBE_ESTAR = "Si se quiere agregar un nuevo producto el ID debe ser 0 o null.";

    private final RepositorioProducto repositorioProducto;

    public ServicioAgregarProducto(RepositorioProducto repositorioProducto) {
        this.repositorioProducto = repositorioProducto;
    }

    public Producto ejecutar(Producto producto) {
        if (producto.getId() != null && producto.getId() > 0)
            throw new ProductoException(ID_NO_DEBE_ESTAR);
        return this.repositorioProducto.agregar(producto);
    }
}
