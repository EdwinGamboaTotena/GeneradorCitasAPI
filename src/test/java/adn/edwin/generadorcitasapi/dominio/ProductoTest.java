package adn.edwin.generadorcitasapi.dominio;

import adn.edwin.generadorcitasapi.dominio.exception.ProductoException;
import adn.edwin.generadorcitasapi.testdatabuilder.ProductoTestDataBuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ProductoTest {

    private static final String NOMBRE = "Amigos";
    private static final double PRECIO = 35;
    private static final boolean GENERA_CUPON = true;
    private static final double PORCENTAJE_DESCUENTO_GENERAR = 10;

    private static final String NOMBRE_ERROR = "";
    private static final double PRECIO_ERROR = 0;
    private static final double PORCENTAJE_DESCUENTO_ERROR = 100.1;

    @Test
    public void crearProdctoTest() {

        //arange
        ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder()
                .conNombre(NOMBRE).conPrecio(PRECIO).conGeneradorCupon(GENERA_CUPON)
                .conPorcentajeDescuento(PORCENTAJE_DESCUENTO_GENERAR);

        //act
        Producto producto = productoTestDataBuilder.build();

        //assert
        assertEquals(NOMBRE, producto.getNombre());
        assertEquals(PRECIO, producto.getPrecio(), 0);
        assertEquals(GENERA_CUPON, producto.isGeneraCupo());
        assertEquals(PORCENTAJE_DESCUENTO_GENERAR, producto.getPorcetajeCuponGenerar(), 0);
    }

    @Test
    public void productoNombreError() {
        //arange
        ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder()
                .conNombre(NOMBRE_ERROR);
        //act
        try {
            Producto producto = productoTestDataBuilder.build();
            fail();
        } catch (ProductoException productoException) {
            //assert
            assertEquals(Producto.PRODUCTO_DEBE_TENER_NOMBRE, productoException.getMessage());
        }
    }

    @Test
    public void productoPrecioError() {
        //arange
        ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder()
                .conPrecio(PRECIO_ERROR);
        //act
        try {
            Producto producto = productoTestDataBuilder.build();
            fail();
        } catch (ProductoException productoException) {
            //assert
            assertEquals(Producto.PRODUCTO_DEBE_TENER_PRECIO, productoException.getMessage());
        }
    }

    @Test
    public void productoPorcentajeDescuentoError() {
        //arange
        ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder()
                .conPorcentajeDescuento(PORCENTAJE_DESCUENTO_ERROR);
        //act
        try {
            Producto producto = productoTestDataBuilder.build();
        } catch (ProductoException productoException) {
            //assert
            assertEquals(Producto.PORCENTAJE_CUPON_RANGO_INVALIDO, productoException.getMessage());
        }
    }
}
