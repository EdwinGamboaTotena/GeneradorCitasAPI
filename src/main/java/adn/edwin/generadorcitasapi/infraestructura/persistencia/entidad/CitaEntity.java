package adn.edwin.generadorcitasapi.infraestructura.persistencia.entidad;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Cita")
@NamedQuery(name = "Cita.findById", query = "SELECT cita FROM Cita cita WHERE cita.id = :id")
@NamedQuery(name = "Cita.findAll", query = "SELECT cita FROM Cita cita")
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

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "id", nullable = false)
    private ProductoEntity productoSolicitado;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_CUPON", referencedColumnName = "id")
    private CuponEntity cuponUsado;

    @Column(nullable = false)
    private String cedulaCliente;

    @Column(nullable = false)
    private double precioProducto;

    @PrePersist
    public void prePersist(){
        this.fechaGeneracion = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaGeneracion() {
        return fechaGeneracion;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public ProductoEntity getProductoSolicitado() {
        return productoSolicitado;
    }

    public void setProductoSolicitado(ProductoEntity productoSolicitado) {
        this.productoSolicitado = productoSolicitado;
    }

    public CuponEntity getCuponUsado() {
        return cuponUsado;
    }

    public void setCuponUsado(CuponEntity cuponUsado) {
        this.cuponUsado = cuponUsado;
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
