package adn.edwin.generadorcitasapi.aplicacion.comando;

import adn.edwin.generadorcitasapi.dominio.Cupon;
import adn.edwin.generadorcitasapi.dominio.Producto;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ComandoCita {

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    private Long id;
    @JsonFormat(pattern = DATE_FORMAT)
    private Date fechaGeneracion;
    @JsonFormat(pattern = DATE_FORMAT)
    private Date fehcaSolicitud;
    private ComandoProducto productoSolicitado;
    private Cupon cuponUsado;
    private String cedulaCliente;

    public ComandoCita(Long id, Date fechaGeneracion, Date fehcaSolicitud, ComandoProducto productoSolicitado,
                       Cupon cuponUsado, String cedulaCliente, double precioProducto) {
        this.id = id;
        this.fechaGeneracion = fechaGeneracion;
        this.fehcaSolicitud = fehcaSolicitud;
        this.productoSolicitado = productoSolicitado;
        this.cuponUsado = cuponUsado;
        this.cedulaCliente = cedulaCliente;
    }

    public Long getId() {
        return id;
    }

    public Date getFechaGeneracion() {
        return fechaGeneracion;
    }

    public Date getFehcaSolicitud() {
        return fehcaSolicitud;
    }

    public ComandoProducto getProductoSolicitado() {
        return productoSolicitado;
    }

    public Cupon getCuponUsado() {
        return cuponUsado;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }
}