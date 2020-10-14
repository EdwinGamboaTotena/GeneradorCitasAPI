package adn.edwin.generadorcitasapi.aplicacion.manejadores.producto;

import adn.edwin.generadorcitasapi.aplicacion.comando.ComandoProducto;
import adn.edwin.generadorcitasapi.aplicacion.fabrica.FabricaProducto;
import adn.edwin.generadorcitasapi.dominio.Producto;
import adn.edwin.generadorcitasapi.dominio.servicio.producto.ServicioAgregarProducto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ManejadorAgregarProducto {

    private final ServicioAgregarProducto servicioAgregarProducto;
    private final FabricaProducto fabricaProducto;

    public ManejadorAgregarProducto(ServicioAgregarProducto servicioAgregarProducto,
                                    FabricaProducto fabricaProducto) {
        this.servicioAgregarProducto = servicioAgregarProducto;
        this.fabricaProducto = fabricaProducto;
    }

    @Transactional
    public Producto ejecutar(ComandoProducto comandoProducto) {
        return this.servicioAgregarProducto.ejecutar(fabricaProducto.crearProducto(comandoProducto));
    }
}
