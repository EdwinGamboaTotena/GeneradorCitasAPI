package adn.edwin.generadorcitasapi.dominio.servicio.cupon;

import adn.edwin.generadorcitasapi.dominio.Cita;
import adn.edwin.generadorcitasapi.dominio.Cupon;
import adn.edwin.generadorcitasapi.dominio.repositorio.RepositorioCupon;
import adn.edwin.generadorcitasapi.testdatabuilder.CitaTestDataBuilder;
import adn.edwin.generadorcitasapi.testdatabuilder.CuponTestDataBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class ServicioObtenerCuponConsumidoTest {

    private static final Long ID = 50L;
    private static final double PORCENTAJE_DESCUENTO_GENERAR = 10;
    private static final boolean USADO = true;

    private static final Cita CITA = new CitaTestDataBuilder().build();

    @Mock
    private RepositorioCupon repositorioCupon;

    @InjectMocks
    private ServicioObtenerCuponConsumido servicioObtenerCuponConsumido;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void obtenerCupon() {
        //arange
        when(repositorioCupon.obtenerCuponConsumido(CITA))
                .thenReturn(new CuponTestDataBuilder().conInformacionUsado(USADO).build());
        //act
        Cupon cuponBuscado = this.servicioObtenerCuponConsumido.ejecutar(CITA);
        //assert
        assertEquals(ID, cuponBuscado.getId());
        assertEquals(USADO, cuponBuscado.isUsado());
        assertEquals(PORCENTAJE_DESCUENTO_GENERAR, cuponBuscado.getPorcentajeDescuento(), 0);
    }
}
