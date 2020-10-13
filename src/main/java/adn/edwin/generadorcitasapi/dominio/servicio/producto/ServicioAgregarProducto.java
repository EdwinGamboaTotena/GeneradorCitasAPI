package adn.edwin.generadorcitasapi.dominio.servicio.producto;

import adn.edwin.generadorcitasapi.dominio.Producto;
import adn.edwin.generadorcitasapi.dominio.repositorio.RepositorioProducto;

public class ServicioAgregarProducto {

    private final RepositorioProducto repositorioProducto;

    public ServicioAgregarProducto(RepositorioProducto repositorioProducto) {
        this.repositorioProducto = repositorioProducto;
    }

    public void ejecutar(Producto producto) {
        this.repositorioProducto.agregar(producto);
    }
}
