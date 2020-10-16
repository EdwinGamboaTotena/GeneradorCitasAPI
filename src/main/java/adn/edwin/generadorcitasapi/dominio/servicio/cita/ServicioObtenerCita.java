package adn.edwin.generadorcitasapi.dominio.servicio.cita;

import adn.edwin.generadorcitasapi.dominio.Cita;
import adn.edwin.generadorcitasapi.dominio.exception.CitaException;
import adn.edwin.generadorcitasapi.dominio.repositorio.RepositorioCita;
import adn.edwin.generadorcitasapi.dominio.servicio.cupon.ServicioObtenerCuponConsumido;

public class ServicioObtenerCita {

    public static final String CITA_NO_ENCONTRADA = "Esta cita no se encuentra registrada.";

    private final RepositorioCita repositorioCita;

    private final ServicioObtenerCuponConsumido servicioObtenerCuponConsumido;

    public ServicioObtenerCita(RepositorioCita repositorioCita,
                               ServicioObtenerCuponConsumido servicioObtenerCuponConsumido) {
        this.repositorioCita = repositorioCita;
        this.servicioObtenerCuponConsumido = servicioObtenerCuponConsumido;
    }

    public Cita ejecutar(Long id) {
        Cita cita = this.repositorioCita.obtener(id);
        if (cita == null)
            throw new CitaException(CITA_NO_ENCONTRADA);
        cita.setCuponUsado(this.servicioObtenerCuponConsumido.ejecutar(cita));
        return cita;
    }
}
