package adn.edwin.generadorcitasapi.dominio;

import adn.edwin.generadorcitasapi.dominio.exception.ProductoException;

public class Producto {

    public static final String PRODUCTO_DEBE_TENER_NOMBRE = "El nombre del producto no puede estar vacio.";
    public static final String PRODUCTO_DEBE_TENER_PRECIO = "El precio del producto debe ser mayor a 0.";
    public static final String PORCENTAJE_CUPON_RANGO_INVALIDO =
            "El procentaje de descuento del cupon debe estar entre 0 y 100.";

    private Long id;
    private String nombre;
    private double precio;
    private boolean generaCupo;
    private double porcetajeCuponGenerar;

    public Producto(Long id, String nombre, double precio, boolean generaCupo, double porcetajeCuponGenerar) {
        validarNombre(nombre);
        validarPrecio(precio);
        validarPorcentajeCupon(porcetajeCuponGenerar);
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.generaCupo = generaCupo;
        this.porcetajeCuponGenerar = porcetajeCuponGenerar;
    }

    private void validarNombre(String nombre) {
        if (nombre == null || nombre.trim().length() == 0) {
            throw new ProductoException(PRODUCTO_DEBE_TENER_NOMBRE);
        }
    }

    private void validarPrecio(double precio) {
        if (precio <= 0.0) {
            throw new ProductoException(PRODUCTO_DEBE_TENER_PRECIO);
        }
    }

    private void validarPorcentajeCupon(double procentaje) {
        if (procentaje < 0.0 || procentaje > 100) {
            throw new ProductoException(PORCENTAJE_CUPON_RANGO_INVALIDO);
        }
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean isGeneraCupo() {
        return generaCupo;
    }

    public double getPorcetajeCuponGenerar() {
        return porcetajeCuponGenerar;
    }
}
