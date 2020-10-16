package adn.edwin.generadorcitasapi.infraestructura.persistencia.entidad;

import javax.persistence.*;

@Entity(name = "Cupon")
public class CuponEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private double porcentajeDescuento;

    @ManyToOne
    @JoinColumn(name = "ID_CITA_GENERADORA", referencedColumnName = "id", unique = true, nullable = false)
    private CitaEntity citaGeneradora;

    @ManyToOne
    @JoinColumn(name = "ID_CITA_CONSUMIDORA", referencedColumnName = "id", unique = true)
    private CitaEntity citaConsumidora;

    @Column(nullable = false)
    private boolean usado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public CitaEntity getCitaGeneradora() {
        return citaGeneradora;
    }

    public void setCitaGeneradora(CitaEntity citaGeneradora) {
        this.citaGeneradora = citaGeneradora;
    }

    public CitaEntity getCitaConsumidora() {
        return citaConsumidora;
    }

    public void setCitaConsumidora(CitaEntity citaConsumidora) {
        this.citaConsumidora = citaConsumidora;
    }

    public boolean isUsado() {
        return usado;
    }

    public void setUsado(boolean usado) {
        this.usado = usado;
    }
}
