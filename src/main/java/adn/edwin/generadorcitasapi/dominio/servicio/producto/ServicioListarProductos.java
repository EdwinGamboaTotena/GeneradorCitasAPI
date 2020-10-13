package adn.edwin.generadorcitasapi.dominio.servicio.producto;

import adn.edwin.generadorcitasapi.dominio.Producto;
import adn.edwin.generadorcitasapi.dominio.repositorio.RepositorioProducto;

import java.util.List;

public class ServicioListarProductos {

    private RepositorioProducto repositorioProducto;

    public ServicioListarProductos(RepositorioProducto repositorioProducto) {
        this.repositorioProducto = repositorioProducto;
    }

    public List<Producto> ejecutar() {
        return this.repositorioProducto.listaProductos();
    }
}
