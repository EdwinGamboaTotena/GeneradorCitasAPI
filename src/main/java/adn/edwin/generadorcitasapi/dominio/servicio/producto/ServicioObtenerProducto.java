package adn.edwin.generadorcitasapi.dominio.servicio.producto;

import adn.edwin.generadorcitasapi.dominio.Producto;
import adn.edwin.generadorcitasapi.dominio.repositorio.RepositorioProducto;

public class ServicioObtenerProducto {

    private RepositorioProducto repositorioProducto;

    public ServicioObtenerProducto(RepositorioProducto repositorioProducto) {
        this.repositorioProducto = repositorioProducto;
    }

    public Producto ejecutar(Long id) {
        return this.repositorioProducto.obtener(id);
    }
}
