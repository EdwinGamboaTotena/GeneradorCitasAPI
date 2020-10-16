package adn.edwin.generadorcitasapi.testdatabuilder;

import adn.edwin.generadorcitasapi.aplicacion.comando.ComandoCita;
import adn.edwin.generadorcitasapi.aplicacion.comando.ComandoProducto;
import adn.edwin.generadorcitasapi.dominio.Cita;
import adn.edwin.generadorcitasapi.dominio.Cupon;
import adn.edwin.generadorcitasapi.dominio.Producto;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CitaTestDataBuilder {

    private static final String FORMATO_FECHA = "yyyy-MM-dd";
    private static final String FECHA_GENERACION = "2020-10-09";
    private static final String FECHA_SOLICITUD = "2020-11-09";
    private static final Long ID = 25L;
    private static final Producto PRODUCTO = new ProductoTestDataBuilder().build();
    private static final ComandoProducto COMANDO_PRODUCTO = new ProductoTestDataBuilder().buildComando();
    private static final Cupon CUPON = null;
    private static final String CEDULA = "123456";
    private static final double PRECIO_PRODUCTO = PRODUCTO.getPrecio();

    private Date fechaGeneracion;
    private Date fehcaSolicitud;
    private Long id;
    private Producto productoSolicitado;
    private Cupon cuponUsado;
    private String cedulaCliente;
    private double precioProducto;
    private ComandoProducto comandoProducto;

    public CitaTestDataBuilder() {
        try {
            this.fechaGeneracion = new SimpleDateFormat(FORMATO_FECHA).parse(FECHA_GENERACION);
            this.fehcaSolicitud = new SimpleDateFormat(FORMATO_FECHA).parse(FECHA_SOLICITUD);
        } catch (ParseException parseException) {
            System.out.println(parseException);
        }
        this.id = ID;
        this.productoSolicitado = PRODUCTO;
        this.precioProducto = PRECIO_PRODUCTO;
        this.cuponUsado = CUPON;
        this.cedulaCliente = CEDULA;
        this.comandoProducto = COMANDO_PRODUCTO;
    }

    public CitaTestDataBuilder conFechaGeneracion(String fechaGeneracion) {
        try {
            this.fechaGeneracion = new SimpleDateFormat(FORMATO_FECHA).parse(fechaGeneracion);
        } catch (ParseException parseException) {
            System.out.println(parseException);
        }
        return this;
    }

    public CitaTestDataBuilder conFechaSolicitud(String fehcaSolicitud) {
        try {
            this.fehcaSolicitud = new SimpleDateFormat(FORMATO_FECHA).parse(fehcaSolicitud);
        } catch (ParseException parseException) {
            System.out.println(parseException);
        }
        return this;
    }

    public CitaTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public CitaTestDataBuilder conProducto(Producto producto) {
        this.productoSolicitado = producto;
        this.precioProducto = producto.getPrecio();
        return this;
    }

    public CitaTestDataBuilder conComandoProducto(ComandoProducto comandoProducto) {
        this.comandoProducto = comandoProducto;
        this.precioProducto = comandoProducto.getPrecio();
        return this;
    }

    public CitaTestDataBuilder conCupon(Cupon cupon) {
        this.cuponUsado = cupon;
        return this;
    }

    public CitaTestDataBuilder conCedula(String cedula) {
        this.cedulaCliente = cedula;
        return this;
    }

    public Cita build() {
        return new Cita(id, fechaGeneracion, fehcaSolicitud, productoSolicitado, cuponUsado,
                cedulaCliente, precioProducto);
    }

    public ComandoCita buildComando() {
        DateFormat dateFormat = new SimpleDateFormat(FORMATO_FECHA);
        return new ComandoCita(id, dateFormat.format(fechaGeneracion), dateFormat.format(fehcaSolicitud), comandoProducto, cuponUsado,
                cedulaCliente);
    }

}
