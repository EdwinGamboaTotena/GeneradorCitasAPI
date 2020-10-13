package adn.edwin.generadorcitasapi.dominio.servicio.cupon;

import adn.edwin.generadorcitasapi.dominio.Cupon;
import adn.edwin.generadorcitasapi.dominio.exception.CuponException;
import adn.edwin.generadorcitasapi.dominio.repositorio.RepositorioCupon;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

@Component
public class ServicioObtenerCupon {

    public static final String CUPON_NO_ENCONTRADO = "Este cupon no se encuentra registrado.";

    private RepositorioCupon repositorioCupon;

    public ServicioObtenerCupon(RepositorioCupon repositorioCupon) {
        this.repositorioCupon = repositorioCupon;
    }

    public Cupon ejecutar(Long id) {
        try {
            return this.repositorioCupon.obtener(id);
        } catch (EmptyResultDataAccessException erd) {
            throw new CuponException(CUPON_NO_ENCONTRADO);
        }
    }
}
