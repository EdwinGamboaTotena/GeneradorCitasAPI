package adn.edwin.generadorcitasapi.dominio.servicio.producto;

import adn.edwin.generadorcitasapi.dominio.Producto;
import adn.edwin.generadorcitasapi.dominio.exception.ProductoException;
import adn.edwin.generadorcitasapi.dominio.repositorio.RepositorioProducto;

public class ServicioObtenerProducto {

    public static final String PRODUCTO_NO_ENCONTRADO = "Este producto no se encuentra registrado.";

    private RepositorioProducto repositorioProducto;

    public ServicioObtenerProducto(RepositorioProducto repositorioProducto) {
        this.repositorioProducto = repositorioProducto;
    }

    public Producto ejecutar(Long id) {
        Producto producto = this.repositorioProducto.obtener(id);
        if (producto == null)
            throw new ProductoException(PRODUCTO_NO_ENCONTRADO);
        return producto;
    }
}
