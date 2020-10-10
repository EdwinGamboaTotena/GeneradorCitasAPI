package adn.edwin.generadorcitasapi.infraestructura.persistencia.repositorio.jpa;

import adn.edwin.generadorcitasapi.infraestructura.persistencia.entidad.ProductoEntity;

import java.util.List;

public interface RepositorioProductoJPA {

    ProductoEntity obtenerProductoEntityPorId(Long id);

    List<ProductoEntity> obtenerProductosEntity();
}
