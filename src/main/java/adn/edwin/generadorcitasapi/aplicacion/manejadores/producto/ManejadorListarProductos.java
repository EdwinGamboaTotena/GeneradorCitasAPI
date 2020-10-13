package adn.edwin.generadorcitasapi.aplicacion.manejadores.producto;

import adn.edwin.generadorcitasapi.dominio.Producto;
import adn.edwin.generadorcitasapi.dominio.servicio.producto.ServicioListarProductos;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ManejadorListarProductos {

    private final ServicioListarProductos servicioListarProductos;

    public ManejadorListarProductos(ServicioListarProductos servicioListarProductos) {
        this.servicioListarProductos = servicioListarProductos;
    }

    @Transactional
    public List<Producto> ejecutar() {
        return servicioListarProductos.ejecutar();
    }
}
