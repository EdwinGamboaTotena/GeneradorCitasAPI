package adn.edwin.generadorcitasapi.dominio.servicio.cita;

import adn.edwin.generadorcitasapi.dominio.Cita;
import adn.edwin.generadorcitasapi.dominio.Cupon;
import adn.edwin.generadorcitasapi.dominio.exception.CitaException;
import adn.edwin.generadorcitasapi.dominio.repositorio.RepositorioCita;
import adn.edwin.generadorcitasapi.testdatabuilder.CitaTestDataBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

public class ServicioObtenerCitaTest {

    private static final Long ID_TEST = 90L;
    private static final String CEDULA_TEST = "123456";
    private static final Cupon CUPON_TEST = null;

    @Mock
    private RepositorioCita repositorioCita;

    @InjectMocks
    private ServicioObtenerCita servicioObtenerCita;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void obtenerCita() {
        //arange
        when(repositorioCita.obtener(ID_TEST))
                .thenReturn(new CitaTestDataBuilder().conId(ID_TEST).build());
        //act
        Cita citaBuscada = this.servicioObtenerCita.ejecutar(ID_TEST);
        //assert
        assertEquals(ID_TEST, citaBuscada.getId());
        assertEquals(CEDULA_TEST, citaBuscada.getCedulaCliente());
        assertEquals(CUPON_TEST, citaBuscada.getCuponUsado());
    }

    @Test
    public void obtenerCitaError() {
        //arange
        when(repositorioCita.obtener(ID_TEST)).thenReturn(null);
        try {
            //act
            this.servicioObtenerCita.ejecutar(ID_TEST);
            fail();
        } catch (CitaException citaException) {
            //assert
            assertEquals(ServicioObtenerCita.CITA_NO_ENCONTRADA, citaException.getMessage());
        }
    }

}
