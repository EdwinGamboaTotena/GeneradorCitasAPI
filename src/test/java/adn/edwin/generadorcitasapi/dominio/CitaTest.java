package adn.edwin.generadorcitasapi.dominio;

import adn.edwin.generadorcitasapi.dominio.exception.CitaException;
import adn.edwin.generadorcitasapi.testdatabuilder.CitaTestDataBuilder;
import adn.edwin.generadorcitasapi.testdatabuilder.CuponTestDataBuilder;
import adn.edwin.generadorcitasapi.testdatabuilder.ProductoTestDataBuilder;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CitaTest {

    private static final String FORMATO_FECHA = "yyyy-MM-dd";
    private static final String FECHA_GENERACION = "2020-10-09";
    private static final String FECHA_SOLICITUD = "2020-11-09";
    private static final Producto PRODUCTO = new ProductoTestDataBuilder().build();
    private static final Cupon CUPON = new CuponTestDataBuilder().build();
    private static final Cupon CUPON_NULL = null;
    private static final String CEDULA = "123456";
    private static final double PRECIO_PRODUCTO = PRODUCTO.getPrecio();

    private static final String CEDULA_VACIA = "";
    private static final String FECHA_SOLICITUD_ANTERIOR = "2020-09-09";

    @Test
    public void crearCitaSinCupon() {
        //arange
        CitaTestDataBuilder citaTestDataBuilder = new CitaTestDataBuilder()
                .conCedula(CEDULA).conProducto(PRODUCTO)
                .conFechaGeneracion(FECHA_GENERACION).conFechaSolicitud(FECHA_SOLICITUD);
        //act
        Cita cita = citaTestDataBuilder.build();
        DateFormat dateFormat = new SimpleDateFormat(FORMATO_FECHA);
        String fechaGeneracion = dateFormat.format(cita.getFechaGeneracion());
        String fechaSolicitud = dateFormat.format(cita.getFehcaSolicitud());
        //assert
        assertEquals(CEDULA, cita.getCedulaCliente());
        assertEquals(PRODUCTO, cita.getProductoSolicitado());
        assertEquals(PRECIO_PRODUCTO, cita.getPrecioProducto(), 0);
        assertEquals(CUPON_NULL, cita.getCuponUsado());
        assertEquals(FECHA_GENERACION, fechaGeneracion);
        assertEquals(FECHA_SOLICITUD, fechaSolicitud);
    }

    @Test
    public void crearCitaConCupon() {
        //arange
        CitaTestDataBuilder citaTestDataBuilder = new CitaTestDataBuilder()
                .conCedula(CEDULA).conProducto(PRODUCTO).conCupon(CUPON)
                .conFechaGeneracion(FECHA_GENERACION).conFechaSolicitud(FECHA_SOLICITUD);
        //act
        Cita cita = citaTestDataBuilder.build();
        DateFormat dateFormat = new SimpleDateFormat(FORMATO_FECHA);
        String fechaGeneracion = dateFormat.format(cita.getFechaGeneracion());
        String fechaSolicitud = dateFormat.format(cita.getFehcaSolicitud());
        //assert
        assertEquals(CEDULA, cita.getCedulaCliente());
        assertEquals(PRODUCTO, cita.getProductoSolicitado());
        assertEquals(PRECIO_PRODUCTO, cita.getPrecioProducto(), 0);
        assertEquals(CUPON, cita.getCuponUsado());
        assertEquals(FECHA_GENERACION, fechaGeneracion);
        assertEquals(FECHA_SOLICITUD, fechaSolicitud);
    }

    @Test
    public void citaCedulaVacia() {
        //arange
        CitaTestDataBuilder citaTestDataBuilder = new CitaTestDataBuilder()
                .conCedula(CEDULA_VACIA);
        //act
        try {
            Cita cita = citaTestDataBuilder.build();
            fail();
        } catch (CitaException citaException) {
            assertEquals(Cita.CEDULA_OBLIGATORIA, citaException.getMessage());
        }
    }

    @Test
    public void citaFechaSolicitudAnterior() {
        //arange
        CitaTestDataBuilder citaTestDataBuilder = new CitaTestDataBuilder()
                .conFechaSolicitud(FECHA_SOLICITUD_ANTERIOR);
        //act
        try {
            Cita cita = citaTestDataBuilder.build();
            fail();
        } catch (CitaException citaException) {
            assertEquals(Cita.FEHCA_SOLICITADA_ANTERIOR_FECHA_GENERADA, citaException.getMessage());
        }
    }
}
