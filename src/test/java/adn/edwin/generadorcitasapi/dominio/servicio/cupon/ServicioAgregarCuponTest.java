package adn.edwin.generadorcitasapi.dominio.servicio.cupon;

import adn.edwin.generadorcitasapi.dominio.Cupon;
import adn.edwin.generadorcitasapi.dominio.exception.CuponException;
import adn.edwin.generadorcitasapi.dominio.repositorio.RepositorioCupon;
import adn.edwin.generadorcitasapi.testdatabuilder.CuponTestDataBuilder;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class ServicioAgregarCuponTest {

    private static final Long CON_ID = 5L;

    @Mock
    private RepositorioCupon repositorioCupon;

    @InjectMocks
    private ServicioAgregarCupon servicioAgregarCupon;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void agregarCupon() {
        //arange
        CuponTestDataBuilder cuponTestDataBuilder = new CuponTestDataBuilder()
                .conId(null);
        //act
        Cupon cupon = cuponTestDataBuilder.build();
        when(repositorioCupon.agregar(cupon)).thenReturn(new CuponTestDataBuilder().build());
        Cupon cuponPersistido = this.servicioAgregarCupon.ejecutar(cupon);
        //assert
        assertNotEquals(cupon.getId(), cuponPersistido.getId());
        assertEquals(cupon.isUsado(), cuponPersistido.isUsado());
        assertEquals(cupon.getPorcentajeDescuento(), cuponPersistido.getPorcentajeDescuento(), 0);
    }

    @Test
    public void agregarCuponError() {
        //arange
        CuponTestDataBuilder cuponTestDataBuilder = new CuponTestDataBuilder()
                .conId(CON_ID);
        //act
        Cupon cupon = cuponTestDataBuilder.build();
        try {
            this.servicioAgregarCupon.ejecutar(cupon);
            fail();
        } catch (CuponException cuponException) {
            //assert
            assertEquals(ServicioAgregarCupon.ID_NO_DEBE_ESTAR, cuponException.getMessage());
        }
    }
}
