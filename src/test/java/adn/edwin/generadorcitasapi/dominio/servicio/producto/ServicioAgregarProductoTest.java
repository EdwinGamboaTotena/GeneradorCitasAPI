package adn.edwin.generadorcitasapi.dominio.servicio.producto;

import adn.edwin.generadorcitasapi.dominio.Producto;
import adn.edwin.generadorcitasapi.dominio.exception.ProductoException;
import adn.edwin.generadorcitasapi.dominio.repositorio.RepositorioProducto;
import adn.edwin.generadorcitasapi.testdatabuilder.ProductoTestDataBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

import static org.junit.Assert.*;

public class ServicioAgregarProductoTest {

    private static final Long CON_ID = 5L;

    @Mock
    private RepositorioProducto repositorioProducto;

    @InjectMocks
    private ServicioAgregarProducto servicioAgregarProducto;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void agregarProducto() {
        //arange
        ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder()
                .conId(null);
        //act
        Producto producto = productoTestDataBuilder.build();
        when(repositorioProducto.agregar(producto)).thenReturn(new ProductoTestDataBuilder().build());
        Producto productoPersistido = this.servicioAgregarProducto.ejecutar(producto);
        //assert
        assertNotEquals(producto.getId(), productoPersistido.getId());
        assertEquals(producto.getNombre(), productoPersistido.getNombre());
        assertEquals(producto.isGeneraCupo(), productoPersistido.isGeneraCupo());
        assertEquals(producto.getPrecio(), productoPersistido.getPrecio(), 0);
        assertEquals(producto.getPorcetajeCuponGenerar(), productoPersistido.getPorcetajeCuponGenerar(), 0);
    }

    @Test
    public void agregarProductoError() {
        //arange
        ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder()
                .conId(CON_ID);
        //act
        Producto producto = productoTestDataBuilder.build();
        try {
            this.servicioAgregarProducto.ejecutar(producto);
            fail();
        } catch (ProductoException productoException) {
            //assert
            assertEquals(ServicioAgregarProducto.ID_NO_DEBE_ESTAR, productoException.getMessage());
        }
    }
}
