package adn.edwin.generadorcitasapi.infraestructura.controllador;

import adn.edwin.generadorcitasapi.aplicacion.comando.ComandoProducto;
import adn.edwin.generadorcitasapi.aplicacion.manejadores.producto.ManejadorListarProductos;
import adn.edwin.generadorcitasapi.aplicacion.manejadores.producto.ManejadorObtenerProducto;
import adn.edwin.generadorcitasapi.dominio.Producto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ControladorProducto {

    private final ManejadorObtenerProducto manejadorObtenerProducto;
    private final ManejadorListarProductos manejadorListarProductos;

    public ControladorProducto(ManejadorObtenerProducto manejadorObtenerProducto,
                               ManejadorListarProductos manejadorListarProductos) {
        this.manejadorObtenerProducto = manejadorObtenerProducto;
        this.manejadorListarProductos = manejadorListarProductos;
    }

    @PostMapping
    public void agregar(@RequestBody ComandoProducto comandoProducto) {
        //TODO agregar las llamadas a los manejadores
    }

    @GetMapping("/{id}")
    public Producto buscar(@PathVariable Long id) {
        return this.manejadorObtenerProducto.ejecutar(id);
    }

    @GetMapping
    public List<Producto> listar() {
        return this.manejadorListarProductos.ejecutar();
    }
}
