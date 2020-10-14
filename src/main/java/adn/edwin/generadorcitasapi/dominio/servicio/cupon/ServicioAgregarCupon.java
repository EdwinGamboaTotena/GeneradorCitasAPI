package adn.edwin.generadorcitasapi.dominio.servicio.cupon;

import adn.edwin.generadorcitasapi.dominio.Cupon;
import adn.edwin.generadorcitasapi.dominio.exception.CuponException;
import adn.edwin.generadorcitasapi.dominio.repositorio.RepositorioCupon;

public class ServicioAgregarCupon {

    private static final String ID_NO_DEBE_ESTAR = "Si se quiere agregar un nuevo cupon el ID debe ser 0 o null.";

    private final RepositorioCupon repositorioCupon;

    public ServicioAgregarCupon(RepositorioCupon repositorioCupon) {
        this.repositorioCupon = repositorioCupon;
    }

    public void ejecutar(Cupon cupon) {
        if (cupon.getId() != null && cupon.getId() > 0)
            throw new CuponException(ID_NO_DEBE_ESTAR);
        this.repositorioCupon.agregar(cupon);
    }
}
