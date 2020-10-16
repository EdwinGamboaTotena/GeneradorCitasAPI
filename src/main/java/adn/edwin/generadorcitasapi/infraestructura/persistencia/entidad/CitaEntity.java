package adn.edwin.generadorcitasapi.infraestructura.persistencia.entidad;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Cita")
public class CitaEntity {

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = DATE_FORMAT)
    @Column(nullable = false, updatable = false)
    private Date fechaGeneracion;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = DATE_FORMAT)
    @Column(nullable = false)
    private Date fechaSolicitud;

    @ManyToOne
    @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "id", nullable = false)
    private ProductoEntity productoSolicitado;

    @Column(nullable = false)
    private String cedulaCliente;

    @Column(nullable = false)
    private double precioProducto;

    @PrePersist
    public void prePersist() {
        this.fechaGeneracion = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaGeneracion() {
        return (fechaGeneracion != null) ? (Date) fechaGeneracion.clone() : new Date();
    }

    public Date getFechaSolicitud() {
        return (Date) fechaSolicitud.clone();
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = (Date) fechaSolicitud.clone();
    }

    public ProductoEntity getProductoSolicitado() {
        return productoSolicitado;
    }

    public void setProductoSolicitado(ProductoEntity productoSolicitado) {
        this.productoSolicitado = productoSolicitado;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }
}
