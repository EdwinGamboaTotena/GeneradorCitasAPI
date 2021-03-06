package adn.edwin.generadorcitasapi.dominio.repositorio;

import adn.edwin.generadorcitasapi.dominio.Producto;

import java.util.List;

public interface RepositorioProducto {

    Producto agregar(Producto producto);

    Producto obtener(Long id);

    List<Producto> listaProductos();

}
