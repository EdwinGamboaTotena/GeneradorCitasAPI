package adn.edwin.generadorcitasapi.aplicacion.manejadores.cita;

import adn.edwin.generadorcitasapi.dominio.Cita;
import adn.edwin.generadorcitasapi.dominio.servicio.cita.ServicioListarCitas;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ManejadorListarCitas {

    private final ServicioListarCitas servicioListarCitas;

    public ManejadorListarCitas(ServicioListarCitas servicioListarCitas) {
        this.servicioListarCitas = servicioListarCitas;
    }

    @Transactional
    public List<Cita> ejecutar() {
        return this.servicioListarCitas.ejecutar();
    }
}
