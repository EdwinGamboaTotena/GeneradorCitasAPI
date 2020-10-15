package adn.edwin.generadorcitasapi.dominio.servicio.cita;

import adn.edwin.generadorcitasapi.dominio.Cita;
import adn.edwin.generadorcitasapi.dominio.Cupon;
import adn.edwin.generadorcitasapi.dominio.exception.CitaException;
import adn.edwin.generadorcitasapi.dominio.repositorio.RepositorioCita;
import adn.edwin.generadorcitasapi.dominio.servicio.cupon.ServicioEditarCupon;

import java.util.Calendar;
import java.util.Date;

public class ServicioAgregarCita {

    public static final String ID_NO_DEBE_ESTAR = "Si se quiere agregar una nueva cita el ID debe ser 0 o null.";
    public static final String FEHCA_SOLICITADA_ANTERIOR_FECHA_GENERADA =
            "La fecha a reservar no puede ser anteior o igual a la fecha en que se realizo la solicitud.";
    public static final String NO_SE_PUEDEN_RESERVAR_LOS_DOMINGOS =
            "No se pueden realizar reservas para el dia domingo";

    public static final String CUPON_NO_VALIDO = "El cupon ingresado no es valido.";

    private final RepositorioCita repositorioCita;
    private final ServicioEditarCupon servicioEditarCupon;

    public ServicioAgregarCita(RepositorioCita repositorioCita, ServicioEditarCupon servicioEditarCupon) {
        this.repositorioCita = repositorioCita;
        this.servicioEditarCupon = servicioEditarCupon;
    }

    public Cita ejecutar(Cita cita) {
        validarID(cita.getId());
        validarDiaHabil(cita.getFechaSolicitud());
        validarFechaSolicitud(cita.getFechaSolicitud(), cita.getFechaGeneracion());

        if (cita.getCuponUsado() != null) {
            validarCupon(cita.getCuponUsado());
            cita.getCuponUsado().setUsado(true);
            this.servicioEditarCupon.ejecutar(cita.getCuponUsado());
        }

        return this.repositorioCita.agregar(cita);
    }

    private void validarID(Long id) {
        if (id != null && id > 0)
            throw new CitaException(ID_NO_DEBE_ESTAR);
    }

    private void validarFechaSolicitud(Date fehcaSolicitud, Date fechaGeneracion) {
        if (fehcaSolicitud.before(fechaGeneracion) || fehcaSolicitud.equals(fechaGeneracion))
            throw new CitaException(FEHCA_SOLICITADA_ANTERIOR_FECHA_GENERADA);
    }

    private void validarDiaHabil(Date fechaReservar) {
        Calendar fechaSolicitud = Calendar.getInstance();
        fechaSolicitud.setTime(fechaReservar);

        if (fechaSolicitud.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
            throw new CitaException(NO_SE_PUEDEN_RESERVAR_LOS_DOMINGOS);
    }

    private void validarCupon(Cupon cupon) {
        if (cupon.getId() != null && cupon.isUsado())
            throw new CitaException(CUPON_NO_VALIDO);
    }
}
