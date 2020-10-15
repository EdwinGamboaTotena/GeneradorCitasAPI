package adn.edwin.generadorcitasapi.aplicacion.manejadores.cita;

import adn.edwin.generadorcitasapi.aplicacion.comando.ComandoCita;
import adn.edwin.generadorcitasapi.aplicacion.fabrica.FabricaCita;
import adn.edwin.generadorcitasapi.dominio.Cita;
import adn.edwin.generadorcitasapi.dominio.Cupon;
import adn.edwin.generadorcitasapi.dominio.servicio.cita.ServicioAgregarCita;
import adn.edwin.generadorcitasapi.dominio.servicio.cupon.ServicioAgregarCupon;
import adn.edwin.generadorcitasapi.dominio.servicio.cupon.ServicioObtenerCupon;
import adn.edwin.generadorcitasapi.dominio.servicio.producto.ServicioObtenerProducto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ManejadorAgregarCita {

    private final ServicioAgregarCita servicioAgregarCita;
    private final FabricaCita fabricaCita;

    private final ServicioObtenerProducto servicioObtenerProducto;
    private final ServicioObtenerCupon servicioObtenerCupon;

    private final ServicioAgregarCupon servicioAgregarCupon;

    public ManejadorAgregarCita(ServicioAgregarCita servicioAgregarCita, FabricaCita fabricaCita,
                                ServicioObtenerProducto servicioObtenerProducto,
                                ServicioObtenerCupon servicioObtenerCupon,
                                ServicioAgregarCupon servicioAgregarCupon) {
        this.servicioAgregarCita = servicioAgregarCita;
        this.fabricaCita = fabricaCita;
        this.servicioObtenerProducto = servicioObtenerProducto;
        this.servicioObtenerCupon = servicioObtenerCupon;
        this.servicioAgregarCupon = servicioAgregarCupon;
    }

    @Transactional
    public Cita ejecutar(ComandoCita comandoCita) {
        Cita cita = this.fabricaCita.crearCita(comandoCita);
        cita.setProductoSolicitado(this.servicioObtenerProducto.ejecutar(cita.getProductoSolicitado().getId()));

        if (cita.getCuponUsado() != null)
            cita.setCuponUsado(this.servicioObtenerCupon.ejecutar(cita.getCuponUsado().getId()));

        cita = this.servicioAgregarCita.ejecutar(cita);

        if (cita.getCuponUsado() == null && cita.getProductoSolicitado().isGeneraCupo()) {
            Cupon nuevoCunpon = this.servicioAgregarCupon.ejecutar(new Cupon(null,
                    cita.getProductoSolicitado().getPorcetajeCuponGenerar(), cita, false));
        }

        return cita;
    }
}
