package adn.edwin.generadorcitasapi.dominio.servicio.cita;

import adn.edwin.generadorcitasapi.dominio.Cita;
import adn.edwin.generadorcitasapi.dominio.exception.CitaException;
import adn.edwin.generadorcitasapi.dominio.repositorio.RepositorioCita;
import adn.edwin.generadorcitasapi.dominio.servicio.cita.ServicioAgregarCita;
import adn.edwin.generadorcitasapi.testdatabuilder.CitaTestDataBuilder;
import adn.edwin.generadorcitasapi.testdatabuilder.CuponTestDataBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ServicioAgregarCitaTest {

    private static final Long ID_TEST = 21L;
    private static final String FECHA_GENERACION = "2020-10-09";
    private static final String FECHA_SOLICITUD_TEST = "2020-10-10";

    private static final String FECHA_SOLICITUD_ANTERIOR = "2020-09-09";
    private static final String FECHA_SOLICITUD_DOMINGO = "2020-10-18";

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
            servicioAgregarCita.ejecutar(cita);
            fail();
        } catch (CitaException citaException) {
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
            servicioAgregarCita.ejecutar(cita);
            fail();
        } catch (CitaException citaException) {
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
            servicioAgregarCita.ejecutar(cita);
            fail();
        } catch (CitaException citaException) {
            assertEquals(ServicioAgregarCita.EL_CUPON_YA_ESTA_USADO,
                    citaException.getMessage());
        }
    }

}
