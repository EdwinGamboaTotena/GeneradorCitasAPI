package adn.edwin.generadorcitasapi.aplicacion.comando;

public class ComandoProducto {

    private Long id;
    private String nombre;
    private double precio;
    private boolean generaCupo;
    private double porcetajeCuponGenerar;

    public ComandoProducto(Long id, String nombre, double precio, boolean generaCupo, double porcetajeCuponGenerar) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.generaCupo = generaCupo;
        this.porcetajeCuponGenerar = porcetajeCuponGenerar;
    }

    public double getPrecio() {
        return precio;
    }

    public Long getId() {
        return id;
    }

    public boolean isGeneraCupo() {
        return generaCupo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPorcetajeCuponGenerar() {
        return porcetajeCuponGenerar;
    }
}
