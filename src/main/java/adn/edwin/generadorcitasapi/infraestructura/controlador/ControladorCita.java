package adn.edwin.generadorcitasapi.infraestructura.controlador;

import adn.edwin.generadorcitasapi.aplicacion.comando.ComandoCita;
import adn.edwin.generadorcitasapi.aplicacion.manejadores.cita.ManejadorAgregarCita;
import adn.edwin.generadorcitasapi.aplicacion.manejadores.cita.ManejadorListarCitas;
import adn.edwin.generadorcitasapi.aplicacion.manejadores.cita.ManejadorObtenerCita;
import adn.edwin.generadorcitasapi.dominio.Cita;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cita")
public class ControladorCita {

    private final ManejadorObtenerCita manejadorObtenerCita;
    private final ManejadorListarCitas manejadorListarCitas;
    private final ManejadorAgregarCita manejadorAgregarCita;

    public ControladorCita(ManejadorObtenerCita manejadorObtenerCita,
                           ManejadorListarCitas manejadorListarCitas,
                           ManejadorAgregarCita manejadorAgregarCita) {
        this.manejadorObtenerCita = manejadorObtenerCita;
        this.manejadorListarCitas = manejadorListarCitas;
        this.manejadorAgregarCita = manejadorAgregarCita;
    }

    @PostMapping
    public Cita agregar(@RequestBody ComandoCita comandoCita) {
        return this.manejadorAgregarCita.ejecutar(comandoCita);
    }

    @GetMapping("/{id}")
    public Cita buscar(@PathVariable Long id) {
        return this.manejadorObtenerCita.ejecutar(id);
    }

    @GetMapping
    public List<Cita> listar() {
        return this.manejadorListarCitas.ejecutar();
    }
}
