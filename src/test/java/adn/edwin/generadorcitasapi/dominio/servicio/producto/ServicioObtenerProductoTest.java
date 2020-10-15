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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

public class ServicioObtenerProductoTest {

    private static final Long ID_TEST = 90L;
    private static final String NOMBRE = "ProductoTest";
    private static final double PRECIO = 18000;
    private static final boolean GENERA_CUPON = true;
    private static final double PORCENTAJE_DESCUENTO_GENERAR = 10;

    @Mock
    private RepositorioProducto repositorioProducto;

    @InjectMocks
    private ServicioObtenerProducto servicioObtenerProducto;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void obtenerProducto() {
        //arange
        when(repositorioProducto.obtener(ID_TEST))
                .thenReturn(new ProductoTestDataBuilder().build());
        //act
        Producto productoBuscado = this.servicioObtenerProducto.ejecutar(ID_TEST);
        //assert
        assertEquals(ID_TEST, productoBuscado.getId());
        assertEquals(NOMBRE, productoBuscado.getNombre());
        assertEquals(PRECIO, productoBuscado.getPrecio(), 0);
        assertEquals(GENERA_CUPON, productoBuscado.isGeneraCupo());
        assertEquals(PORCENTAJE_DESCUENTO_GENERAR, productoBuscado.getPorcetajeCuponGenerar(), 0);
    }

    @Test
    public void obtenerProductoError() {
        //arange
        when(repositorioProducto.obtener(ID_TEST)).thenReturn(null);
        try {
            //act
            this.servicioObtenerProducto.ejecutar(ID_TEST);
            fail();
        } catch (ProductoException productoException) {
            //assert
            assertEquals(ServicioObtenerProducto.PRODUCTO_NO_ENCONTRADO, productoException.getMessage());
        }
    }

}
