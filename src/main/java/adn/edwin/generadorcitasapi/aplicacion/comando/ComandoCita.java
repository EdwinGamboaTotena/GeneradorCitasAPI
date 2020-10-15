package adn.edwin.generadorcitasapi.aplicacion.comando;

import adn.edwin.generadorcitasapi.dominio.Cupon;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ComandoCita {

    public static final String ERROR_PARSEANDO_FECHAS =
            "Ocurrio un error con el formato de las fechas.";
    private static final String DATE_FORMAT = "yyyy-MM-dd";

    private Long id;
    @JsonFormat(pattern = DATE_FORMAT)
    private Date fechaGeneracion;
    @JsonFormat(pattern = DATE_FORMAT)
    private Date fechaSolicitud;
    private ComandoProducto productoSolicitado;
    private Cupon cuponUsado;
    private String cedulaCliente;

    public ComandoCita(Long id, String fechaGeneracion, String fechaSolicitud, ComandoProducto productoSolicitado,
                       Cupon cuponUsado, String cedulaCliente) {
        this.id = id;
        try {
            this.fechaGeneracion = new SimpleDateFormat(DATE_FORMAT).parse(fechaGeneracion);
            this.fechaSolicitud = new SimpleDateFormat(DATE_FORMAT).parse(fechaSolicitud);
        } catch (ParseException parseException) {
            throw new RuntimeException(ERROR_PARSEANDO_FECHAS);
        }
        this.productoSolicitado = productoSolicitado;
        this.cuponUsado = cuponUsado;
        this.cedulaCliente = cedulaCliente;
    }

    public Date getFechaGeneracion() {
        return (Date) fechaGeneracion.clone();
    }

    public Long getId() {
        return id;
    }

    public Cupon getCuponUsado() {
        return cuponUsado;
    }

    public Date getFechaSolicitud() {
        return (Date) fechaSolicitud.clone();
    }

    public ComandoProducto getProductoSolicitado() {
        return productoSolicitado;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }
}
