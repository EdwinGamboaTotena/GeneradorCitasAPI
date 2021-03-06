package adn.edwin.generadorcitasapi.dominio.servicio.cita;

import adn.edwin.generadorcitasapi.dominio.Cita;
import adn.edwin.generadorcitasapi.dominio.Cupon;
import adn.edwin.generadorcitasapi.dominio.Producto;
import adn.edwin.generadorcitasapi.dominio.exception.CitaException;
import adn.edwin.generadorcitasapi.dominio.repositorio.RepositorioCita;
import adn.edwin.generadorcitasapi.dominio.servicio.cupon.ServicioAgregarCupon;
import adn.edwin.generadorcitasapi.dominio.servicio.cupon.ServicioEditarCupon;
import adn.edwin.generadorcitasapi.testdatabuilder.CitaTestDataBuilder;
import adn.edwin.generadorcitasapi.testdatabuilder.CuponTestDataBuilder;
import adn.edwin.generadorcitasapi.testdatabuilder.ProductoTestDataBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class ServicioAgregarCitaTest {

    private static final Long ID_TEST = 21L;
    private static final String FECHA_GENERACION = "2020-10-09";
    private static final String FECHA_SOLICITUD_TEST = "2020-10-10";

    private static final String FECHA_SOLICITUD_ANTERIOR = "2020-09-09";
    private static final String FECHA_SOLICITUD_DOMINGO = "2020-10-18";

    private static final Producto PRODUCTO = new ProductoTestDataBuilder().build();
    private static final Cupon CUPON = new CuponTestDataBuilder().build();

    private static final Producto PRODUCTO_NO_GENERA_CUPON =
            new ProductoTestDataBuilder().conGeneradorCupon(false).build();

    @Mock
    private ServicioEditarCupon servicioEditarCupon;

    @Mock
    private ServicioAgregarCupon servicioAgregarCupon;

    @Mock
    private RepositorioCita repositorioCita;

    @InjectMocks
    private ServicioAgregarCita servicioAgregarCita;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void citaFechaSolicitudAnterior() {
        //arange
        CitaTestDataBuilder citaTestDataBuilder = new CitaTestDataBuilder()
                .conId(null)
                .conFechaGeneracion(FECHA_GENERACION)
                .conFechaSolicitud(FECHA_SOLICITUD_ANTERIOR);
        Cita cita = citaTestDataBuilder.build();
        //act
        try {
            this.servicioAgregarCita.ejecutar(cita);
            fail();
        } catch (CitaException citaException) {
            //assert
            assertEquals(ServicioAgregarCita.FEHCA_SOLICITADA_ANTERIOR_FECHA_GENERADA,
                    citaException.getMessage());
        }
    }

    @Test
    public void agregarCitaError() {
        //arange
        CitaTestDataBuilder citaTestDataBuilder = new CitaTestDataBuilder()
                .conId(ID_TEST);
        //act
        Cita cita = citaTestDataBuilder.build();
        try {
            this.servicioAgregarCita.ejecutar(cita);
            fail();
        } catch (CitaException citaException) {
            //assert
            assertEquals(ServicioAgregarCita.ID_NO_DEBE_ESTAR, citaException.getMessage());
        }
    }

    @Test
    public void citaFechaSolicitudDomingo() {
        //arange
        CitaTestDataBuilder citaTestDataBuilder = new CitaTestDataBuilder()
                .conId(null)
                .conFechaGeneracion(FECHA_GENERACION)
                .conFechaSolicitud(FECHA_SOLICITUD_DOMINGO);
        Cita cita = citaTestDataBuilder.build();
        //act
        try {
            this.servicioAgregarCita.ejecutar(cita);
            fail();
        } catch (CitaException citaException) {
            //assert
            assertEquals(ServicioAgregarCita.NO_SE_PUEDEN_RESERVAR_LOS_DOMINGOS,
                    citaException.getMessage());
        }
    }

    @Test
    public void citaConCuponUsado() {
        //arange
        CitaTestDataBuilder citaTestDataBuilder = new CitaTestDataBuilder()
                .conId(null)
                .conFechaGeneracion(FECHA_GENERACION)
                .conFechaSolicitud(FECHA_SOLICITUD_TEST)
                .conCupon(new CuponTestDataBuilder().conInformacionUsado(true).build());
        Cita cita = citaTestDataBuilder.build();
        //act
        try {
            this.servicioAgregarCita.ejecutar(cita);
            fail();
        } catch (CitaException citaException) {
            //assert
            assertEquals(ServicioAgregarCita.CUPON_NO_VALIDO,
                    citaException.getMessage());
        }
    }

    @Test
    public void agregarCita() {
        //arange
        CitaTestDataBuilder citaTestDataBuilder = new CitaTestDataBuilder()
                .conId(null).conCupon(null).conProducto(PRODUCTO_NO_GENERA_CUPON)
                .conFechaGeneracion(FECHA_GENERACION)
                .conFechaSolicitud(FECHA_SOLICITUD_TEST);
        //act
        Cita citaNueva = citaTestDataBuilder.build();
        when(repositorioCita.agregar(citaNueva))
                .thenReturn(new CitaTestDataBuilder()
                        .conId(ID_TEST).conCupon(null).conProducto(PRODUCTO_NO_GENERA_CUPON)
                        .conFechaGeneracion(FECHA_GENERACION)
                        .conFechaSolicitud(FECHA_SOLICITUD_TEST).build());
        Cita citaPersistida = this.servicioAgregarCita.ejecutar(citaNueva);
        //assert
        assertNotNull(citaPersistida.getId());
        assertEquals(citaNueva.getCedulaCliente(), citaPersistida.getCedulaCliente());
        assertEquals(citaNueva.getFechaSolicitud(), citaPersistida.getFechaSolicitud());
        assertEquals(citaNueva.getPrecioProducto(), citaPersistida.getPrecioProducto(), 0);
    }

    @Test
    public void agregarCitaConCupon() {
        //arange
        CitaTestDataBuilder citaTestDataBuilder = new CitaTestDataBuilder()
                .conId(null).conCupon(CUPON).conProducto(PRODUCTO)
                .conFechaGeneracion(FECHA_GENERACION)
                .conFechaSolicitud(FECHA_SOLICITUD_TEST);
        //act
        Cita citaNueva = citaTestDataBuilder.build();
        when(servicioEditarCupon.ejecutar(citaNueva.getCuponUsado(), citaNueva)).thenReturn(citaNueva.getCuponUsado());
        when(repositorioCita.agregar(citaNueva))
                .thenReturn(new CitaTestDataBuilder()
                        .conId(ID_TEST).conCupon(citaNueva.getCuponUsado()).conProducto(PRODUCTO)
                        .conFechaGeneracion(FECHA_GENERACION)
                        .conFechaSolicitud(FECHA_SOLICITUD_TEST).build());
        Cita citaPersistida = this.servicioAgregarCita.ejecutar(citaNueva);
        //assert
        assertNotNull(citaPersistida.getId());
        assertEquals(citaNueva.getCedulaCliente(), citaPersistida.getCedulaCliente());
        assertEquals(citaNueva.getFechaSolicitud(), citaPersistida.getFechaSolicitud());
        assertEquals(citaNueva.getPrecioProducto(), citaPersistida.getPrecioProducto(), 0);
        assertTrue(citaPersistida.getCuponUsado().isUsado());
    }

    @Test
    public void agregarCitaCreandoCupon() {
        //arange
        CitaTestDataBuilder citaTestDataBuilder = new CitaTestDataBuilder()
                .conId(null).conCupon(null).conProducto(PRODUCTO)
                .conFechaGeneracion(FECHA_GENERACION)
                .conFechaSolicitud(FECHA_SOLICITUD_TEST);
        //act
        Cita citaNueva = citaTestDataBuilder.build();
        Cupon cuponCreado = new CuponTestDataBuilder()
                .conId(CUPON.getId()).conInformacionUsado(false)
                .conCitaGenerador(citaNueva)
                .conPorcentajeDescuento(citaNueva.getProductoSolicitado()
                        .getPorcetajeCuponGenerar())
                .build();
        when(repositorioCita.agregar(citaNueva))
                .thenReturn(new CitaTestDataBuilder()
                        .conId(ID_TEST).conCupon(null).conProducto(PRODUCTO)
                        .conFechaGeneracion(FECHA_GENERACION)
                        .conFechaSolicitud(FECHA_SOLICITUD_TEST).build());
        when(servicioAgregarCupon.ejecutar(citaNueva.getCuponUsado())).thenReturn(cuponCreado);
        Cita citaPersistida = this.servicioAgregarCita.ejecutar(citaNueva);
        //assert
        assertNotNull(citaPersistida.getId());
        assertEquals(citaNueva.getCedulaCliente(), citaPersistida.getCedulaCliente());
        assertEquals(citaNueva.getFechaSolicitud(), citaPersistida.getFechaSolicitud());
        assertEquals(citaNueva.getPrecioProducto(), citaPersistida.getPrecioProducto(), 0);
        assertNull(citaPersistida.getCuponUsado());
    }

}
