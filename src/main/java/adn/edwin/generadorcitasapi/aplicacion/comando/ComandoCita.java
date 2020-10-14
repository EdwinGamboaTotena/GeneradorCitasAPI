package adn.edwin.generadorcitasapi.aplicacion.comando;

import adn.edwin.generadorcitasapi.dominio.Cupon;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ComandoCita {

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    private Long id;
    @JsonFormat(pattern = DATE_FORMAT)
    private Date fechaGeneracion;
    @JsonFormat(pattern = DATE_FORMAT)
    private Date fechaSolicitud;
    private ComandoProducto productoSolicitado;
    private Cupon cuponUsado;
    private String cedulaCliente;

    public ComandoCita(Long id, Date fechaGeneracion, Date fechaSolicitud, ComandoProducto productoSolicitado,
                       Cupon cuponUsado, String cedulaCliente) {
        this.id = id;
        this.fechaGeneracion = fechaGeneracion;
        this.fechaSolicitud = fechaSolicitud;
        this.productoSolicitado = productoSolicitado;
        this.cuponUsado = cuponUsado;
        this.cedulaCliente = cedulaCliente;
    }

    public Date getFechaGeneracion() {
        return fechaGeneracion;
    }

    public Long getId() {
        return id;
    }

    public Cupon getCuponUsado() {
        return cuponUsado;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public ComandoProducto getProductoSolicitado() {
        return productoSolicitado;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }
}
