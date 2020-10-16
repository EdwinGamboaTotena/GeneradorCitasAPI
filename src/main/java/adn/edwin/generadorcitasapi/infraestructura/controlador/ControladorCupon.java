package adn.edwin.generadorcitasapi.infraestructura.controlador;

import adn.edwin.generadorcitasapi.aplicacion.manejadores.cupon.ManejadorObtenerCupon;
import adn.edwin.generadorcitasapi.aplicacion.manejadores.cupon.ManejadorObtenerCuponPorIdCita;
import adn.edwin.generadorcitasapi.dominio.Cupon;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cupon")
public class ControladorCupon {

    private final ManejadorObtenerCupon manejadorObtenerCupon;
    private final ManejadorObtenerCuponPorIdCita manejadorObtenerCuponPorIdCita;

    public ControladorCupon(ManejadorObtenerCupon manejadorObtenerCupon,
                            ManejadorObtenerCuponPorIdCita manejadorObtenerCuponPorIdCita) {
        this.manejadorObtenerCupon = manejadorObtenerCupon;
        this.manejadorObtenerCuponPorIdCita = manejadorObtenerCuponPorIdCita;
    }

    @GetMapping("id/{id}")
    public Cupon buscar(@PathVariable Long id) {
        return this.manejadorObtenerCupon.ejecutar(id);
    }

    @GetMapping("id_cita_generadora/{id}")
    public Cupon buscarPorCitaGeneradora(@PathVariable Long id) {
        return this.manejadorObtenerCuponPorIdCita.ejecutar(id);
    }
}
