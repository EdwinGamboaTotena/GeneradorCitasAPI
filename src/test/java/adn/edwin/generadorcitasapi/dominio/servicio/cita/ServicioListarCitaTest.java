package adn.edwin.generadorcitasapi.dominio.servicio.cita;

import adn.edwin.generadorcitasapi.dominio.Cita;
import adn.edwin.generadorcitasapi.dominio.repositorio.RepositorioCita;
import adn.edwin.generadorcitasapi.testdatabuilder.CitaTestDataBuilder;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.when;

public class ServicioListarCitaTest {

    private static final Long ID_TEST = 25L;
    private static final String CEDULA_TEST = "123456";

    @Mock
    private RepositorioCita repositorioCita;

    @InjectMocks
    private ServicioListarCitas servicioListarCitas;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void listarCitass() {
        //arange
        when(repositorioCita.listaCitas())
                .thenReturn(new ArrayList<>(Arrays.asList(new CitaTestDataBuilder().build())));
        //act
        List<Cita> listaCitas = this.servicioListarCitas.ejecutar();
        //assert
        assertNotEquals(null, listaCitas.get(0));
        assertEquals(ID_TEST, listaCitas.get(0).getId());
        assertEquals(CEDULA_TEST, listaCitas.get(0).getCedulaCliente());
    }
}
