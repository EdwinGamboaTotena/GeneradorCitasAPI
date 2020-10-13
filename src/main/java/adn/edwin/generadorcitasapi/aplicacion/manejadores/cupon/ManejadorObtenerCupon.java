package adn.edwin.generadorcitasapi.aplicacion.manejadores.cupon;

import adn.edwin.generadorcitasapi.dominio.Cupon;
import adn.edwin.generadorcitasapi.dominio.servicio.cupon.ServicioObtenerCupon;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ManejadorObtenerCupon {

    private final ServicioObtenerCupon servicioObtenerCupon;

    public ManejadorObtenerCupon(ServicioObtenerCupon servicioObtenerCupon) {
        this.servicioObtenerCupon = servicioObtenerCupon;
    }

    @Transactional
    public Cupon ejecutar(Long id) {
        return this.servicioObtenerCupon.ejecutar(id);
    }
}
