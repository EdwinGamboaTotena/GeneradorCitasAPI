package adn.edwin.generadorcitasapi.dominio.servicio.cupon;

import adn.edwin.generadorcitasapi.dominio.Cita;
import adn.edwin.generadorcitasapi.dominio.Cupon;
import adn.edwin.generadorcitasapi.dominio.exception.CuponException;
import adn.edwin.generadorcitasapi.dominio.repositorio.RepositorioCupon;
import adn.edwin.generadorcitasapi.testdatabuilder.CitaTestDataBuilder;
import adn.edwin.generadorcitasapi.testdatabuilder.CuponTestDataBuilder;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class ServicioEditarCuponTest {

    private static final Long CON_ID = 5L;
    private static final Cita CITA_CONSUMIDORA = new CitaTestDataBuilder().build();

    @Mock
    private RepositorioCupon repositorioCupon;

    @InjectMocks
    private ServicioEditarCupon servicioEditarCupon;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void agregarCupon() {
        //arange
        CuponTestDataBuilder cuponTestDataBuilder = new CuponTestDataBuilder()
                .conId(CON_ID);
        //act
        Cupon cupon = cuponTestDataBuilder.build();
        when(repositorioCupon.editar(cupon, CITA_CONSUMIDORA)).thenReturn(new CuponTestDataBuilder().build());
        Cupon cuponPersistido = this.servicioEditarCupon.ejecutar(cupon, CITA_CONSUMIDORA);
        //assert
        assertNotEquals(cupon.getId(), cuponPersistido.getId());
        assertEquals(cupon.isUsado(), cuponPersistido.isUsado());
        assertEquals(cupon.getPorcentajeDescuento(), cuponPersistido.getPorcentajeDescuento(), 0);
    }

    @Test
    public void agregarCuponError() {
        //arange
        CuponTestDataBuilder cuponTestDataBuilder = new CuponTestDataBuilder()
                .conId(null);
        //act
        Cupon cupon = cuponTestDataBuilder.build();
        try {
            this.servicioEditarCupon.ejecutar(cupon, CITA_CONSUMIDORA);
            fail();
        } catch (CuponException cuponException) {
            //assert
            assertEquals(ServicioEditarCupon.ESTE_CUPON_NO_ESTA_REGISTRADO, cuponException.getMessage());
        }
    }
}
