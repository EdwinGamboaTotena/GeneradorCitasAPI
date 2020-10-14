package adn.edwin.generadorcitasapi.infraestructura.persistencia.entidad;

import javax.persistence.*;

@Entity(name = "Producto")
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique= true)
    private String nombre;

    @Column(nullable = false)
    private double precio;

    @Column(nullable = false)
    private boolean generaCupon;

    @Column(nullable = false)
    private double porcentajeCuponGenerar;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isGeneraCupon() {
        return generaCupon;
    }

    public void setGeneraCupon(boolean generaCupon) {
        this.generaCupon = generaCupon;
    }

    public double getPorcentajeCuponGenerar() {
        return porcentajeCuponGenerar;
    }

    public void setPorcentajeCuponGenerar(double porcentajeCuponGenerar) {
        this.porcentajeCuponGenerar = porcentajeCuponGenerar;
    }
}
