package adn.edwin.generadorcitasapi.infraestructura.persistencia.builder;

import adn.edwin.generadorcitasapi.dominio.Cita;
import adn.edwin.generadorcitasapi.infraestructura.persistencia.entidad.CitaEntity;

public final class CitaBuilder {

    public static Cita convertirADominio(CitaEntity citaEntity) {

        Cita cita = null;

        if (citaEntity != null) {
            cita = new Cita(citaEntity.getId(), citaEntity.getFechaGeneracion(), citaEntity.getFechaSolicitud(),
                    ProductoBuilder.convertirADominio(citaEntity.getProductoSolicitado()),
                    CuponBuilder.convertirADominio(citaEntity.getCuponUsado()),
                    citaEntity.getCedulaCliente(), citaEntity.getPrecioProducto());
        }

        return cita;
    }

    public static CitaEntity convertirAEntidad(Cita cita) {

        CitaEntity citaEntity = new CitaEntity();
        citaEntity.setId(cita.getId());
        citaEntity.setFechaSolicitud(cita.getFechaSolicitud());
        citaEntity.setCedulaCliente(cita.getCedulaCliente());
        citaEntity.setPrecioProducto(cita.getPrecioProducto());
        citaEntity.setProductoSolicitado(ProductoBuilder.convertirAEntity(cita.getProductoSolicitado()));
        citaEntity.setCuponUsado(CuponBuilder.convertirEntity(cita.getCuponUsado()));

        return citaEntity;
    }
}
