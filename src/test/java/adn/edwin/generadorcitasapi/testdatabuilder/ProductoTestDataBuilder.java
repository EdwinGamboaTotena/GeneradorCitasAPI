package adn.edwin.generadorcitasapi.testdatabuilder;

import adn.edwin.generadorcitasapi.aplicacion.comando.ComandoProducto;
import adn.edwin.generadorcitasapi.dominio.Producto;

public class ProductoTestDataBuilder {

    private static final Long ID = 90L;
    private static final String NOMBRE = "ProductoTest";
    private static final double PRECIO = 18000;
    private static final boolean GENERA_CUPON = true;
    private static final double PORCENTAJE_DESCUENTO_GENERAR = 10;

    private Long id;
    private String nombre;
    private double precio;
    private boolean generaCupo;
    private double porcentajeDescuentoGenrar;

    public ProductoTestDataBuilder() {
        this.id = ID;
        this.nombre = NOMBRE;
        this.precio = PRECIO;
        this.generaCupo = GENERA_CUPON;
        this.porcentajeDescuentoGenrar = PORCENTAJE_DESCUENTO_GENERAR;
    }

    public ProductoTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ProductoTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ProductoTestDataBuilder conPrecio(double precio) {
        this.precio = precio;
        return this;
    }

    public ProductoTestDataBuilder conGeneradorCupon(boolean generaCupon) {
        this.generaCupo = generaCupon;
        return this;
    }

    public ProductoTestDataBuilder conPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuentoGenrar = porcentajeDescuento;
        return this;
    }

    public Producto build() {
        return new Producto(this.id, this.nombre, this.precio, this.generaCupo, this.porcentajeDescuentoGenrar);
    }

    public ComandoProducto buildComando() {
        return new ComandoProducto(this.id, this.nombre, this.precio, this.generaCupo, this.porcentajeDescuentoGenrar);
    }
}
