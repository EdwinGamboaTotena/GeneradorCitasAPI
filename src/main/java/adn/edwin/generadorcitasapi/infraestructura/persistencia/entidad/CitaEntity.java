package adn.edwin.generadorcitasapi.infraestructura.persistencia.entidad;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Cita")
@NamedQuery(name = "Cita.findById", query = "SELECT cita FROM Cita cita WHERE cita.id = :id")
@NamedQuery(name = "Cita.findAll", query = "SELECT cita FROM Cita cita")
public class CitaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false, updatable = false)
    private Date fechaGeneracion;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fehcaSolicitud;

    @OneToOne
    @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "id")
    @Column(nullable = false)
    private ProductoEntity productoSolicitado;

    @OneToOne
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

    public Date getFehcaSolicitud() {
        return fehcaSolicitud;
    }

    public void setFehcaSolicitud(Date fehcaSolicitud) {
        this.fehcaSolicitud = fehcaSolicitud;
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