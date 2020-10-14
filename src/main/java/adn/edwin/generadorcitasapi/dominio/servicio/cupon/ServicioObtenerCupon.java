package adn.edwin.generadorcitasapi.dominio.servicio.cupon;

import adn.edwin.generadorcitasapi.dominio.Cupon;
import adn.edwin.generadorcitasapi.dominio.repositorio.RepositorioCupon;

public class ServicioObtenerCupon {


    private RepositorioCupon repositorioCupon;

    public ServicioObtenerCupon(RepositorioCupon repositorioCupon) {
        this.repositorioCupon = repositorioCupon;
    }

    public Cupon ejecutar(Long id) {
        return this.repositorioCupon.obtener(id);
    }
}
