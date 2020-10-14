package adn.edwin.generadorcitasapi.dominio.servicio.cita;

import adn.edwin.generadorcitasapi.dominio.Cita;
import adn.edwin.generadorcitasapi.dominio.exception.CitaException;
import adn.edwin.generadorcitasapi.dominio.repositorio.RepositorioCita;

import java.util.Calendar;
import java.util.Date;

public class ServicioAgregarCita {

    public static final String FEHCA_SOLICITADA_ANTERIOR_FECHA_GENERADA =
            "La fecha a reservar no puede ser anteior o igual a la fecha en que se realizo la solicitud.";
    public static final String NO_SE_PUEDEN_RESERVAR_LOS_DOMINGOS =
            "No se pueden realizar reservas para el dia domingo";

    private static final int DOMINGO = 0;

    private final RepositorioCita repositorioCita;

    public ServicioAgregarCita(RepositorioCita repositorioCita) {
        this.repositorioCita = repositorioCita;
    }

    public void ejecutar(Cita cita) {
        validarDiaHabil(cita.getFechaSolicitud());
        validarFechaSolicitud(cita.getFechaSolicitud(), cita.getFechaGeneracion());

        this.repositorioCita.agregar(cita);
    }

    public void validarFechaSolicitud(Date fehcaSolicitud, Date fechaGeneracion) {
        if (fehcaSolicitud.before(fechaGeneracion) || fehcaSolicitud.equals(fechaGeneracion))
            throw new CitaException(FEHCA_SOLICITADA_ANTERIOR_FECHA_GENERADA);

    }

    public void validarDiaHabil(Date fechaReservar) {
        Calendar fechaSolicitud = Calendar.getInstance();
        fechaSolicitud.setTime(fechaReservar);

        if (fechaSolicitud.get(Calendar.DAY_OF_WEEK) == DOMINGO)
            throw new CitaException(NO_SE_PUEDEN_RESERVAR_LOS_DOMINGOS);
    }
}
