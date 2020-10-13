package adn.edwin.generadorcitasapi.dominio.servicio;

import adn.edwin.generadorcitasapi.dominio.Cita;
import adn.edwin.generadorcitasapi.dominio.exception.CitaException;
import adn.edwin.generadorcitasapi.dominio.repositorio.RepositorioCita;
import adn.edwin.generadorcitasapi.dominio.servicio.cita.ServicioAgregarCita;
import adn.edwin.generadorcitasapi.testdatabuilder.CitaTestDataBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ServicioAgregarCitaTest {

    private static final String FECHA_GENERACION = "2020-10-09";
    private static final String FECHA_SOLICITUD_ANTERIOR = "2020-09-09";

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
}