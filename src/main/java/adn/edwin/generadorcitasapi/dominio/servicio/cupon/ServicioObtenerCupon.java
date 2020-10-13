package adn.edwin.generadorcitasapi.dominio.servicio.cupon;

import adn.edwin.generadorcitasapi.dominio.Cupon;
import adn.edwin.generadorcitasapi.dominio.exception.CuponException;
import adn.edwin.generadorcitasapi.dominio.repositorio.RepositorioCupon;

public class ServicioObtenerCupon {

    public static final String CUPON_NO_ENCONTRADO = "Este cupon no se encuentra registrado.";

    private RepositorioCupon repositorioCupon;

    public ServicioObtenerCupon(RepositorioCupon repositorioCupon) {
        this.repositorioCupon = repositorioCupon;
    }

    public Cupon ejecutar(Long id) {
        Cupon cupon = this.repositorioCupon.obtener(id);

        if (cupon == null)
            throw new CuponException(CUPON_NO_ENCONTRADO);

        return cupon;
    }
}
