package adn.edwin.generadorcitasapi.dominio.servicio.cupon;

import adn.edwin.generadorcitasapi.dominio.Cupon;
import adn.edwin.generadorcitasapi.dominio.exception.CuponException;
import adn.edwin.generadorcitasapi.dominio.repositorio.RepositorioCupon;

public class ServicioEditarCupon {

    public static final String ESTE_CUPON_NO_ESTA_REGISTRADO =
            "No se puede editar este cupon ya que no esta registrado.";

    private final RepositorioCupon repositorioCupon;

    public ServicioEditarCupon(RepositorioCupon repositorioCupon) {
        this.repositorioCupon = repositorioCupon;
    }

    public Cupon ejecutar(Cupon cupon) {
        if (cupon.getId() == null || cupon.getId() == 0)
            throw new CuponException(ESTE_CUPON_NO_ESTA_REGISTRADO);
        return repositorioCupon.agregar(cupon);
    }
}
