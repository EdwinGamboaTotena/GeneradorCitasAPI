package adn.edwin.generadorcitasapi.infraestructura.persistencia.builder;

import adn.edwin.generadorcitasapi.dominio.Producto;
import adn.edwin.generadorcitasapi.infraestructura.persistencia.entidad.ProductoEntity;

public final class ProductoBuilder {

    private static final String INSTANCIA_CLASE_UTILIDAD =
            "La clase ProdcutoBuilder no debe ser instanciada, es una clase de utilidad";

    private ProductoBuilder() {
        throw new IllegalStateException(INSTANCIA_CLASE_UTILIDAD);
    }

    public static Producto convertirADominio(ProductoEntity productoEntity) {
        Producto producto = null;
        if (productoEntity != null && productoEntity.getId() != null) {
            producto = new Producto(productoEntity.getId(), productoEntity.getNombre(), productoEntity.getPrecio(),
                    productoEntity.isGeneraCupon(), productoEntity.getPorcentajeCuponGenerar());
        }
        return producto;
    }

    public static ProductoEntity convertirAEntity(Producto producto) {
        ProductoEntity productoEntity = null;
        if (producto != null) {
            productoEntity = new ProductoEntity();
            productoEntity.setId(producto.getId());
            productoEntity.setNombre(producto.getNombre());
            productoEntity.setPrecio(producto.getPrecio());
            productoEntity.setGeneraCupon(producto.isGeneraCupo());
            productoEntity.setPorcentajeCuponGenerar(producto.getPorcetajeCuponGenerar());
        }
        return productoEntity;
    }

}
