package adn.edwin.generadorcitasapi.aplicacion.manejadores.cupon;

import adn.edwin.generadorcitasapi.dominio.Cita;
import adn.edwin.generadorcitasapi.dominio.Cupon;
import adn.edwin.generadorcitasapi.dominio.servicio.cita.ServicioObtenerCita;
import adn.edwin.generadorcitasapi.dominio.servicio.cupon.ServicioObtenerCuponPorCita;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ManejadorObtenerCuponPorIdCita {

    private final ServicioObtenerCuponPorCita servicioObtenerCuponPorCita;
    private final ServicioObtenerCita servicioObtenerCita;

    public ManejadorObtenerCuponPorIdCita(ServicioObtenerCuponPorCita servicioObtenerCuponPorCita,
                                          ServicioObtenerCita servicioObtenerCita) {
        this.servicioObtenerCuponPorCita = servicioObtenerCuponPorCita;
        this.servicioObtenerCita = servicioObtenerCita;
    }

    @Transactional
    public Cupon ejecutar(Long id) {
        Cita citaGeneradora = this.servicioObtenerCita.ejecutar(id);
        return this.servicioObtenerCuponPorCita.ejecutar(citaGeneradora);
    }
}
