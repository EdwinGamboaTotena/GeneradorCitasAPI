package adn.edwin.generadorcitasapi.infraestructura.controlador;

import adn.edwin.generadorcitasapi.aplicacion.comando.ComandoProducto;
import adn.edwin.generadorcitasapi.aplicacion.manejadores.producto.ManejadorAgregarProducto;
import adn.edwin.generadorcitasapi.aplicacion.manejadores.producto.ManejadorListarProductos;
import adn.edwin.generadorcitasapi.aplicacion.manejadores.producto.ManejadorObtenerProducto;
import adn.edwin.generadorcitasapi.dominio.Producto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class ControladorProducto {

    private final ManejadorObtenerProducto manejadorObtenerProducto;
    private final ManejadorListarProductos manejadorListarProductos;
    private final ManejadorAgregarProducto manejadorAgregarProducto;

    public ControladorProducto(ManejadorObtenerProducto manejadorObtenerProducto,
                               ManejadorListarProductos manejadorListarProductos,
                               ManejadorAgregarProducto manejadorAgregarProducto) {
        this.manejadorObtenerProducto = manejadorObtenerProducto;
        this.manejadorListarProductos = manejadorListarProductos;
        this.manejadorAgregarProducto = manejadorAgregarProducto;
    }

    @PostMapping
    public Producto agregar(@RequestBody ComandoProducto comandoProducto) {
        return this.manejadorAgregarProducto.ejecutar(comandoProducto);
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
