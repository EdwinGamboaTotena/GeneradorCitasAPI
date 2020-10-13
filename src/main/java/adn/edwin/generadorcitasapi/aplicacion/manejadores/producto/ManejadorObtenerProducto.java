package adn.edwin.generadorcitasapi.aplicacion.manejadores.producto;

import adn.edwin.generadorcitasapi.dominio.Producto;
import adn.edwin.generadorcitasapi.dominio.servicio.producto.ServicioObtenerProducto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ManejadorObtenerProducto {

    private final ServicioObtenerProducto servicioObtenerProducto;

    public ManejadorObtenerProducto(ServicioObtenerProducto servicioObtenerProducto) {
        this.servicioObtenerProducto = servicioObtenerProducto;
    }

    @Transactional
    public Producto ejecutar(Long id) {
        return	this.servicioObtenerProducto.ejecutar(id);
    }
}
