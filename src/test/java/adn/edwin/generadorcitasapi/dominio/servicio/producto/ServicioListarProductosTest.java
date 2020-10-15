package adn.edwin.generadorcitasapi.dominio.servicio.producto;

import adn.edwin.generadorcitasapi.dominio.Producto;
import adn.edwin.generadorcitasapi.dominio.repositorio.RepositorioProducto;
import adn.edwin.generadorcitasapi.testdatabuilder.ProductoTestDataBuilder;
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

public class ServicioListarProductosTest {

    private static final Long ID_TEST = 90L;
    private static final String NOMBRE = "ProductoTest";

    @Mock
    private RepositorioProducto repositorioProducto;

    @InjectMocks
    private ServicioListarProductos servicioListarProductos;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void listarProductos() {
        //arange
        when(repositorioProducto.listaProductos())
                .thenReturn(new ArrayList<>(Arrays.asList(new ProductoTestDataBuilder().build())));
        //act
        List<Producto> listaProductos = this.servicioListarProductos.ejecutar();
        //assert
        assertNotEquals(null, listaProductos.get(0));
        assertEquals(ID_TEST, listaProductos.get(0).getId());
        assertEquals(NOMBRE, listaProductos.get(0).getNombre());
    }
}
