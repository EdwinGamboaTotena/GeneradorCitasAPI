package adn.edwin.generadorcitasapi.dominio;

import adn.edwin.generadorcitasapi.dominio.exception.CuponException;
import adn.edwin.generadorcitasapi.testdatabuilder.CitaTestDataBuilder;
import adn.edwin.generadorcitasapi.testdatabuilder.CuponTestDataBuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CuponTest {

    private static final double PORCENTAJE_DESCUENTO = 10;
    private static final Cita CITA_GENERADORA = new CitaTestDataBuilder().build();
    private static final boolean USADO = false;

    private static final double PORCENTAJE_DESCUENTO_ERROR = -0.1;
    private static final Cita CITA_GENERADORA_ERROR = null;

    @Test
    public void crearCupon() {
        //arange
        CuponTestDataBuilder cuponTestDataBuilder = new CuponTestDataBuilder()
                .conPorcentajeDescuento(PORCENTAJE_DESCUENTO)
                .conCitaGenerador(CITA_GENERADORA)
                .conInformacionUsado(USADO);
        //act
        Cupon cupon = cuponTestDataBuilder.build();
        //assert
        assertEquals(PORCENTAJE_DESCUENTO, cupon.getPorcentajeDescuento(), 0);
        assertEquals(CITA_GENERADORA, cupon.getCitaGeneradora());
        assertEquals(USADO, cupon.isUsado());
    }

    @Test
    public void setUsado() {
        //arange
        CuponTestDataBuilder cuponTestDataBuilder = new CuponTestDataBuilder()
                .conInformacionUsado(USADO);
        //act
        Cupon cupon = cuponTestDataBuilder.build();
        cupon.setUsado(true);
        //assert
        assertEquals(true, cupon.isUsado());
    }

    @Test
    public void cuponErrorPorcentajeDescuento() {
        CuponTestDataBuilder cuponTestDataBuilder = new CuponTestDataBuilder()
                .conPorcentajeDescuento(PORCENTAJE_DESCUENTO_ERROR);
        //act
        try {
            Cupon cupon = cuponTestDataBuilder.build();
            fail();
        } catch (CuponException cuponException) {
            assertEquals(Cupon.PORCENTAJE_DESCUENTO_RANGO_INVALIDO, cuponException.getMessage());
        }
    }

    @Test
    public void cuponErrorCitaVacia() {
        CuponTestDataBuilder cuponTestDataBuilder = new CuponTestDataBuilder()
                .conCitaGenerador(CITA_GENERADORA_ERROR);
        //act
        try {
            Cupon cupon = cuponTestDataBuilder.build();
            fail();
        } catch (CuponException cuponException) {
            assertEquals(Cupon.CITA_GENERADORA_NO_PUEDE_SER_VACIA, cuponException.getMessage());
        }
    }
}
