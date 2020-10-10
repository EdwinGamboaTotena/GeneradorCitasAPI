package adn.edwin.generadorcitasapi.infraestructura.controllador;

import adn.edwin.generadorcitasapi.aplicacion.comando.ComandoProducto;
import adn.edwin.generadorcitasapi.dominio.Producto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ControladorProducto {

    @PostMapping
    public void agregar(@RequestBody ComandoProducto comandoProducto) {
        //TODO agregar las llamadas a los manejadores
    }

    @GetMapping("/{id}")
    public Producto buscar(@PathVariable Long id) {
        //TODO agregar logica para traer un producto por el ID
        return null;
    }

    @GetMapping
    public List<Producto> listar() {
        //TODO agregar logica para traer todos los productos registrados
        return null;
    }
}
