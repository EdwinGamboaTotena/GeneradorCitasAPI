package adn.edwin.generadorcitasapi.aplicacion.fabrica;

import adn.edwin.generadorcitasapi.aplicacion.comando.ComandoCita;
import adn.edwin.generadorcitasapi.dominio.Cita;
import adn.edwin.generadorcitasapi.dominio.Producto;
import org.springframework.stereotype.Component;

@Component
public class FabricaCita {

    private FabricaProducto fabricaProducto;

    public FabricaCita(FabricaProducto fabricaProducto) {
        this.fabricaProducto = fabricaProducto;
    }

    public Cita crearCita(ComandoCita comandoCita) {
        Producto producto = fabricaProducto.crearProducto(comandoCita.getProductoSolicitado());
        return new Cita(comandoCita.getId(), comandoCita.getFechaGeneracion(), comandoCita.getFehcaSolicitud(),
                producto, comandoCita.getCuponUsado(), comandoCita.getCedulaCliente(), producto.getPrecio());
    }
}
