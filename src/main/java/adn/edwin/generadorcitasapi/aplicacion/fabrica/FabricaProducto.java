package adn.edwin.generadorcitasapi.aplicacion.fabrica;

import adn.edwin.generadorcitasapi.aplicacion.comando.ComandoProducto;
import adn.edwin.generadorcitasapi.dominio.Producto;
import org.springframework.stereotype.Component;

@Component
public class FabricaProducto {

    public Producto crearProducto(ComandoProducto comandoProducto) {
        return new Producto(comandoProducto.getId(), comandoProducto.getNombre(), comandoProducto.getPrecio(),
                comandoProducto.isGeneraCupo(), comandoProducto.getPorcetajeCuponGenerar());
    }
}
