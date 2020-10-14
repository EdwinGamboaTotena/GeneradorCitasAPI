package adn.edwin.generadorcitasapi.infraestructura.persistencia.builder;

import adn.edwin.generadorcitasapi.dominio.Producto;
import adn.edwin.generadorcitasapi.infraestructura.persistencia.entidad.ProductoEntity;

public class ProductoBuilder {

    public static Producto convertirADominio(ProductoEntity productoEntity) {

        Producto producto = null;

        if (productoEntity != null) {
            producto = new Producto(productoEntity.getId(), productoEntity.getNombre(), productoEntity.getPrecio(),
                    productoEntity.isGeneraCupon(), productoEntity.getPorcentajeCuponGenerar());
        }

        return producto;
    }

    public static ProductoEntity convertirAEntity(Producto producto) {

        ProductoEntity productoEntity = new ProductoEntity();
        productoEntity.setId(producto.getId());
        productoEntity.setNombre(producto.getNombre());
        productoEntity.setPrecio(producto.getPrecio());
        productoEntity.setGeneraCupon(producto.isGeneraCupo());
        productoEntity.setPorcentajeCuponGenerar(producto.getPorcetajeCuponGenerar());

        return productoEntity;
    }

}
