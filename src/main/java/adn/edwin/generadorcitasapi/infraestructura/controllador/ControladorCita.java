package adn.edwin.generadorcitasapi.infraestructura.controllador;

import adn.edwin.generadorcitasapi.aplicacion.comando.ComandoCita;
import adn.edwin.generadorcitasapi.dominio.Cita;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cita")
public class ControladorCita {

    @PostMapping
    public void agregar(@RequestBody ComandoCita comandoCita) {
        //TODO agregar las llamadas a los manejadores
    }

    @GetMapping("/{id}")
    public Cita buscar(@PathVariable Long id) {
        //TODO agregar logica para traer una cita por el ID
        return null;
    }

    @GetMapping
    public List<Cita> listar() {
        //TODO agregar logica para traer todas las citas registradas
        return null;
    }
}
