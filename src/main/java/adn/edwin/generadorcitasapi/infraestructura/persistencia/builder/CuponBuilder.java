package adn.edwin.generadorcitasapi.infraestructura.persistencia.builder;

import adn.edwin.generadorcitasapi.dominio.Cupon;
import adn.edwin.generadorcitasapi.infraestructura.persistencia.entidad.CuponEntity;

public final class CuponBuilder {

    private static final String INSTANCIA_CLASE_UTILIDAD =
            "La clase CuponBuilder no debe ser instanciada, es una clase de utilidad";

    private CuponBuilder() {
        throw new IllegalStateException(INSTANCIA_CLASE_UTILIDAD);
    }

    public static Cupon convertirADominio(CuponEntity cuponEntity) {
        Cupon cupon = null;
        if (cuponEntity != null && cuponEntity.getId() != null && cuponEntity.getCitaGeneradora() != null) {
            cupon = new Cupon(cuponEntity.getId(), cuponEntity.getPorcentajeDescuento(),
                    CitaBuilder.convertirADominio(cuponEntity.getCitaGeneradora()), cuponEntity.isUsado());
        }
        return cupon;
    }

    public static CuponEntity convertirEntity(Cupon cupon) {
        CuponEntity cuponEntity = new CuponEntity();
        if (cupon != null) {
            cuponEntity.setId(cupon.getId());
            cuponEntity.setUsado(cupon.isUsado());
            cuponEntity.setPorcentajeDescuento(cupon.getPorcentajeDescuento());
            cuponEntity.setCitaGeneradora(CitaBuilder.convertirAEntidad(cupon.getCitaGeneradora()));
        }
        return cuponEntity;
    }
}
