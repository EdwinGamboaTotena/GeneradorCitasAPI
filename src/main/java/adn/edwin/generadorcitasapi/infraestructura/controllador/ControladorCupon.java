package adn.edwin.generadorcitasapi.infraestructura.controllador;

import adn.edwin.generadorcitasapi.dominio.Cupon;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cupon")
public class ControladorCupon {

    @GetMapping("/{id}")
    public Cupon  buscar(@PathVariable Long id) {
        //TODO agregar logica para traer un cupon por el ID
        return null;
    }
}
