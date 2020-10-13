package adn.edwin.generadorcitasapi.aplicacion.manejadores.cita;

import adn.edwin.generadorcitasapi.aplicacion.comando.ComandoCita;
import adn.edwin.generadorcitasapi.aplicacion.fabrica.FabricaCita;
import adn.edwin.generadorcitasapi.dominio.servicio.cita.ServicioAgregarCita;
import org.springframework.stereotype.Service;

@Service
public class ManejadorAgregarCita {

    private final ServicioAgregarCita servicioAgregarCita;
    private final FabricaCita fabricaCita;

    public ManejadorAgregarCita(ServicioAgregarCita servicioAgregarCita,
                                FabricaCita fabricaCita) {
        this.servicioAgregarCita = servicioAgregarCita;
        this.fabricaCita = fabricaCita;
    }

    public void ejecutar(ComandoCita comandoCita) {
        this.servicioAgregarCita.ejecutar(this.fabricaCita.crearCita(comandoCita));
    }
}
