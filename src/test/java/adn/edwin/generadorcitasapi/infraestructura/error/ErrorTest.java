package adn.edwin.generadorcitasapi.infraestructura.error;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ErrorTest {

    private static final String NOMBRE_ERROR = "ErrorTest";
    private static final String MENSAJE_ERROR = "Este es un error de prueba.";

    @Test
    public void errorBuild(){
        //arange
        Error errorTest = new Error(NOMBRE_ERROR, MENSAJE_ERROR);
        //assert
        assertEquals(NOMBRE_ERROR, errorTest.getNombreExcepcion());
        assertEquals(MENSAJE_ERROR, errorTest.getMensaje());
    }
}
