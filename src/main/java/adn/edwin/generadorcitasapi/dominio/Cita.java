package adn.edwin.generadorcitasapi.dominio;

import adn.edwin.generadorcitasapi.dominio.exception.CitaException;

import java.util.Date;

public class Cita {

    public static final String CEDULA_OBLIGATORIA = "La cedula del cliente es obligatoria.";

    private Long id;
    private Date fechaGeneracion;
    private Date fehcaSolicitud;
    private Producto productoSolicitado;
    private Cupon cuponUsado;
    private String cedulaCliente;
    private double precioProducto;

    public Cita(Long id, Date fechaGeneracion, Date fehcaSolicitud, Producto productoSolicitado,
                Cupon cuponUsado, String cedulaCliente, double precioProducto) {
        validarCedula(cedulaCliente);
        this.id = id;
        this.fechaGeneracion = fechaGeneracion;
        this.fehcaSolicitud = fehcaSolicitud;
        this.productoSolicitado = productoSolicitado;
        this.cuponUsado = cuponUsado;
        this.cedulaCliente = cedulaCliente;
        this.precioProducto = precioProducto;
    }

    private void validarCedula(String cedula) {
        if (cedula == null || cedula.trim().length() == 0) {
            throw new CitaException(CEDULA_OBLIGATORIA);
        }
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

    public Producto getProductoSolicitado() {
        return productoSolicitado;
    }

    public Cupon getCuponUsado() {
        return cuponUsado;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }
}
