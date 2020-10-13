package adn.edwin.generadorcitasapi.infraestructura.controllador;

import adn.edwin.generadorcitasapi.aplicacion.manejadores.cupon.ManejadorObtenerCupon;
import adn.edwin.generadorcitasapi.dominio.Cupon;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cupon")
public class ControladorCupon {

    private final ManejadorObtenerCupon manejadorObtenerCupon;

    public ControladorCupon(ManejadorObtenerCupon manejadorObtenerCupon) {
        this.manejadorObtenerCupon = manejadorObtenerCupon;
    }

    @GetMapping("/{id}")
    public Cupon buscar(@PathVariable Long id) {
        return this.manejadorObtenerCupon.ejecutar(id);
    }
}
