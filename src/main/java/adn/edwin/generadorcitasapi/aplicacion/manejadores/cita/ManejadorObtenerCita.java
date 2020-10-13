package adn.edwin.generadorcitasapi.aplicacion.manejadores.cita;

import adn.edwin.generadorcitasapi.dominio.Cita;
import adn.edwin.generadorcitasapi.dominio.servicio.cita.ServicioObtenerCita;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ManejadorObtenerCita {

    private final ServicioObtenerCita servicioObtenerCita;

    public ManejadorObtenerCita(ServicioObtenerCita servicioObtenerCita) {
        this.servicioObtenerCita = servicioObtenerCita;
    }

    @Transactional
    public Cita ejecutar(Long id) {
        return this.servicioObtenerCita.ejecutar(id);
    }
}
