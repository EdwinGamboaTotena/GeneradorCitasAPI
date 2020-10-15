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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

public class ServicioObtenerCuponTest {

    private static final Long ID = 50L;
    private static final double PORCENTAJE_DESCUENTO_GENERAR = 10;
    private static final boolean USADO = false;

    @Mock
    private RepositorioCupon repositorioCupon;

    @InjectMocks
    private ServicioObtenerCupon servicioObtenerCupon;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void obtenerCupon() {
        //arange
        when(repositorioCupon.obtener(ID))
                .thenReturn(new CuponTestDataBuilder().build());
        //act
        Cupon cuponBuscado = this.servicioObtenerCupon.ejecutar(ID);
        //assert
        assertEquals(ID, cuponBuscado.getId());
        assertEquals(USADO, cuponBuscado.isUsado());
        assertEquals(PORCENTAJE_DESCUENTO_GENERAR, cuponBuscado.getPorcentajeDescuento(), 0);
    }

    @Test
    public void obtenerCuponError() {
        //arange
        when(repositorioCupon.obtener(ID)).thenReturn(null);
        try {
            //act
            this.servicioObtenerCupon.ejecutar(ID);
            fail();
        } catch (CuponException cuponException) {
            //assert
            assertEquals(ServicioObtenerCupon.CUPON_NO_ENCONTRADO, cuponException.getMessage());
        }
    }

}
